import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NBable {
    public static void main(String[] args) {
        int count = 0;
        double t = 0.0;
        double dt = 0.001;
        double tend = 1.0;

        Cluster cl = new Cluster();
        //Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = null;
        String dummy = null;

        try {
            while ((Input = br.readLine()) != null) {

                StringTokenizer numbers = new StringTokenizer(Input);
                double mass;
                double[] pos = new double[3];
                double[] vel = new double[3];
                while (numbers.hasMoreTokens()) {
                    dummy = numbers.nextToken();
                    mass = Double.parseDouble(numbers.nextToken());
                    pos[0] = Double.parseDouble(numbers.nextToken());
                    pos[1] = Double.parseDouble(numbers.nextToken());
                    pos[2] = Double.parseDouble(numbers.nextToken());
                    vel[0] = Double.parseDouble(numbers.nextToken());
                    vel[1] = Double.parseDouble(numbers.nextToken());
                    vel[2] = Double.parseDouble(numbers.nextToken());
                    cl.N.add(new Star(mass, pos, vel));
                }

            }
        } catch (IOException ioe) {
            System.out.println("IO error: check input");
            System.exit(1);
        }

        double[] E = cl.energies();
        double[] Eold = E;
        System.out.println(E[0] + " " + E[1] + " " + E[2]);
        cl.acc();
        while (t < tend) {
            cl.update_positions(dt);
            cl.update_acc();
            cl.acc();
            cl.update_velocities(dt);

            count++;
            t += dt;
            if (count % 10 == 0) {
                Eold = E;
                E = cl.energies();
                System.out.print(" t=" + t + " E=" + E[0] + " KE=" + E[1] + " PE=" + E[2] + " de=");
                System.out.println((E[0] - Eold[0]) / Eold[0]);
            }
            System.out.println((0.25 + E[0]) / 0.25);
        }
    }
}



