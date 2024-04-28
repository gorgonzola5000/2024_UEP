package pl.psi.skills;

import lombok.Getter;
import pl.psi.creatures.Creature;
import pl.psi.enums.SkillEnum;

import java.util.List;
import java.util.Objects;

public abstract class Skill {

    protected int level;
    @Getter
    protected SkillEnum skillName;

    public Skill(SkillEnum aSkillEnum, int aLevel) {
        level = validateLevel(aLevel);
        skillName = aSkillEnum;
    }

    public void cast(List<Creature> creatures) {

    }

    public int validateLevel(int aLevel) {
        int levelToReturn;
        if (aLevel < 1) {
            levelToReturn = 1;
        } else levelToReturn = Math.min(aLevel, 3);
        return levelToReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return level == skill.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
