package pl.psi;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.psi.creatures.EconomyCreature;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Getter
@AllArgsConstructor
public class EconomyHero implements PropertyChangeListener
{
    private final String name;
    private final List< EconomyCreature > creatures;
    private int maxMovePoints;
    private int currentMovePoints;
    @Setter
    private Resources resources;
    private Castle castle;

    public EconomyHero( String aName )
    {
        name = aName;
        creatures = new ArrayList<>();
        maxMovePoints = 10;
        currentMovePoints = maxMovePoints;
        resources = Resources.startRes();
    }

    @Override
    public void propertyChange( PropertyChangeEvent aEvent )
    {
        if( aEvent.getPropertyName()
            .equals( EconomyEngine.TURN_END ) )
        {
            currentMovePoints = maxMovePoints;
        }
    }

    void retrieveMovePoints( double aDistance )
    {
        currentMovePoints = (int)Math.ceil( aDistance );
    }

    public void addCreature(EconomyCreature aEconomyCreature) {
        creatures.add(aEconomyCreature);
    }

}
