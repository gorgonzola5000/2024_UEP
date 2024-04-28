package pl.psi.skills;

import pl.psi.creatures.Creature;
import pl.psi.enums.SkillEnum;

import java.util.List;

public class ArmorerSkill extends Skill {
    public ArmorerSkill(int aLevel) {
        super(SkillEnum.ARMORER, aLevel);
    }


    @Override
    public void cast(List<Creature> creatures) {
        creatures.forEach(c -> c.decorateDamageApplier(SkillEnum.ARMORER, level));
    }
}
