package pl.psi.creatures;

import java.util.Random;

public class OffenseCalculatorDecorator extends AbstractCalculateDamageStrategy {
    private final int level;
    private final AbstractCalculateDamageStrategy decorated;


    public OffenseCalculatorDecorator(DamageCalculatorIf aDecorated, int aLevel) {
        super(new Random()); //todo tu raczej trzeba bedzie przekazac tego randoma w jakis sposob niz robic nowego
        decorated = (AbstractCalculateDamageStrategy) aDecorated;
        level = aLevel;
    }

    @Override
    public int calculateDamage( final Creature aAttacker, final Creature aDefender )
    {
        return (int) (decorated.calculateDamage(aAttacker, aDefender) * getMultiplier());
    }

    private double getMultiplier() {
        switch (level) {
            case 1:
                return 1.1;
            case 2:
                return 1.2;
            case 3:
                return 1.3;
            default:
                return 1;
        }
    }


}
