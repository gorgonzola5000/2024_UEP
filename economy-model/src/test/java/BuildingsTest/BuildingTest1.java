package BuildingsTest;


import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import pl.psi.Castle;
import pl.psi.Resources;
import pl.psi.buildings.Building;
import pl.psi.buildings.BuildingFactory;
import pl.psi.buildings.ExampleBuilding;

import javax.naming.InsufficientResourcesException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BuildingTest1 {



    @Test
    void BuildingsShouldUpgradeCorrectly() throws InsufficientResourcesException {
        Building building = new ExampleBuilding().createBuilding();
        Castle castle = new Castle();
        castle.addBuilding(building);
        Resources availableResources = Resources.startRes();

        castle.getBuilding(0).upgrade(availableResources);
        assertEquals(2, castle.getBuilding(0).getTier());

        //WORK IN PROGRESS

    }
}
