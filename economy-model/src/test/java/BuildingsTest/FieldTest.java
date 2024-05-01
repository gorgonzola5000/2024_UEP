package BuildingsTest;

import org.junit.jupiter.api.Test;

import pl.psi.*;
import pl.psi.objects.Field;
import pl.psi.objects.FieldFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {



    @Test
    void FieldShouldAddWoodCorrectly() {
        Field woodField = FieldFactory.createField("wood",10);

        EconomyHero hero = new EconomyHero("hero");

        Resources resources = hero.getResources();


        assert woodField != null;
        woodField.apply(hero);

        assertEquals(resources.getWood() + 10, hero.getResources().getWood());

    }

    @Test
    void FieldShouldAddGoldCorrectly(){

        Field goldField = FieldFactory.createField("gold",10);

        EconomyHero hero = new EconomyHero("hero");

        Resources resources = hero.getResources();


        assert goldField != null;
        goldField.apply(hero);

        assertEquals(resources.getGold() + 10, hero.getResources().getGold());

    }

    @Test
    void FieldShouldBeCorruptedCorrectly() {

        EconomyHero hero1 = new EconomyHero("hero1");
        EconomyHero hero2 = new EconomyHero("hero2");
        EconomyEngine engine = new EconomyEngine(hero1,hero2);




    }
}
