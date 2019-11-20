package org.kd.games;

public class VelocityVector implements Cloneable {

    public static final int V_MAX = 320;
    public static final int V_MIN = 0;
    public static final float ROTATION_UNIT = (float) (Math.PI / 10);
    public static final int ACCELERATE_UNIT = 1;

    public int value;
    public double angle;

    public VelocityVector(int value, double angle) {

        this.value = value;
        this.angle = angle;
    }

    public void turnLeft() {
        this.turn(-ROTATION_UNIT);
    }

    public void turnRight() {
        this.turn(ROTATION_UNIT);
    }

    public void accelerate() {
        this.accelerate(ACCELERATE_UNIT);
    }

    public void slowDown() {
        this.accelerate(-ACCELERATE_UNIT);
    }

    @Override
    public VelocityVector clone() {
        return new VelocityVector(this.value, this.angle);
    }

    private void turn(double turnAngle) {
        this.angle = (this.angle + turnAngle) % (2 * Math.PI);
    }

    private void accelerate(int accelerateValue) {
        if (this.value + accelerateValue > V_MAX) {
            this.value = V_MAX;
        } else if (this.value + accelerateValue < V_MIN) {
            this.value = V_MIN;
        } else {
            this.value += accelerateValue;
        }
    }

}
