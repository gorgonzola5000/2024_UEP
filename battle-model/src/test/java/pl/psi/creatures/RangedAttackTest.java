package pl.psi.creatures;

import org.junit.jupiter.api.Test;
import pl.psi.GameEngine;
import pl.psi.Hero;
import pl.psi.Point;
import pl.psi.spells.SampleSpell;
import pl.psi.spells.Spellbook;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RangedAttackTest {

    @Test
    void archerCanAttackWholeMap() {
        //given
        final Hero archerHero = new Hero(List.of(new CastleCreatureFactory().create(false, 2, 5)),
                new Spellbook(List.of(new SampleSpell())));
        final Hero skeletonWarriorHero = new Hero(List.of(new NecropolisFactory().create(true, 1, 5)),
                new Spellbook(List.of(new SampleSpell())));

        Point skeletonWarriorPoint = new Point(14, 1);
        Point archerPoint = new Point(0, 1);

        final GameEngine gameEngine = new GameEngine(archerHero, skeletonWarriorHero);

        // Checking if both creatures are where they should be
        assertThat(gameEngine.getCreature(skeletonWarriorPoint)).isPresent();
        assertThat(gameEngine.getCreature(archerPoint)).isPresent();

        //grabbing archer
        Creature archerCreature = gameEngine.getCreature(archerPoint)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        //grabbing skeleton warrior
        Creature skeletonWarriorCreature = gameEngine.getCreature(skeletonWarriorPoint)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        // Checking if current creature is archerCreature
        assertThat(archerCreature).isEqualTo(gameEngine.getCurrentCreature());
        // Checking if archer can attack skeleton_warrior
        assertThat(gameEngine.canAttack(skeletonWarriorPoint)).isEqualTo(true);

        // Checking HP before and after attacking skeleton_warrior
        assertThat(skeletonWarriorCreature.getCurrentHp()).isEqualTo(6);
        gameEngine.attack(skeletonWarriorPoint);
        assertThat(skeletonWarriorCreature.getCurrentHp()).isIn(2, 3);

        // TODO make sure melee creature can't counter attack from a mile away
    }
}
