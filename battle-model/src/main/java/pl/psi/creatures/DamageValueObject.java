package pl.psi.creatures;

import lombok.Getter;
import pl.psi.enums.AttackTypeEnum;
import pl.psi.enums.CreatureTypeEnum;

public class DamageValueObject {
        @Getter
        private int damageAmount;
        private AttackTypeEnum attackType;
        private CreatureTypeEnum creatureType;

        public DamageValueObject(int aDamageAmount, AttackTypeEnum aAttackType, CreatureTypeEnum aCreatureType) {
            damageAmount = aDamageAmount;
            attackType = aAttackType;
            creatureType = aCreatureType;
        }
}
