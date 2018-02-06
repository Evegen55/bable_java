package org.nbabel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class NBable {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You should point filename like here: java NBable <full path to input file>");
            System.exit(0);
        }

        int count = 0;
        double t = 0.0;
        double dt = 0.001;
        double tend = 1.0;

        final Cluster cluster = new Cluster();
        final String filename = args[0];
        try {
            Files.lines(Paths.get(filename)).forEach(line -> createStarAndAddToCluster(cluster, line));
        } catch (IOException e) {
            e.printStackTrace();
        }

        double[] E = cluster.energies();
        double[] Eold = E;
        System.out.println(E[0] + "\t Kinetic energy = " + E[1] + "\t Potential energy = " + E[2]);
        cluster.acc();
        while (t < tend) {
            cluster.update_positions(dt);
            cluster.update_acc();
            cluster.acc();
            cluster.update_velocities(dt);

            count++;
            t += dt;
            if (count % 10 == 0) {
                Eold = E;
                E = cluster.energies();
                System.out.print(" t=" + t + " E=" + E[0] + "\t Kinetic energy = " + E[1] +
                        "\t Potential energy = " + E[2] + " de=");
                System.out.println((E[0] - Eold[0]) / Eold[0]);
            }
            System.out.println((0.25 + E[0]) / 0.25);
        }
    }

    private static void createStarAndAddToCluster(final Cluster cluster, final String line) {
        final StringTokenizer numbers = new StringTokenizer(line);
        double mass;
        final double[] pos = new double[3];
        final double[] vel = new double[3];
        while (numbers.hasMoreTokens()) {
            numbers.nextToken();
            mass = Double.parseDouble(numbers.nextToken());
            pos[0] = Double.parseDouble(numbers.nextToken());
            pos[1] = Double.parseDouble(numbers.nextToken());
            pos[2] = Double.parseDouble(numbers.nextToken());
            vel[0] = Double.parseDouble(numbers.nextToken());
            vel[1] = Double.parseDouble(numbers.nextToken());
            vel[2] = Double.parseDouble(numbers.nextToken());
            cluster.N.add(new Star(mass, pos, vel));
        }
    }
}



