package skills;

import pl.psi.creatures.Creature;
import pl.psi.enums.SkillEnum;
import pl.psi.skills.Skill;

import java.util.List;

public abstract class BattleSkill extends Skill {
    public BattleSkill(SkillEnum aSkillEnum, int aLevel) {
        super(aSkillEnum, aLevel);
    }

    public abstract void cast(List<Creature> creatures);
}
