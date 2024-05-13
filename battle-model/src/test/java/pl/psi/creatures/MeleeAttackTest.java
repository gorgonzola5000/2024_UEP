package pl.psi.creatures;

import org.junit.jupiter.api.Test;
import pl.psi.GameEngine;
import pl.psi.Hero;
import pl.psi.Point;
import pl.psi.spells.SampleSpell;
import pl.psi.spells.Spellbook;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MeleeAttackTest {
    @Test
    void meleeAttackWorks() {

        //given
        final Hero skeletonHero = new Hero(List.of(new NecropolisFactory().create(false, 1, 5)),
                new Spellbook(List.of(new SampleSpell())));
        final Hero skeletonWarriorHero = new Hero(List.of(new NecropolisFactory().create(true, 1, 5)),
                new Spellbook(List.of(new SampleSpell())));

        Point skeletonWarriorPoint = new Point(14, 1);
        Point skeletonPoint = new Point(0, 1);

        final GameEngine gameEngine = new GameEngine(skeletonHero, skeletonWarriorHero);

        assertThat(gameEngine.getCreature(skeletonWarriorPoint)).isPresent();
        assertThat(gameEngine.getCreature(skeletonPoint)).isPresent();

        // Checking if current creature is skeleton_warrior
        gameEngine.pass();
        assertThat(gameEngine.getCreature(skeletonWarriorPoint)).isPresent().contains(gameEngine.getCurrentCreature());
        // Checking if skeleton_warrior can attack skeleton
        assertThat(gameEngine.canAttack(skeletonPoint)).isEqualTo(false);
        Creature creature = gameEngine.getCreature(skeletonPoint)
                .orElseThrow(() -> new IllegalStateException("Creature not found at point2"));

        // Trying to attack distant creature
        assertThrows(IllegalStateException.class, () -> {
            gameEngine.attack((skeletonPoint));
        });
    }
}