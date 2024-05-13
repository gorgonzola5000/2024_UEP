package pl.psi;

import org.junit.jupiter.api.Test;
import pl.psi.creatures.CastleCreatureFactory;

import java.util.List;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class GameEngineTest {
    @Test
    void shoudWorksHeHe() {
        final CastleCreatureFactory creatureFactory = new CastleCreatureFactory();
        final GameEngine gameEngine =
                new GameEngine(new Hero(List.of(creatureFactory.create(false, 1, 5))),
                        new Hero(List.of(creatureFactory.create(false, 1, 5))));

        gameEngine.attack(new Point(1, 1));
    }
}
