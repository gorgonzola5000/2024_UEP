package pl.psi.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SkillsTest {

    @Test
    @Disabled
    void advancedArmorerTest() {
        final int MAX_HP = 200;
        Creature creatureWithoutArmorer = new Creature.Builder().statistic(CreatureStats.builder()
                .armor(20)
                .attack(20)
                .maxHp(MAX_HP)
//                .speed(12)
                .damage(Range.closed(50, 50))
                .build())
            .build();
        Creature creatureWithArmorer = new Creature.Builder().statistic(CreatureStats.builder()
                .armor(20)
                .attack(20)
                .maxHp(MAX_HP)
//                .speed(12)
                .damage(Range.closed(50, 50))
                .build())
            .build();

//        hero.castArmorer(2, creatureWithArmorer) TODO
        creatureWithoutArmorer.attack(creatureWithArmorer);

        assertThat(creatureWithArmorer.getCurrentHp()).isEqualTo(MAX_HP - 45);
        assertThat(creatureWithoutArmorer.getCurrentHp()).isEqualTo(MAX_HP - 50);
    }
}
