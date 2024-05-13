package pl.psi.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import lombok.NoArgsConstructor;
import pl.psi.EconomyEngine;
import pl.psi.EconomyHero;
import pl.psi.Point;
import pl.psi.converter.EcoBattleConverter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@NoArgsConstructor
public class EcoController implements PropertyChangeListener {
    private EconomyEngine economyEngine;
    @FXML
    private GridPane grid;

    public EcoController(final EconomyHero aHero1, final EconomyHero aHero2) {
        economyEngine = new EconomyEngine(aHero1, aHero2);
    }

    @FXML
    void initialize() {
        refreshGui();
        economyEngine.addObserver(EconomyEngine.HERO_MOVED, this);
        economyEngine.addObserver(EconomyEngine.ACTIVE_HERO_CHANGED, this);
        economyEngine.addObserver(EconomyEngine.TURN_END, this);

    }

    private void goToBattle() {
        EcoBattleConverter.startBattle(economyEngine.getHero1(), economyEngine.getHero2());
    }

    void refreshGui() {
        grid.getChildren()
                .clear();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 10; y++) {
                Point currentPoint = new Point(x, y);
                final MapTile mapTile = new MapTile("");
            }
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
