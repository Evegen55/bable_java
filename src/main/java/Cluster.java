import java.util.ArrayList;
import java.util.List;

/**
 * cluster contains set of stars and methods to calculate acceleration, update
 * acceleration,calculate energy
 */
public class Cluster {

    public final List<Star> N = new ArrayList<>();

    public void acc() {
        for (Star aN : N) {
            aN.reset_a(); //reset star acceleration (a) to zero
        }

        double rd;        //rd used to store distance
        for (int ii = 0; ii != N.size(); ii++) {
            for (int j = ii + 1; j != N.size(); j++) {
                rd = 0;
                for (int i = 0; i != 3; i++) {
                    rd += (N.get(ii).r[i] - N.get(j).r[i]) * (N.get(ii).r[i] - N.get(j).r[
                            i]);
                }
                double coff = Math.pow(Math.sqrt(rd), 3);
                for (int i = 0; i != 3; i++) {
                    N.get(ii).a[i] += (N.get(j).m / coff) * (N.get(j).r[i] - N.get(ii).r[i]);
                    N.get(j).a[i] += (N.get(ii).m / coff) * (N.get(ii).r[i] - N.get(j).r[i]);
                }
            }
        }
    }

    public void update_positions(double dt) {  //updates the position of each star
        for (Star aN : N) {
            aN.update_position(dt);
        }
    }

    public void update_velocities(double dt) {       // Updates the velocity of  each star and
        for (Star aN : N) {  // then updata aold (Sets aold equal to a)
            aN.update_velocity(dt);
        }
    }

    public void update_acc() {   // Updates aold (Sets aold equal to a)
        for (Star aN : N) {
            aN.aold_equal_a();//aold[0]=N.get(kk).a[0];
        }
    }


    public double[] energies() {
        double[] E = {0, 0, 0};
        double rd = 0;

        //Kinetic energy
        for (int i = 0; i != N.size(); i++) {
            for (int j = 0; j != 3; j++) {
                E[1] += N.get(i).m * (N.get(i).v[j] * N.get(i).v[j]);
            }
        }

        //Potential energy
        for (int ii = 0; ii != N.size() - 1; ii++) {
            for (int j = ii + 1; j != N.size(); j++) {
                rd = 0;
                for (int i = 0; i != 3; i++) {
                    rd += (N.get(ii).r[i] - N.get(j).r[i]) * (N.get(ii).r[i] - N.get(j).r[
                            i]);
                }
                E[2] -= (N.get(ii).m * N.get(j).m) / Math.sqrt(rd);
            }

            E[1] = 0.5 * E[1];
            E[0] = E[1] + E[2];
            return E;
        }
        return null;
    }
}
