package pl.psi.creatures;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import org.mockito.internal.matchers.Null;
import pl.psi.Hero;
import pl.psi.Point;

import static org.assertj.core.api.Assertions.assertThat;
import pl.psi.GameEngine;

public class ArcherTest

{
    private static final Range<Integer> NOT_IMPORTANT_DMG = Range.closed(0, 0);
    @Test
    void shoudWorksHeHe()
    {
        //given
        final Hero skeleton = new Hero( List.of( new NecropolisFactory().create( true, 1, 5 ) ) );
        final Hero skeleton_warrior = new Hero( List.of( new NecropolisFactory().create( false, 1, 5 ) ) );

        Point skeleton_point = new Point(14, 1);
        Point warrior_point = new Point(0,1);

        final GameEngine g_e = new GameEngine( skeleton, skeleton_warrior );

        // Checking if both creatures are where they should be
        assertThat(g_e.getCreature(skeleton_point)).isPresent();
        assertThat(g_e.getCreature(warrior_point)).isPresent();

        // Checking if current creature is skeleton_warrior
        assertThat(g_e.getCreature(warrior_point)).isPresent().contains(g_e.getCurrentCreature());
        // Checking if skeleton_warrior can attack skeleton
        assertThat(g_e.canAttack(skeleton_point)).isEqualTo(false);
        Creature creature = g_e.getCreature(skeleton_point)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        // Checking HP before and after attacking
        assertThat(creature.getCurrentHp()).isEqualTo(6);
        g_e.attack(skeleton_point);
        assertThat(creature.getCurrentHp()).isEqualTo(6);
    }
    @Test
    void shoudWorksHeHe2()
    {
//given
        final Hero archer = new Hero( List.of( new CastleCreatureFactory().create( false, 1, 5 ) ) );
        final Hero skeleton_warrior = new Hero( List.of( new NecropolisFactory().create( false, 1, 5 ) ) );

        Point archer_point = new Point(14, 1);
        Point warrior_point = new Point(0,1);

        final GameEngine g_e = new GameEngine( archer, skeleton_warrior );

        // Checking if both creatures are where they should be
        assertThat(g_e.getCreature(archer_point)).isPresent();
        assertThat(g_e.getCreature(warrior_point)).isPresent();

        // Checking if current creature is skeleton_warrior
        assertThat(g_e.getCreature(warrior_point)).isPresent().contains(g_e.getCurrentCreature());
        // Checking if skeleton_warrior can attack skeleton
        assertThat(g_e.canAttack(archer_point)).isEqualTo(false);
        Creature creature = g_e.getCreature(archer_point)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        // Checking HP before and after attacking
        assertThat(creature.getCurrentHp()).isEqualTo(6);
        g_e.attack(archer_point);
        assertThat(creature.getCurrentHp()).isEqualTo(6); // HP should not change as archer is out of range for skeleton_warrior
        g_e.attack(warrior_point);
        assertThat(g_e.getCreature(warrior_point).get().getCurrentHp()).isEqualTo(6);
    }
}
