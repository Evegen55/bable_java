package org.nbabel;

import java.util.Arrays;

/**
 * Star class contains information about star (mass,position and velocity) and methods to update position, velocity and
 * acceleration
 */
public class Star {

    private static int NUM_DIMENSIONS = 3;

    final double mass;

    double[] position = new double[NUM_DIMENSIONS];
    double[] velocity = new double[NUM_DIMENSIONS];
    double[] acceleration_1 = new double[NUM_DIMENSIONS];
    double[] acceleration_0 = new double[NUM_DIMENSIONS];

    public Star(final double mass) {
        this.mass = mass;
    }


    public void resetAcceleration() {
        Arrays.fill(acceleration_1, 0);
    }

    public void copyAccelerationFromNewToOld() {
        for (int i = 0; i != NUM_DIMENSIONS; i++) {
            acceleration_0[i] = acceleration_1[i];
        }
    }

    public void updatePosition(double dt) {
        for (int i = 0; i != NUM_DIMENSIONS; i++) {
            double dt2 = dt * dt;
            position[i] += velocity[i] * dt + 0.5 * acceleration_1[i] * dt2;
        }
    }

    public void updateVelocity(double dt) {
        for (int i = 0; i != 3; i++) {
            velocity[i] += 0.5 * dt * (acceleration_1[i] + acceleration_0[i]);
        }
    }
}