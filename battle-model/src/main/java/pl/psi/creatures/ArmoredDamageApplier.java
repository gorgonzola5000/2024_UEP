package pl.psi.creatures;

import pl.psi.enums.AttackTypeEnum;

public class ArmoredDamageApplier extends DamageApplier {
    private final int level;
    private final DamageApplier decorated;

    public ArmoredDamageApplier(DamageApplier aDecorated, int aLevel) {
        decorated = aDecorated;
        if (aLevel < 1) {
            level = 1;
        } else level = Math.min(aLevel, 3);
    }

    private double getMultiplier() {
        switch (level) {
            case 1:
                return 0.95;
            case 2:
                return 0.9;
            case 3:
                return 0.85;
            default:
                return 1;
        }
    }

    @Override
    public void applyDamage(DamageValueObject aDamageValueObject) {
        int hpToSubstract = calculateHpToSubtract(aDamageValueObject);
        int amountToSubstract = Math.round(aDamageValueObject.getDamageAmount() / getCreature().getMaxHp());
        int hp = getCreature().getCurrentHp() - hpToSubstract;
        if (hp <= 0) {
            getCreature().setCurrentHp(getCreature().getMaxHp() - hp);
            getCreature().setAmount(getCreature().getAmount() - 1);
        } else {
            getCreature().setCurrentHp(hp);
        }
        getCreature().setAmount(getCreature().getAmount() - amountToSubstract);
    }

    private int calculateHpToSubtract(DamageValueObject aDamageValueObject) {
        int hpToSubtract = aDamageValueObject.getDamageAmount() % getCreature().getMaxHp();
        if (aDamageValueObject.getAttackType().equals(AttackTypeEnum.MELEE) || aDamageValueObject.getAttackType().equals(AttackTypeEnum.RANGE)) {
            return (int) (hpToSubtract * getMultiplier());
        }
        return hpToSubtract;
    }

    @Override
    public Creature getCreature() {
        return decorated.getCreature();
    }
}
