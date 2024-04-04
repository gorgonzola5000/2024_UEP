package pl.psi.creatures;//  ******************************************************************

//
//  Copyright 2022 PSI Software AG. All rights reserved.
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
//  ******************************************************************

import java.util.Random;

import com.google.common.collect.Range;

import lombok.Getter;

@Getter
public class Creature
{
    private final CreatureStatistic statistic;
    private final DamageCalculator damageCalculator;
    private int amount;
    private int currentHp;

    public Creature( final CreatureStatistic aStats, final int aAmount )
    {
        this( aStats, aAmount, new Random() );
    }

    public Creature( final CreatureStatistic aStats, final int aAmount, Random aRandom )
    {
        statistic = aStats;
        currentHp = aStats.getMaxHp();
        amount = aAmount;
        damageCalculator = new DamageCalculator( aRandom );
    }

    public Range< Integer > getDamage()
    {
        return statistic.getDamage();
    }

    public int getAttack()
    {
        return statistic.getAttack();
    }

    public int getArmor()
    {
        return statistic.getArmor();
    }

    public int getSpeed()
    {
        return statistic.getSpeed();
    }

    public void attack( Creature aDefender )
    {
        int dmg = damageCalculator.calculateDamage( this, aDefender );
        aDefender.applyDamage( dmg );
        aDefender.retaliation( this );
    }

    private void retaliation( Creature aCreature )
    {
        int dmg = damageCalculator.calculateDamage( this, aCreature );
        aCreature.applyDamage( dmg );
    }

    void applyDamage( int aDmg )
    {
        int stackHp = ((amount - 1) * getStatistic().getMaxHp()) + currentHp;
        int newStackHp = stackHp - aDmg;
        amount = (int)Math.floor( newStackHp / getStatistic().getMaxHp() + 1 );
        int newCurrentHp = newStackHp % getStatistic().getMaxHp();
        if( newCurrentHp == 0 )
        {
            currentHp = getStatistic().getMaxHp();
            amount--;
        }
        else
        {
            currentHp = newCurrentHp;
        }
    }

}
