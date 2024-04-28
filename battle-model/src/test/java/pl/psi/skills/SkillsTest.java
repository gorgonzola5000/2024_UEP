package pl.psi.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.Hero;
import pl.psi.creatures.ArmoredCreature;
import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;
import pl.psi.enums.SkillEnum;


import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SkillsTest {

    @Test
    void advancedArmoredCreatureTest() {
        final int MAX_HP = 200;

        Creature creatureWithArmorer = new Creature.Builder().statistic(CreatureStats.builder()
                        .armor(20)
                        .attack(20)
                        .maxHp(MAX_HP)
                        .damage(Range.closed(50, 50))
                        .build())
                .build();
//       creatureWithArmorer(new ArmoredDamageApplier(creatureWithArmorer.getDamageApplier(), 2));
//        creatureWithArmorer = new ArmoredCreature(creatureWithArmorer, 2);
        Creature creatureWithoutArmorer = new Creature.Builder().statistic(CreatureStats.builder()
                        .armor(20)
                        .attack(20)
                        .maxHp(MAX_HP)
                        .damage(Range.closed(50, 50))
                        .build())
                .build();


        //when
        creatureWithoutArmorer.attack(creatureWithArmorer);

        //then
        assertThat(creatureWithArmorer.getCurrentHp()).isEqualTo(MAX_HP - 45);
        assertThat(creatureWithoutArmorer.getCurrentHp()).isEqualTo(MAX_HP - 50);
    }

    @Disabled
    @Test
    void advancedArmorerCastTest() {
        final int MAX_HP = 200;

        Creature creatureToArmor = new Creature.Builder().statistic(CreatureStats.builder()
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

        ArmoredCreature armoredCreature = new ArmoredCreature(new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(MAX_HP)
                        .damage(Range.closed(10, 10))
                        .build())
                .build(), 2);

        //when
        ArrayList<Creature> creatureList = new ArrayList<>();
        creatureList.add(creatureToArmor);
        Hero aHero = new Hero(creatureList);
        aHero.addSkill(new ArmorerSkill(2));
        aHero.castSkill(SkillEnum.ARMORER);
//        creatureWithoutArmorer.attack(creatureToArmor);
        //then

        assertThat(creatureToArmor.getClass()).isEqualTo(armoredCreature.getClass());
//        assertThat(creatureToArmor.getCurrentHp()).isEqualTo(MAX_HP - 45);
//        assertThat(creatureWithoutArmorer.getCurrentHp()).isEqualTo(MAX_HP - 50);
    }
}
