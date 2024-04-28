package pl.psi.skills;

import pl.psi.creatures.Creature;
import pl.psi.creatures.DamageApplier;
import pl.psi.creatures.DamageValueObject;

public class ArmoredDamageApplier extends DamageApplier {
    private int level;
    private DamageApplier decorated;

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
    protected int calculateHpToSubtract(DamageValueObject aDamageValueObject) {
        int hpToSubtract = aDamageValueObject.getDamageAmount() % getCreature().getMaxHp();
//        if (aDamageValueObject.getAttackType().equals(AttackTypeEnum.MELEE) || aDamageValueObject.getAttackType().equals(AttackTypeEnum.RANGE)) {
            return (int) Math.round(hpToSubtract * getMultiplier());
//        }
//        return hpToSubtract;
    }


    @Override
    public void applyDamage(DamageValueObject aDamageValueObject) {
        decorated.applyDamage(aDamageValueObject);
    }

    @Override
    public Creature getCreature() {
        return decorated.getCreature();
    }
}
