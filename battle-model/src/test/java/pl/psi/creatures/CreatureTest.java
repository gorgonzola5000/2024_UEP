// ******************************************************************
//  
// Copyright 2024 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi.creatures;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.common.collect.Range;

class CreatureTest
{

    @Test
    void shouldAttackProperly()
    {
        // Random mock = mock( Random.class );
        // when( mock.nextInt( anyInt() ) ).thenReturn( 4 );
        Creature attacker = new Creature( CreatureStatistic.builder()
            .armor( 5 )
            .attack( 5 )
            .maxHp( 10 )
            .speed( 1 )
            .damage( Range.closed( 1, 10 ) )
            .build(), 10, new Always4IntRandom() );
        Creature defender = new Creature( CreatureStatistic.builder()
            .armor( 5 )
            .attack( 5 )
            .maxHp( 10 )
            .speed( 1 )
            .damage( Range.closed( 1, 10 ) )
            .build(), 10 );

        attacker.attack( defender );

        assertThat( defender.getCurrentHp() ).isEqualTo( 10 );
        assertThat( defender.getAmount() ).isEqualTo( 5 );
    }

    @Test
    void reduce80PercentageOfArmor()
    {
        Creature attacker = new Creature( CreatureStatistic.builder()
            .armor( 5 )
            .attack( 5 )
            .maxHp( 10 )
            .speed( 1 )
            .damage( Range.closed( 1, 10 ) )
            .build(), 10, new Always4IntRandom() );
        Creature defender = new Creature( CreatureStatistic.builder()
            .armor( 5 )
            .attack( 5 )
            .maxHp( 10 )
            .speed( 1 )
            .damage( Range.closed( 1, 10 ) )
            .build(), 10 );

        attacker.attack( defender );

        assertThat( defender.getCurrentHp() ).isEqualTo( 7 );
        assertThat( defender.getAmount() ).isEqualTo( 5 );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource( value = "shouldApplyDamageProperlyArgs" )
    void shouldApplyDamageProperly( int maxHp, int startAmount, int amount, int hp, int dmg )
    {
        Creature defender = new Creature( CreatureStatistic.builder()
            .armor( 5 )
            .attack( 5 )
            .maxHp( maxHp )
            .speed( 1 )
            .damage( Range.closed( 1, 10 ) )
            .build(), startAmount );

        defender.applyDamage( dmg );

        assertThat( defender.getAmount() ).isEqualTo( amount );
        assertThat( defender.getCurrentHp() ).isEqualTo( hp );
    }

    @Test
    void retaliationWorksProperly()
    {
        Creature attacker = new Creature( CreatureStatistic.builder()
            .name( "attacker" )
            .armor( 5 )
            .attack( 5 )
            .maxHp( 10 )
            .speed( 1 )
            .damage( Range.closed( 0, 0 ) )
            .build(), 10 );
        Creature defender = new Creature( CreatureStatistic.builder()
            .name( "defender" )
            .armor( 5 )
            .attack( 5 )
            .maxHp( 10 )
            .speed( 1 )
            .damage( Range.closed( 1, 10 ) )
            .build(), 10, new Always4IntRandom() );

        attacker.attack( defender );

        assertThat( attacker.getCurrentHp() ).isEqualTo( 10 );
        assertThat( attacker.getAmount() ).isEqualTo( 5 );
    }

    public static Stream< Arguments > shouldApplyDamageProperlyArgs()
    {
        return Stream.of( //
            Arguments.of( 10, 10, 6, 9, 41 ), //
            Arguments.of( 10, 10, 6, 9, 41 )//
        );
    }

    private class Always4IntRandom extends Random
    {
        @Override
        public int nextInt( int bound )
        {
            return 4;
        }
    }
}