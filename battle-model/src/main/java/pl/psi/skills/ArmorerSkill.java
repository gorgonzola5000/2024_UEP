package pl.psi.skills;

import pl.psi.creatures.ArmoredCreature;
import pl.psi.creatures.Creature;

import java.util.List;

public class ArmorerSkill extends Skill {
    public ArmorerSkill(int aLevel) {
        super(SkillEnum.ARMORER, aLevel);
    }


    @Override
    public void cast(List<Creature> creatures) {
        creatures.replaceAll(decorated -> new ArmoredCreature(decorated, level));
    }
}
