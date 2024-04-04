// ******************************************************************
//  
// Copyright 2024 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import org.junit.jupiter.api.Test;

import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStatistic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
class TurnQueueTest
{

    @Test
    void queueShouldWorksProperly()
    {
        Creature s1 = createCreatureByGivenSpeed(1);
        Creature s2 = createCreatureByGivenSpeed(2);
        Creature s7 = createCreatureByGivenSpeed(7);
        Creature s10 = createCreatureByGivenSpeed(10);

        TurnQueue turnQueue = new TurnQueue(List.of(s2), List.of(s1, s10, s7));

        assertThat(turnQueue.getCurrentCreature()).isEqualTo(s10);
        turnQueue.nextCreature();
        assertThat(turnQueue.getCurrentCreature()).isEqualTo(s7);
        turnQueue.nextCreature();
        assertThat(turnQueue.getCurrentCreature()).isEqualTo(s2);
        turnQueue.nextCreature();
        assertThat(turnQueue.getCurrentCreature()).isEqualTo(s1);
        turnQueue.nextCreature();
        assertThat(turnQueue.getCurrentCreature()).isEqualTo(s10);
    }

    private static Creature createCreatureByGivenSpeed(int aSpeed) {
        return new Creature(CreatureStatistic.builder()
                .armor(1)
                .attack(1)
                .maxHp(1)
                .speed(aSpeed)
                .build(), 1);
    }
}