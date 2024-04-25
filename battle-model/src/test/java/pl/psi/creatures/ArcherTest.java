package pl.psi.creatures;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.Hero;
import pl.psi.Point;

import static org.assertj.core.api.Assertions.assertThat;
import pl.psi.GameEngine;

public class ArcherTest

{
    @Test
    void archerCanAttackWholeMap()
    {
        //given
        final Hero archer_hero = new Hero( List.of( new CastleCreatureFactory().create( false, 2, 5 ) ) );
        final Hero skeleton_warrior_hero = new Hero( List.of( new NecropolisFactory().create( true, 1, 5 ) ) );

        Point skeleton_warrior_point = new Point(14, 1);
        Point archer_point = new Point(0,1);

        final GameEngine g_e = new GameEngine( archer_hero, skeleton_warrior_hero );

        // Checking if both creatures are where they should be
        assertThat(g_e.getCreature(skeleton_warrior_point)).isPresent();
        assertThat(g_e.getCreature(archer_point)).isPresent();

        // Checking if current creature is skeleton_warrior
        g_e.pass();
        assertThat(g_e.getCreature(skeleton_warrior_point)).isPresent().contains(g_e.getCurrentCreature());
        // Checking if skeleton_warrior can attack skeleton
        assertThat(g_e.canAttack(archer_point)).isEqualTo(false);

        //grabbing archer
        Creature archer_creature = g_e.getCreature(archer_point)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        //grabbing skeleton warrior
        Creature skeleton_warrior_creature = g_e.getCreature(skeleton_warrior_point)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        // Checking HP before and after attacking archer
        assertThat(archer_creature.getCurrentHp()).isEqualTo(10);
        g_e.attack(archer_point);
        assertThat(archer_creature.getCurrentHp()).isEqualTo(10); // HP should not change as archer is out of range for skeleton_warrior
        g_e.pass(); //we need to switch to archer since the attack did not occur
        //archer attacks skeleton warrior
        assertThat(g_e.getCurrentCreature()).isEqualTo(archer_creature);
        assertThat(skeleton_warrior_creature.getCurrentHp()).isEqualTo(6);
        g_e.attack(skeleton_warrior_point);
        assertThat(skeleton_warrior_creature.getCurrentHp()).isIn(2,3); //
    }

}

