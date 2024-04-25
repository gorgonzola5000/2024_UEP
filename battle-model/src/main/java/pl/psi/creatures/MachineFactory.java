package pl.psi.creatures;

import java.util.List;

public class MachineFactory
{   private static final String EXCEPTION_MESSAGE = "We support tiers from 8 to 10";
    public Creature create( final boolean aIsUpgraded, final int aTier, final int aAmount )
    {
            switch( aTier )
            {
                case 8:
                    return new Creature.Builder().statistic( CreatureStatistic.FIRST_AID_TENT )
                            .amount( aAmount )
                            .build();
                case 9:
                    return new Creature.Builder().statistic( CreatureStatistic.BALLISTA )
                            .amount( aAmount )
                            .build();
                case 10:
                    return new Creature.Builder().statistic( CreatureStatistic.CATAPULT )
                            .amount( aAmount )
                            .build();

                default:
                    throw new IllegalArgumentException( EXCEPTION_MESSAGE );
            }
    }

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