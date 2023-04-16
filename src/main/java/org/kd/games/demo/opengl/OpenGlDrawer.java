package org.kd.games.demo.opengl;

import lombok.AllArgsConstructor;
import org.kd.games.Background;
import org.kd.games.Display;
import org.kd.games.Drawer;
import org.kd.games.Sprite;

import java.awt.*;
import java.util.List;

import com.jogamp.opengl.GL2;
import static com.jogamp.opengl.GL.*;

@AllArgsConstructor
public class OpenGlDrawer implements Drawer {

    private GL2 gl;
    private final float scale = 0.0047f;

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
        ColorSettings.setColor(sprite.getColor(), gl);

        float x1 = sprite.getX() * scale;
        float y1 = sprite.getY() * scale;
        float x2 = (sprite.getX() + sprite.getWidth()) * scale;
        float y2 = (sprite.getY() + sprite.getHeight()) * scale;

        gl.glLineWidth(17);
        gl.glBegin(GL_LINES);
        //gl.glBegin(GL_QUADS);
        gl.glVertex2f(x1, y1);
        gl.glVertex2f(x1, y2);
        gl.glVertex2f(x2, y2);
        gl.glVertex2f(x1, y2);
        gl.glEnd();
    }

    @Override
    public void draw(Background background) {
        background.getPixels().keySet().forEach(pixel ->
        {
            ColorSettings.setColor(background.getPixels().get(pixel), gl);

            float x = scale * (pixel.x - background.getWidth() / 2) + 0.94f;
            float y = -scale * (pixel.y - background.getHeight() / 2) + 0.31f;
            gl.glBegin(GL_POINTS);
            gl.glVertex2f(x, y);
            gl.glEnd();
        });

        gl.glFlush();
    }

    @Override
    public void draw(Background background, Rectangle piece) {
        //TODO
    }
}
