package pl.psi.creatures;

import lombok.Getter;

@Getter
public class DamageApplier {
    private Creature creature;

    public DamageApplier(Creature creature) {
        this.creature = creature;
    }

    public DamageApplier() {
    }

    public void applyDamage(DamageValueObject aDamageValueObject) {
        int hpToSubstract = aDamageValueObject.getDamageAmount() % getCreature().getMaxHp();
        int amountToSubstract = Math.round(aDamageValueObject.getDamageAmount() / getCreature().getMaxHp());

        dealDamageToCreature(hpToSubstract, amountToSubstract);
    }

    //wymyslic lepsza nazwe
    public void dealDamageToCreature(int hpToSubstract, int amountToSubstract) {
        int hp = getCreature().getCurrentHp() - hpToSubstract;
        if (hp <= 0) {
            getCreature().setCurrentHp(getCreature().getMaxHp() - hp);
            getCreature().setAmount(getCreature().getAmount() - 1);
        }
        else{
            getCreature().setCurrentHp(hp);
        }
        getCreature().setAmount(getCreature().getAmount() - amountToSubstract);
    }

}
