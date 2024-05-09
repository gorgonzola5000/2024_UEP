package pl.psi.objects;

import pl.psi.EconomyHero;
import pl.psi.Resources;

public class GoldField implements Field {

    private int goldAmount;
    public GoldField(int amount) {
        this.goldAmount = amount;
    }

    @Override
    public void apply(EconomyHero hero) {
        Resources resourcesToAdd = Resources.builder().gold(goldAmount).build();
        Resources updatedResources = hero.getResources().addResources(resourcesToAdd);
        hero.setResources(updatedResources);
    }
}
