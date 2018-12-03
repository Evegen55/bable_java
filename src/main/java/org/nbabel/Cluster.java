package org.nbabel;

import java.util.ArrayList;
import java.util.List;

/**
 * cluster contains set of stars and methods to calculate acceleration, update acceleration, calculate energy
 */
public class Cluster {

    public final List<Star> stars = new ArrayList<>();

    public void accelerate() {

        double rd;        //rd used to store distance

        for (int ii = 0; ii != stars.size(); ii++) {
            for (int j = ii + 1; j != stars.size(); j++) {

                rd = 0;
                for (int i = 0; i != 3; i++) {
//                    rd += (stars.get(ii).position[i] - stars.get(j).position[i]) * (stars.get(ii).position[i] - stars.get(j).position[i]);
                    rd = Math.fma((stars.get(ii).position[i] - stars.get(j).position[i]),
                                  (stars.get(ii).position[i] - stars.get(j).position[i]),
                                  rd);
                }

                double coff = Math.pow(Math.sqrt(rd), 3);
                for (int i = 0; i != 3; i++) {
//                    stars.get(ii).acceleration_1[i] += (stars.get(j).mass / coff) * (stars.get(j).position[i] - stars.get(ii).position[i]);
                    stars.get(ii).acceleration_1[i] = Math.fma((stars.get(j).mass / coff),
                                                               (stars.get(j).position[i] - stars.get(ii).position[i]),
                                                               stars.get(ii).acceleration_1[i]);

//                    stars.get(j).acceleration_1[i] += (stars.get(ii).mass / coff) * (stars.get(ii).position[i] - stars.get(j).position[i]);
                    stars.get(j).acceleration_1[i] = Math.fma((stars.get(ii).mass / coff),
                                                              (stars.get(ii).position[i] - stars.get(j).position[i]),
                                                              stars.get(j).acceleration_1[i]);
                }
            }
        }
    }

    /**
     * updates the position of each star Updates aold (Sets aold equal to a) Resets star acceleration (a) to zero
     *
     * @param dt
     * @param dt
     */
    public void updatePositionsAndAccelerationsForAll(final double dt) {
        stars.parallelStream()
                .unordered()
                .forEach(star -> {
                    star.updatePosition(dt);
                    star.copyAccelerationFromNewToOld();
                    star.resetAcceleration();
                });
    }

    // Updates the velocity of  each star and
    public void updateVelocitiesForAll(final double dt) {
        stars.forEach(star -> star.updateVelocity(dt));
    }


    public double[] energies() {
        double[] E = {0, 0, 0};
        double rd = 0;

        //Kinetic energy
        //first way
//        for (int i = 0; i != stars.size(); i++) {
//            for (int j = 0; j != 3; j++) {
//                E[1] += stars.get(i).mass * (stars.get(i).velocity[j] * stars.get(i).velocity[j]);
//            }
//        }

        //second way
//        stars.forEach(star -> {
//            for (int j = 0; j != 3; j++) {
//                E[1] += star.mass * Math.pow(star.velocity[j], 2);
//            }
//        });
        //third way
        stars.forEach(star -> {
            for (int j = 0; j != 3; j++) {
                E[1] = Math.fma(star.mass, Math.pow(star.velocity[j], 2), E[1]);
            }
        });
        E[1] = 0.5 * E[1];

        //Potential energy
        for (int ii = 0; ii != stars.size() - 1; ii++) {
            for (int j = ii + 1; j != stars.size(); j++) {
                rd = 0;
                for (int i = 0; i != 3; i++) {
//                    rd += (stars.get(ii).position[i] - stars.get(j).position[i]) * (stars.get(ii).position[i] - stars.get(j).position[i]);
                    rd = Math.fma((stars.get(ii).position[i] - stars.get(j).position[i]),
                                  (stars.get(ii).position[i] - stars.get(j).position[i]),
                                  rd);
                }
                E[2] -= (stars.get(ii).mass * stars.get(j).mass) / Math.sqrt(rd);
            }
        }

        E[0] = E[1] + E[2];
        return E;
    }
}
