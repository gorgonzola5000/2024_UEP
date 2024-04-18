package pl.psi.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CastleWindow extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Zamek");

        Button button = new Button("Kliknij mnie!");


        button.setOnAction(event -> {
            System.out.println("Przycisk został kliknięty!");
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);


        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);

        stage.show();
    }

    public CastleWindow() {
        launch();
    }
}
