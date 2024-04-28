package pl.psi.skills;

import pl.psi.creatures.ArmoredDamageApplier;
import pl.psi.creatures.Creature;
import pl.psi.creatures.DamageApplier;
import pl.psi.enums.SkillEnum;

import java.util.List;

public class ArmorerSkill extends Skill {
    public ArmorerSkill(int aLevel) {
        super(SkillEnum.ARMORER, aLevel);
    }


    @Override
    public void cast(List<Creature> creatures) {
        creatures.forEach(c -> c.setDamageApplier(new ArmoredDamageApplier(c.getDamageApplier(), level)));
    }
}
