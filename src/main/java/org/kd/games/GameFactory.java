package org.kd.games;


import java.awt.*;
import java.util.List;

public class GameFactory {

    public Animation createHorizontalAnimation(Drawer drawer){
        return new Animation(createDefaultDisplay(), drawer, true);
    }

    private List<Sprite> createDefaultSprites() {

        return List.of(new Sprite(10, 10, 10, 10, new VelocityVector(0, 0), Color.BLUE),
                new Sprite(20, 20, 10, 10, new VelocityVector(5, 0), Color.RED),
                new Sprite(50, 20, 40, 30, new VelocityVector(0, 0), Color.GREEN)
        );
    }

    public Background createDefaultBackground() {
        var background = new Background();
        background.importBitmap("games\\bg1.bmp");
        return background;
    }

    public Display createDefaultDisplay() {
        return new Display(createDefaultBackground(), createDefaultSprites());
    }

    public Display createDefaultDisplayWithAnimation() {
        return new Display(createDefaultBackground(), createDefaultSprites());
    }
}
