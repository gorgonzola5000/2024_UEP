package pl.psi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.psi.creatures.Creature;

import lombok.Getter;
import pl.psi.skills.Skill;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Hero
{
    @Getter
    private final List< Creature > creatures;
    @Getter
    private final Set<Skill> skills;

    public Hero( final List< Creature > aCreatures)
    {
        creatures = aCreatures;
        skills = new HashSet<>();
    }

    public void castSkill() {

    }
}
