package pl.psi;

import java.util.*;

import pl.psi.creatures.Creature;

import lombok.Getter;
import pl.psi.skills.Skill;
import pl.psi.enums.SkillEnum;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Hero {
    @Getter
    private final List<Creature> creatures;
    private final Map<SkillEnum, Skill> skills;

    public Hero(final List<Creature> aCreatures) {
        creatures = aCreatures;
        skills = new HashMap<>();
    }


    public void castSkill(SkillEnum skillEnum) {
        Skill skillToCast = skills.get(skillEnum);
        skillToCast.cast(creatures);
    }

    public void addSkill(Skill aSkill) {
        skills.put(aSkill.getSkillName(), aSkill);
    }


}
