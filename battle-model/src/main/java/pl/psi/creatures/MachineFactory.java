package pl.psi.creatures;

import java.util.List;

public class MachineFactory extends Creature {

    public void healHPCreature(Creature creature) {
        creature.restoreCurrentHpToMax();
    }

    public void chooseHealCreature(List<Creature> creatureList) {
        Creature smallHP = creatureList.get(0);
        for (Creature creature : creatureList) {
            if (creature.getCurrentHp()<smallHP.getCurrentHp()){
                smallHP=creature;
            }

        }
        healHPCreature(smallHP);

    }

}