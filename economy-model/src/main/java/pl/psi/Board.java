package pl.psi;

import java.beans.PropertyChangeSupport;
import java.util.Optional;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Board
{
    private static final int MAX_WIDTH = 30;
    private static final int MAX_HEIGHT = 30;
    private final BiMap< Point, EconomyHero > map = HashBiMap.create();

    public Board(final EconomyHero aHero1, final EconomyHero aHero2, PropertyChangeSupport aObserverSupport)
    {
        map.put( new Point( 5, 5 ), aHero1 );
        map.put( new Point( MAX_HEIGHT - 5, MAX_WIDTH - 5 ), aHero2 );

    }

    Optional< EconomyHero > getHero( final Point aPoint )
    {
        return Optional.ofNullable( map.get( aPoint ) );
    }

    void move( final EconomyHero aHero, final Point aPoint )
    {
        if( canMove( aHero, aPoint ) )
        {
            map.inverse()
                .remove( aHero );
            map.put( aPoint, aHero );
            aHero.retrieveMovePoints( getPosition( aHero ).distance( aPoint ) );
        }
    }

    boolean canMove( final EconomyHero aHero, final Point aPoint )
    {
        if( map.containsKey( aPoint ) )
        {
            return false;
        }
        final Point oldPosition = getPosition( aHero );
        return aPoint.distance( oldPosition.getX(), oldPosition.getY() ) < aHero.getCurrentMovePoints();
    }

    Point getPosition( EconomyHero aHero )
    {
        return map.inverse()
            .get( aHero );
    }
}
