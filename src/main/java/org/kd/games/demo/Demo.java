package org.kd.games.demo;

import javafx.scene.canvas.Canvas;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kd.games.Display;
import org.kd.games.GameFactory;

public class Demo extends Application {

    private final Display display = new GameFactory().createDefaultDisplayWithAnimation();

    @Override
    public void start(Stage primaryStage) {
        setupPrimaryStage(primaryStage, createGroup());
    }

    public static void start(String[] args) {
        launch(args);
    }

    private Group createGroup() {
        var group = new Group();
        var c = new Canvas(display.getBackground().getWidth(), display.getBackground().getHeight());
        new DrawTool(c.getGraphicsContext2D()).draw(display);
        group.getChildren().add(c);
        return group;
    }

    private void setupPrimaryStage(Stage primaryStage, Group root) {
        primaryStage.setTitle("Demo");
        primaryStage.setIconified(false);
        primaryStage.setScene(new Scene(root, display.getBackground().getWidth(), display.getBackground().getHeight()));
        primaryStage.setOnCloseRequest(event -> exit());

        primaryStage.show();
    }

    private void exit() {
    }

}
