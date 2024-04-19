package pl.psi.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.Hero;
import pl.psi.creatures.ArmoreredCreature;
import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SkillsTest {

    @Test
    @Disabled
    void advancedArmorerTest() {
        final int MAX_HP = 200;

        Creature creatureWithArmorer = new Creature.Builder().statistic(CreatureStats.builder()
                .armor(20)
                .attack(20)
                .maxHp(MAX_HP)
                .damage(Range.closed(50, 50))
                .build())
            .build();

        Creature creatureWithoutArmorer = new Creature.Builder().statistic(CreatureStats.builder()
                .armor(20)
                .attack(20)
                .maxHp(MAX_HP)
                .damage(Range.closed(50, 50))
                .build())
            .build();

//        List<Creature> hero1creatures = new ArrayList<>();
//        hero1creatures.add(creatureWithArmorer);
//        Hero hero1 = new Hero(hero1creatures);
//        hero1.addSkill(new Armorer(2));
//        hero1.castSkill(armorer);

        creatureWithArmorer = new ArmoreredCreature(creatureWithArmorer, 2);

        creatureWithoutArmorer.attack(creatureWithArmorer);

        assertThat(creatureWithArmorer.getCurrentHp()).isEqualTo(MAX_HP - 45);
        assertThat(creatureWithoutArmorer.getCurrentHp()).isEqualTo(MAX_HP - 50);
    }
}
