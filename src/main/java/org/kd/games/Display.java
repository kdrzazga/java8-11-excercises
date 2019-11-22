package org.kd.games;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Display {

    private Background background;
    private List<Sprite> sprites;

    public Set<Sprite> findSpriteSpriteCollision(Sprite mainSprite) {
        return sprites.stream()
                .filter(spr -> !spr.equals(mainSprite))
                .filter(spr -> spr.collides(mainSprite))
                .collect(Collectors.toSet());
    }

    public Set<Sprite> findSpriteBackgroundCollision() {

        var colliding = new HashSet<Sprite>(sprites.size());

        for (var sprite : sprites) {
            var bgUnderSprite = background
                    .getPixelsFromRange(sprite.getX(), sprite.getY(), sprite.getX() + sprite.getWidth(), sprite.getY() + sprite.getHeight());

            if (bgUnderSprite.values().stream().anyMatch(color -> !color.equals(background.getBackgroundColor()))) {
                colliding.add(sprite);
            }
        }
        return colliding;
    }

    public void moveSpriteLeft(int index) {
        if (index < sprites.size())
            moveSpriteLeft(sprites.get(index));
    }

    public void moveSpriteLeft(Sprite sprite) {
        sprite.setV(new VelocityVector(1, -Math.PI));
        var limits = new Rectangle(this.background.getWidth(), this.background.getHeight());
        sprite.move(limits);
    }

    public void moveSpriteRight(Sprite sprite) {
        sprite.setV(new VelocityVector(1, 0));
        var limits = new Rectangle(this.background.getWidth(), this.background.getHeight());
        sprite.move(limits);
    }

    public void moveSpriteUp(Sprite sprite) {
        sprite.setV(new VelocityVector(1, -Math.PI / 2));
        var limits = new Rectangle(this.background.getWidth(), this.background.getHeight());
        sprite.move(limits);
    }

    public void moveSpriteDown(Sprite sprite) {
        sprite.setV(new VelocityVector(1, Math.PI / 2));
        var limits = new Rectangle(this.background.getWidth(), this.background.getHeight());
        sprite.move(limits);
    }

    /*
    Moves first sprite of given color left
     */
    public void moveSpriteLeft(Color color) {
        var colorfulSprites = getSpritesByColor(color);
        if (colorfulSprites.size() > 0)
            moveSpriteLeft(colorfulSprites.get(0));
    }


    public List<Sprite> getSpritesByColor(Color color) {
        return sprites
                .stream()
                .filter(s -> color.equals(s.getColor()))
                .collect(Collectors.toList());
    }
}
