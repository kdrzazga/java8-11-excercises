package org.kd.games.demo.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.kd.games.Animation;
import org.kd.games.Display;
import org.kd.games.Drawer;
import org.kd.games.GameFactory;

public class DemoFx extends Application {

    private final Display display = new GameFactory().createDefaultDisplayWithAnimation();

    private Animation animation;
    private Drawer drawer;

    @Override
    public void start(Stage primaryStage) {
        setupPrimaryStage(primaryStage, createGroup());
        setupAnimation();
    }

    private void setupAnimation() {
        animation = new GameFactory().createHorizontalAnimation(drawer);
        animation.start();
    }

    public static void start(String[] args) {
        launch(args);
    }

    private Group createGroup() {
        var group = new Group();
        Canvas c = new Canvas(display.getBackground().getWidth(), display.getBackground().getHeight());
        drawer = new FxDrawer(c.getGraphicsContext2D());
        drawer.draw(display);
        group.getChildren().add(c);
        return group;
    }

    private void setupPrimaryStage(Stage primaryStage, Group root) {
        primaryStage.setTitle("DemoFx");
        primaryStage.setIconified(false);
        primaryStage.setScene(createScene(root));
        primaryStage.setOnCloseRequest(event -> exit());
        primaryStage.show();

        System.out.println("Import done");
    }

    private Scene createScene(Group root) {
        return new Scene(root
                , display.getBackground().getWidth()
                , display.getBackground().getHeight());
    }

    private void exit() {
        System.exit(0);
    }

}
