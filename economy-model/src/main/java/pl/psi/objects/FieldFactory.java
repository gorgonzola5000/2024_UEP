package pl.psi.objects;

import pl.psi.MapObject;

public class FieldFactory {
    public static Field createField(String type, int amount) {
        switch (type.toLowerCase()) {
            case "gold":
                return new GoldField(amount);
            case "wood":
                return new WoodField(amount);
            default:
                return null;
        }
    }

}
