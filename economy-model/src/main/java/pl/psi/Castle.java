package pl.psi;

import pl.psi.buildings.Building;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;

public class Castle implements MapObject {

    private List<Building> buildings = new ArrayList<>();

    public Castle(){

    }


    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public Building getBuilding(int index){
        return buildings.get(index);
    }


    public void upgradeBuilding(int index, Resources availableResources) throws InsufficientResourcesException {
        Building building = buildings.get(index);
        building.upgrade(availableResources);
    }

}
