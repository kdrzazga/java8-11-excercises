package org.kd.games;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
@Getter
public class Sprite {

    private int x;
    private int y;
    private int width;
    private int height;
    private VelocityVector v;

    private Color color;
    //private Set<Point> points;

    public void move(Rectangle limits){
        double moveX = Math.cos(this.v.angle) * this.v.value;
        double moveY = Math.sin(this.v.angle) * this.v.value;

        int newPosX = (int)(this.getX() + moveX);
        int newPosY = (int)(this.getY() + moveY);

        if (limits.contains(new Point(newPosX, newPosY))) {
            this.x = newPosX;
            this.y = newPosY;
        }
    }

    public boolean collides(Sprite otherSprite) {
        return pointCollidesSprite(otherSprite.x, otherSprite.y)
                || pointCollidesSprite(otherSprite.x + otherSprite.width, otherSprite.y)
                || pointCollidesSprite(otherSprite.x, otherSprite.y + otherSprite.height)
                || pointCollidesSprite(otherSprite.x + otherSprite.width, otherSprite.y + otherSprite.height);
    }

    public void setV(VelocityVector v) {
        this.v = v;
    }

    private boolean pointCollidesSprite(int x, int y) {
        return x >= this.x && x <= this.x + this.width
                && y >= this.y && y <= this.y + this.height;
    }

}
