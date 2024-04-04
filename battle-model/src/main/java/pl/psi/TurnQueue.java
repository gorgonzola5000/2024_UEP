// ******************************************************************
//
// Copyright 2024 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.psi.creatures.Creature;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class TurnQueue
{

    private final Queue< Creature > queue = new LinkedList<>();
    private final List< Creature > allCreatures;

    public TurnQueue( List< Creature > aCreatures1, List< Creature > aCreatures2 )
    {
        allCreatures = Stream.concat( aCreatures1.stream(), aCreatures2.stream() )
            .sorted( Comparator.comparingInt( Creature::getSpeed )
                .reversed() )
            .collect( Collectors.toList() );
        queue.addAll( allCreatures );
    }

    public Creature getCurrentCreature()
    {
        return queue.peek();
    }

    public void nextCreature()
    {
        queue.poll();
        if( queue.isEmpty() )
        {
            reinitializeQueue();
        }
    }

    private void reinitializeQueue()
    {
        queue.addAll( allCreatures );
    }
}
