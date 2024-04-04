// ******************************************************************
//
// Copyright 2024 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Builder
@Getter
public class CreatureStatistic {
    private final String name;
    private final int armor;
    private final int attack;
    private final int maxHp;
    private final Range<Integer> damage;
    private final int speed;
}
