package pl.psi.creatures;

import pl.psi.Point;

public class RangedAttackStrategy extends AbstractAttackStrategy {
    public RangedAttackStrategy() {
        super();
    }

    @Override
    public boolean canAttack(final Point attackerPosition, final Point targetPosition) {
        return !attackerPosition.equals(targetPosition);
    }
}

