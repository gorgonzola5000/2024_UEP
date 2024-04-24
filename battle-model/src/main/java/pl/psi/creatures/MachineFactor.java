package pl.psi.creatures;

import java.util.List;

public class MachineFactor {

    public void HealHPCreature(Creature creature) {
        creature.restoreCurrentHpToMax();
    }

    public void ChooseHealCreature(List<Creature> creatureList) {
        Creature smallHP = creatureList.get(0);
        for (Creature creature : creatureList) {
            if (creature.getCurrentHp()<smallHP.getCurrentHp()){
                smallHP=creature;
            }

        }
        HealHPCreature(smallHP);

    }

}