package org.nbabel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Util {

    public static Cluster getClusterFromFile(final String filename) {
        final Cluster cluster = new Cluster();
        try {
            Files.lines(Paths.get(filename))
                    .forEach(line -> createStarAndAddToCluster(cluster, line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cluster;
    }

    private static void createStarAndAddToCluster(final Cluster cluster, final String line) {
        final StringTokenizer numbers = new StringTokenizer(line);

        while (numbers.hasMoreTokens()) {
            numbers.nextToken();

            double mass = Double.parseDouble(numbers.nextToken());
            Star star = new Star(mass);

            star.position[0] = Double.parseDouble(numbers.nextToken());
            star.position[1] = Double.parseDouble(numbers.nextToken());
            star.position[2] = Double.parseDouble(numbers.nextToken());

            star.velocity[0] = Double.parseDouble(numbers.nextToken());
            star.velocity[1] = Double.parseDouble(numbers.nextToken());
            star.velocity[2] = Double.parseDouble(numbers.nextToken());

            cluster.stars.add(star);
        }
    }

    public static void main(String[] args) {
                /*
        HotSpotIntrinsicCandidate which means that JIT could replace them with actual CPU native instructions -
        if such are available, but this would mean that the method has to be hot enough -
        called multiple times and that's a JVM dependent thing.
         */
        double result = 0;
        for (int i = 0; i < 50_00000; ++i) {
            result = result + Math.fma(i, i, i);
        }
        System.out.println(result);

    }
}
