package pl.psi;

import java.util.*;

import pl.psi.creatures.Creature;

import lombok.Getter;
import pl.psi.skills.Armorer;
import pl.psi.skills.Skill;
import pl.psi.skills.SkillEnum;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Hero {
    @Getter
    private List<Creature> creatures;
    private final Map<SkillEnum, Skill> skills;

    public Hero(final List<Creature> aCreatures) {
        creatures = aCreatures;
        skills = new HashMap();
    }

    public Hero(List<Creature> creatures, Map<SkillEnum, Skill> skills) {
        this.creatures = creatures;
        this.skills = skills;
    }

    public void castSkill(SkillEnum skillEnum) {
        Skill skillToCast = skills.get(skillEnum);
        skillToCast.cast(creatures);
    }

    public void addSkill(Skill aSkill) {
        skills.put(aSkill.getSkillEnum(), aSkill);
    }
}
