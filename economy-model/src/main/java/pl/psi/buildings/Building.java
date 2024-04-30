package pl.psi.buildings;

import lombok.Builder;
import lombok.Getter;
import pl.psi.Resources;

import javax.naming.InsufficientResourcesException;

public class Building{

    String name;
    @Getter
    int tier;
    private final Resources requiredResources;
    private final int maxTier;

    public Building(String name, Resources requiredResources) {
        this.name = name;
        this.requiredResources = requiredResources;
        this.tier = 1;
        this.maxTier = 5;
    }

    public void upgrade(Resources availableResources) throws InsufficientResourcesException {
        if (canUpgrade(availableResources)) {
            if (tier < maxTier) {
                tier++;
                requiredResources.multiply(1.5);
                availableResources.subtract(requiredResources);
            } else {
                throw new InsufficientResourcesException("Budynek " + name + " osiągnął już maksymalny poziom tieru.");
            }
        } else {
            throw new InsufficientResourcesException("Brak wystarczających zasobów do ulepszenia budynku " + name);
        }
    }

    private boolean canUpgrade(Resources availableResources) {
        return availableResources.getGold() >= requiredResources.getGold() &&
                availableResources.getWood() >= requiredResources.getWood() &&
                availableResources.getOre() >= requiredResources.getOre() &&
                availableResources.getMercury() >= requiredResources.getMercury() &&
                availableResources.getSulfur() >= requiredResources.getSulfur() &&
                availableResources.getCristals() >= requiredResources.getCristals() &&
                availableResources.getGems() >= requiredResources.getGems();
    }
}
