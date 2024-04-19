package pl.psi.skills;

import pl.psi.creatures.ArmoredCreature;
import pl.psi.creatures.Creature;

import java.util.List;

public class Armorer extends Skill {

    public Armorer(int aLevel) {
        super(SkillEnum.ARMORER, aLevel);
    }


    @Override
    public void cast(List<Creature> creatures) {
        for (int i = 0; i < creatures.size(); i++) {
            Creature newCreature = new ArmoredCreature(creatures.get(i), level);
            creatures.set(i, newCreature);
        }
    }
}
