package org.kd.test.games;

import org.kd.games.Sprite;
import org.kd.games.VelocityVector;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SpriteTest {

    private final static VelocityVector v = new VelocityVector(0, 0);

    @Test
    public void testCollidesPositive() {
        var sprite1 = new Sprite(20, 30, 40, 50, v, Color.CYAN);
        var collidingSprite = new Sprite(20 + 40, 30 + 50, 2, 2, v, Color.CYAN);

        assertTrue(sprite1.collides(collidingSprite));
    }

    @Test
    public void testCollidesNegative() {
        var sprite1 = new Sprite(20, 30, 40, 50, v, Color.CYAN);
        var nonCollidingSprite = new Sprite(20 + 41, 30 + 50, 2, 2, v, Color.CYAN);

        assertFalse(sprite1.collides(nonCollidingSprite));
    }
}
