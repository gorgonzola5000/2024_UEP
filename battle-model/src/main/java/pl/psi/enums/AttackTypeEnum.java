package pl.psi.enums;

import pl.psi.Point;

public enum AttackTypeEnum {
    MELEE {
        @Override
        public boolean canAttack(final Point attackerPosition, final Point targetPosition) {
            return attackerPosition.distance(targetPosition) == 1;
        }
    }, RANGED {
        @Override
        public boolean canAttack(final Point attackerPosition, final Point targetPosition) {
            return !attackerPosition.equals(targetPosition);
        }
    }, SPELL;

    public boolean canAttack(Point position, Point point) {
        return false; // Default implementation, can be overridden by each enum constant
    }
}
