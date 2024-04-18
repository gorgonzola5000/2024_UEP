package pl.psi.gui;

import javafx.scene.layout.StackPane;

public class CastleGui extends StackPane {

    public CastleGui() {

    }

    public static void openCastle() {
        CastleWindow castleWindow = new CastleWindow();
        castleWindow.launch(CastleWindow.class);
    }
}
