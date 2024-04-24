package pl.psi.creatures;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class CastleCreatureFactory
{
    public Creature create( final boolean aIsUpgraded, final int aTier, final int aAmount )
    {
        if( aIsUpgraded )
        {
            switch( aTier )
            {
                case 1:
                    return new Creature.Builder().statistic( CreatureStatistic.BLACK_KNIGHT )
                        .amount( aAmount )
                        .build();
                case 2:
                    return new Creature.Builder().statistic(CreatureStatistic.ARCHER)
                        .amount(aAmount)
                            .canAttack(new RangedAttackStrategy())
                        .build();
            }
        }
        else
        {
            switch( aTier )
            {
                case 1:
                    return new Creature.Builder().statistic( CreatureStatistic.BLACK_KNIGHT )
                        .amount( aAmount )
                        .build();
                case 2:
                    return new Creature.Builder().statistic(CreatureStatistic.ARCHER)
                        .amount(aAmount)
                        .build();
            }
        }
        throw new IllegalArgumentException( "Cannot recognize creature by tier and upgrade or not." );
    }
}
