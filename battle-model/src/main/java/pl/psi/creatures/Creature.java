package pl.psi.creatures;//  ******************************************************************

//
//  Copyright 2022 PSI Software AG. All rights reserved.
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
//  ******************************************************************

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import lombok.Setter;
import pl.psi.enums.AttackTypeEnum;
import pl.psi.TurnQueue;

import com.google.common.collect.Range;

import lombok.Getter;
import pl.psi.enums.CreatureTypeEnum;
import pl.psi.enums.SkillEnum;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Getter
public class Creature implements PropertyChangeListener {
    private CreatureStatisticIf stats;
    @Setter
    private int amount;
    private int currentHp;
    private int counterAttackCounter = 1;
    private DamageCalculatorIf calculator;
    private CreatureTypeEnum creatureType;
    private AttackTypeEnum attackType;
    private DamageApplier damageApplier;

    Creature() {
    }

    private Creature(final CreatureStatisticIf aStats, final DamageCalculatorIf aCalculator,
                     final int aAmount, CreatureTypeEnum aCreatureType, AttackTypeEnum aAttackType) {
        stats = aStats;
        amount = aAmount;
        currentHp = stats.getMaxHp();
        calculator = aCalculator;
        damageApplier = new DamageApplier(this); //maybe should initialize it like counterAttackCounter
        creatureType = aCreatureType;
        attackType = aAttackType;
    }


    public void attack(final Creature aDefender) {
        if (isAlive()) {
            final int damage = getCalculator().calculateDamage(this, aDefender);
            DamageValueObject damageObject = new DamageValueObject(damage, this.attackType, this.creatureType);
            aDefender.applyDamage(damageObject);
            if (canCounterAttack(aDefender)) {
                counterAttack(aDefender);
            }
        }
    }

    public boolean isAlive() {
        return getAmount() > 0;
    }

    private void applyDamage(DamageValueObject aDamageValueObject) {
        getDamageApplier().applyDamage(aDamageValueObject);
    }

    public int getMaxHp() {
        return stats.getMaxHp();
    }

    protected void setCurrentHp(final int aCurrentHp) {
        currentHp = aCurrentHp;
    }

    private boolean canCounterAttack(final Creature aDefender) {
        return aDefender.getCounterAttackCounter() > 0 && aDefender.getCurrentHp() > 0;
    }

    private void counterAttack(final Creature aAttacker) {
        final int damage = aAttacker.getCalculator()
                .calculateDamage(aAttacker, this);
        DamageValueObject aDamageValueObject = new DamageValueObject(damage, this.attackType, this.creatureType);
        applyDamage(aDamageValueObject);
        aAttacker.counterAttackCounter--;
    }

    //potencjalnie lepiej zamiast skillEnuma dawac jako parametr dekorator DamageAppliera
    public void decorateDamageApplier(SkillEnum aSkillEnum, int level) {
        switch (aSkillEnum) {
            case ARMORER:
                damageApplier = new ArmoredDamageApplierDecorator(damageApplier, level);
        }
    }

    public void decorateCalculator(SkillEnum aSkillEnum, int level) {
        switch (aSkillEnum) {
            case OFFENSE:
                calculator = new OffenseCalculatorDecorator(calculator, level);
        }
    }


    Range<Integer> getDamage() {
        return stats.getDamage();
    }

    int getAttack() {
        return stats.getAttack();
    }

    int getArmor() {
        return stats.getArmor();
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if (TurnQueue.END_OF_TURN.equals(evt.getPropertyName())) {
            counterAttackCounter = 1;
        }
    }

    protected void restoreCurrentHpToMax() {
        currentHp = stats.getMaxHp();
    }

    public String getName() {
        return stats.getName();
    }

    public int getMoveRange() {
        return stats.getMoveRange();
    }

    public static class Builder {
        private int amount = 1;
        private DamageCalculatorIf calculator = new DefaultDamageCalculator(new Random());
        private CreatureStatisticIf statistic;
        private final CreatureTypeEnum creatureType = CreatureTypeEnum.GROUND;
        private final AttackTypeEnum attackType = AttackTypeEnum.MELEE;

        public Builder statistic(final CreatureStatisticIf aStatistic) {
            statistic = aStatistic;
            return this;
        }

        public Builder amount(final int aAmount) {
            amount = aAmount;
            return this;
        }

        Builder calculator(final DamageCalculatorIf aCalc) {
            calculator = aCalc;
            return this;
        }

        public Creature build() {
            return new Creature(statistic, calculator, amount, creatureType, attackType);
        }
    }

    @Override
    public String toString() {
        return getName() + System.lineSeparator() + getAmount();
    }
}
