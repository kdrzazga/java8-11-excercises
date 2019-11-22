package org.kd.games;

import lombok.AllArgsConstructor;

import java.awt.*;

@SuppressWarnings("InfiniteLoopStatement")
@AllArgsConstructor
public class Animation extends Thread {

    private static final long TIME_FRAME = 10;

    private Display display;
    private Drawer drawer;
    /*private Color spriteColor;
    private Rectangle animatedRegion;*/
    private boolean running;

    @Override
    public void run() {
        super.run();

        while (true) {
            if (running) {
                drawer.draw(display.getSprites());
                var bg = display.getBackground();

                drawer.draw(display.getSprites());

                display.getSprites().forEach(sprite -> {
                    var spriteArea = new Rectangle(sprite.getX() - 1, sprite.getY() - 1, sprite.getWidth() + 1, sprite.getHeight() + 1);
                    drawer.draw(bg, spriteArea);
                });

                display.getSprites().forEach(sprite ->
                        sprite.move(bg.findLimits()));

                drawer.draw(display.getSprites());
            }

            try {
                Thread.sleep(TIME_FRAME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
