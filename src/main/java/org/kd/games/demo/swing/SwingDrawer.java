package org.kd.games.demo.swing;

import lombok.AllArgsConstructor;
import org.kd.games.Background;
import org.kd.games.Display;
import org.kd.games.Drawer;
import org.kd.games.Sprite;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SwingDrawer implements Drawer {

    private Graphics gc;

    @Override
    public void draw(Display display) {
        draw(display.getBackground());
        draw(display.getSprites());
    }

    @Override
    public void draw(List<Sprite> sprites) {
        sprites.forEach(this::draw);
    }

    @Override
    public void draw(Sprite sprite) {
        gc.setColor(sprite.getColor());
        gc.fillRect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }


    @Override
    public void draw(Background background) {
        var pixels = background.getPixels();
        pixels.keySet().forEach(point -> {
            gc.setColor(pixels.get(point));
            gc.drawLine(point.x, point.y, point.x + 1, point.y + 1);
        });

    }

    @Override
    public void draw(Background background, Rectangle piece) {
        var pixels = background.getPixels().keySet().stream()
                .filter(piece::contains).collect(Collectors.toSet());

        pixels.forEach(point -> {
            gc.setColor(background.getPixels().get(point));
            gc.drawLine(point.x, point.y, point.x + 1, point.y + 1);
        });
    }

}
