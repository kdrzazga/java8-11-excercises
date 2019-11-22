package org.kd.games.demo.fx;

import javafx.scene.canvas.GraphicsContext;
import lombok.AllArgsConstructor;
import org.kd.games.Background;
import org.kd.games.Display;
import org.kd.games.Drawer;
import org.kd.games.Sprite;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FxDrawer implements Drawer {

    private GraphicsContext gc;

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
        gc.setFill(convert(sprite.getColor()));
        gc.fillRect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void draw(Background background) {
        var pixels = background.getPixels();
        pixels.keySet().forEach(point -> gc
                .getPixelWriter()
                .setColor(point.x, point.y, convert(pixels.get(point))));

    }

    @Override
    public void draw(Background background, Rectangle piece) {
        //TODO
        var pixels = background.getPixels().keySet().stream()
                .filter(piece::contains).collect(Collectors.toSet());

        pixels.forEach(point -> gc.getPixelWriter()
                .setColor(point.x, point.y, convert(background.getPixels().get(point))));
    }

    private javafx.scene.paint.Color convert(java.awt.Color awtColor) {
        int r = awtColor.getRed();
        int g = awtColor.getGreen();
        int b = awtColor.getBlue();
        int a = awtColor.getAlpha();
        double opacity = a / 255.0;
        return javafx.scene.paint.Color.rgb(r, g, b, opacity);
    }
}
