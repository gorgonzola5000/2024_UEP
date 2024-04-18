package pl.psi.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStatistic;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SkillsTest {

    @Test
    @Disabled
    void advancedArmorerTest() {
        final int MAX_HP = 200;
        Creature attacker = new Creature(CreatureStatistic.builder()
                .armor(20)
                .attack(20)
                .maxHp(MAX_HP)
                .speed(12)
                .damage(Range.closed(50, 50))
                .build(), 1);
        Creature defender = new Creature(CreatureStatistic.builder()
                .armor(20)
                .attack(20)
                .maxHp(MAX_HP)
                .speed(12)
                .damage(Range.closed(50, 50))
                .build(), 1);

//        hero.castArmorer(2, defender) TODO
        attacker.attack(defender);

        assertThat(defender.getCurrentHp()).isEqualTo(MAX_HP - 45);
        assertThat(attacker.getCurrentHp()).isEqualTo(MAX_HP - 50);
    }
}
