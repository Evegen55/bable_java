package org.nbabel;

import java.util.ArrayList;
import java.util.List;

/**
 * cluster contains set of stars and methods to calculate acceleration, update acceleration,calculate energy
 */
public class Cluster {

    public final List<Star> stars = new ArrayList<>();

    public void acc() {
        //reset star acceleration (a) to zero
        stars.forEach(Star::resetAcceleration);

        double rd;        //rd used to store distance

        for (int ii = 0; ii != stars.size(); ii++) {
            for (int j = ii + 1; j != stars.size(); j++) {
                rd = 0;
                for (int i = 0; i != 3; i++) {
                    rd += (stars.get(ii).position[i] - stars.get(j).position[i]) * (stars.get(ii).position[i] - stars.get(j).position[i]);
                }
                double coff = Math.pow(Math.sqrt(rd), 3);

                for (int i = 0; i != 3; i++) {
                    stars.get(ii).acceleration_1[i] += (stars.get(j).mass / coff) * (stars.get(j).position[i] - stars.get(ii).position[i]);
                    stars.get(j).acceleration_1[i] += (stars.get(ii).mass / coff) * (stars.get(ii).position[i] - stars.get(j).position[i]);
                }
            }
        }
    }

    //updates the position of each star
    public void updatePositionsForAll(final double dt) {
        stars.forEach(star -> star.updatePosition(dt));
    }
    // Updates aold (Sets aold equal to a)
    public void updateAccelerationsForAll() {
        //aold[0]=stars.get(kk).a[0];
        stars.forEach(Star::copyAccelerationFromNewToOld);
    }

    /**
     * updates the position of each star
     * Updates aold (Sets aold equal to a)
     * @param dt
     * @param dt
     */
    public void updatePositionsAndAccelerationsForAll(final double dt) {
        stars.forEach(star -> {
            star.updatePosition(dt);
            star.copyAccelerationFromNewToOld();
        });
    }

    // Updates the velocity of  each star and
    public void updateVelocitiesForAll(final double dt) {
        // then updata aold (Sets aold equal to a)
        stars.forEach(star -> star.updateVelocity(dt));
    }


    public double[] energies() {
        double[] E = {0, 0, 0};
        double rd = 0;

        //Kinetic energy
        for (int i = 0; i != stars.size(); i++) {
            for (int j = 0; j != 3; j++) {
                E[1] += stars.get(i).mass * (stars.get(i).velocity[j] * stars.get(i).velocity[j]);
            }
        }

        //Potential energy
        for (int ii = 0; ii != stars.size() - 1; ii++) {
            for (int j = ii + 1; j != stars.size(); j++) {
                rd = 0;
                for (int i = 0; i != 3; i++) {
                    rd += (stars.get(ii).position[i] - stars.get(j).position[i]) * (stars.get(ii).position[i] - stars.get(j).position[i]);
                }
                E[2] -= (stars.get(ii).mass * stars.get(j).mass) / Math.sqrt(rd);
            }

            E[1] = 0.5 * E[1];
            E[0] = E[1] + E[2];
            return E;
        }
        return null;
    }
}
