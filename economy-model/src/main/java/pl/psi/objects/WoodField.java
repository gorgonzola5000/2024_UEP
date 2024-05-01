package pl.psi.objects;

import pl.psi.EconomyHero;
import pl.psi.Resources;

public class WoodField implements Field{

    private int WoodAmount;
    public WoodField(int WoodAmount) {
        this.WoodAmount = WoodAmount;
    }

    @Override
    public void apply(EconomyHero hero) {
        Resources resourcesToAdd = Resources.builder().wood(WoodAmount).build();
        Resources updatedResources = hero.getResources().addResources(resourcesToAdd);
        hero.setResources(updatedResources);
    }
}
