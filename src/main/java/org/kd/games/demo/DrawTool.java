package org.kd.games.demo;

import javafx.scene.canvas.GraphicsContext;
import lombok.AllArgsConstructor;
import org.kd.games.Display;

@AllArgsConstructor
public class DrawTool {

    private GraphicsContext gc;

    public void draw(Display display) {
        var pixels = display.getBackground().getPixels();
        pixels.keySet().forEach(point -> gc
                .getPixelWriter()
                .setColor(point.x, point.y, convert(pixels.get(point))));

        var sprites = display.getSprites();

        sprites.forEach(sprite -> {
            gc.setFill(convert(sprite.getColor()));
            gc.fillRect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        });
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
