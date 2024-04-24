package pl.psi.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MachineFactoryTest {

    private static final Range<Integer> NOT_IMPORTANT_DMG = Range.closed(0, 0);

    @Test
    void TestHealCreature() {
        // given
        final Creature angel = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(Range.closed(10, 10))
                        .attack(50)
                        .armor(0)
                        .build())
                .build();
        final Creature dragon = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(NOT_IMPORTANT_DMG)
                        .attack(0)
                        .armor(10)
                        .build())
                .build();
        MachineFactory machineFactory = new MachineFactory();
        // when
        angel.attack(dragon);
        machineFactory.healHPCreature(dragon);
        // then
        assertThat(dragon.getCurrentHp()).isEqualTo(dragon.getMaxHp());
    }

    @Test
    void TestHealListCreature() {
        // given
        final Creature angel = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(Range.closed(10, 10))
                        .attack(50)
                        .armor(0)
                        .build())
                .build();
        final Creature dragon = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(100)
                        .damage(NOT_IMPORTANT_DMG)
                        .attack(0)
                        .armor(10)
                        .build())
                .build();
        final Creature magic = new Creature.Builder().statistic(CreatureStats.builder()
                        .maxHp(70)
                        .damage(NOT_IMPORTANT_DMG)
                        .attack(0)
                        .armor(5)
                        .build())
                .build();
        MachineFactory machineFactory = new MachineFactory();
        List<Creature> creaturesList = new ArrayList<Creature>();
        creaturesList.add(dragon);
        creaturesList.add(magic);
        // when
        angel.attack(dragon);
        angel.attack(magic);
        machineFactory.chooseHealCreature(creaturesList);

        // then
        assertThat(dragon.getCurrentHp()).isEqualTo(70);
        assertThat(magic.getCurrentHp()).isEqualTo(magic.getMaxHp());
    }

}