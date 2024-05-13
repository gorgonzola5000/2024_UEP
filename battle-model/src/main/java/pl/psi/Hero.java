package pl.psi;

import lombok.Getter;
import pl.psi.creatures.Creature;

import java.util.List;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Hero {
    @Getter
    private final List<Creature> creatures;

    public Hero(final List<Creature> aCreatures) {
        creatures = aCreatures;
    }
}
