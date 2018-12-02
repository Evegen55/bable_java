package org.nbabel;

import static org.nbabel.Util.getClusterFromFile;

public class NBable {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You should point filename like here: java NBable <full path to input file>");
            System.exit(0);
        }

        final Cluster cluster = getClusterFromFile(args[0]);

        long startTime = System.nanoTime(); //START

        double t = 0.0;
        double dt = 0.001;
        double tend = 1.0;

        double[] E = cluster.energies();
        double[] Eold = E;

        System.out.println("Initial Energy of system  = " + E[0] + "\t Kinetic energy = " + E[1] + "\t Potential energy = " + E[2]);

        cluster.acc();

        int count = 0;
        while (t < tend) {

            cluster.updatePositionsAndAccelerationsForAll(dt);
            cluster.acc();
            cluster.updateVelocitiesForAll(dt);

            count++;
            t += dt;

            if (count % 10 == 0) {
                Eold = E;
                E = cluster.energies();
                System.out.println("\tt=" + t + "\tE=" + E[0] +
                                   "\tKinetic energy = " + E[1] +
                                   "\tPotential energy = " + E[2] +
                                   "\t\tde=" + (E[0] - Eold[0]) / Eold[0]);

            }

//            System.out.println((0.25 + E[0]) / 0.25);
        }

        long endTime = System.nanoTime();   //FINISH

        double estTime = ((endTime - startTime) / (Math.pow(10, 9)));

        double finalValue = Math.round(estTime * 1000.0) / 1000.0;

        System.err.print("time for work: " + finalValue + "s\t");
    }

}



