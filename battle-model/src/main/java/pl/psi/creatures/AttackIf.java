package pl.psi.creatures;

import pl.psi.Point;

public interface AttackIf {
    boolean canAttack(Point attackerPosition, Point targetPosition);
}
