package pl.psi.creatures;

import lombok.Getter;
import pl.psi.enums.AttackTypeEnum;
import pl.psi.enums.CreatureTypeEnum;

public interface DamageCalculatorIf
{
    int calculateDamage( Creature aAttacker, Creature aDefender );
}
