package pl.psi.skills;

import pl.psi.creatures.Creature;

import java.util.List;

public class Armorer extends Skill {

    private int level;

    public Armorer(int aLevel) {
        level = aLevel;
    }


    @Override
    public void cast(List< Creature > creatures) {
//        creatures.forEach();
    }
}
