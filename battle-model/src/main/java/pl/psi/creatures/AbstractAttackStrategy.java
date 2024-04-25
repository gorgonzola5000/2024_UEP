package pl.psi.creatures;

import pl.psi.Point;

abstract class AbstractAttackStrategy implements AttackIf {
    public boolean canAttack(final Point attackerPosition, final Point targetPosition) {
        return attackerPosition.distance(targetPosition) == 1;
    }
}