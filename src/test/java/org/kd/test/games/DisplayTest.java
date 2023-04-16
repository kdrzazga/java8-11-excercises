package org.kd.test.games;

import org.kd.games.GameFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DisplayTest {

    @Test
    public void testFindSpriteSpriteCollision() {
        var display = new GameFactory().createDefaultDisplay();
        var sprite1 = display.getSprites().get(0);
        var collidingSprites = display.findSpriteSpriteCollision(sprite1);

        assertThat(collidingSprites, hasSize(greaterThan(0)));

        //assertThat(collidingSprites, hasSize(greaterThan(2)));
    }

    @Test
    public void testFindSpriteBackgroundCollision() {
        var display = new GameFactory().createDefaultDisplay();
        var collidingSprites = display.findSpriteBackgroundCollision();

        assertThat(collidingSprites, hasSize(greaterThan(0)));

        //ArrayList<Color>
        var collidingSpritesColors = collidingSprites
                .stream()
                .map(sprite -> sprite.getColor())
                .collect(Collectors.toList());

        assertThat(collidingSpritesColors, containsInAnyOrder(Color.RED, Color.GREEN));
        assertThat(collidingSpritesColors, not(containsInAnyOrder(Color.BLUE)));
    }

    @Test
    public void testMoveSpriteLeftBy1Pixel() {
        var display = new GameFactory().createDefaultDisplay();
        var spriteColor = Color.RED;
        var redSprites = display.getSpritesByColor(spriteColor);
        if (redSprites.size() > 0) {
            int oldPosition = redSprites.get(0).getX();

            display.moveSpriteLeft(redSprites.get(0));

            assertEquals(oldPosition - 1, redSprites.get(0).getX());
        } else fail(spriteColor.toString() + " sprite not found");

    }

    @Test
    public void testMoveSpriteRightBy1Pixel() {
        var display = new GameFactory().createDefaultDisplay();
        var spriteColor = Color.RED;
        var redSprites = display.getSpritesByColor(spriteColor);
        if (redSprites.size() > 0) {
            int oldPosition = redSprites.get(0).getX();

            display.moveSpriteRight(redSprites.get(0));

            assertEquals(oldPosition + 1, redSprites.get(0).getX());
        } else fail(spriteColor.toString() + " sprite not found");
    }

    @Test
    public void testMoveSpriteUpBy1Pixel() {
        var display = new GameFactory().createDefaultDisplay();
        var spriteColor = Color.RED;
        var redSprites = display.getSpritesByColor(spriteColor);
        if (redSprites.size() > 0) {
            int oldPosition = redSprites.get(0).getY();

            display.moveSpriteUp(redSprites.get(0));

            assertEquals(oldPosition - 1, redSprites.get(0).getY());
        } else fail(spriteColor.toString() + " sprite not found");
    }

    @Test
    public void testMoveSpriteDownBy1Pixel() {
        var display = new GameFactory().createDefaultDisplay();
        var spriteColor = Color.RED;
        var redSprites = display.getSpritesByColor(spriteColor);
        if (redSprites.size() > 0) {
            int oldPosition = redSprites.get(0).getY();

            display.moveSpriteDown(redSprites.get(0));

            assertEquals(oldPosition + 1, redSprites.get(0).getY());
        } else fail(spriteColor.toString() + " sprite not found");
    }

}
