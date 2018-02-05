/*Star class contains information about star (mass,position and velocity) and
150 methods to update position, velocity and acceleration */
public class Star {
    public double m;
    public double[] r = new double[3];
    public double[] v = new double[3];
    public double[] a = new double[3];
    public double[] aold = new double[3];

    public Star() {
        m = 0;
        double[] ze = {0, 0, 0};
        r = ze;
        v = ze;
    }

    public Star(double mass, double[] pos, double[] vel) {
        m = mass;
        r = pos;
        v = vel;
    }

    public void reset_a() {
        for (int i = 0; i != 3; i++) {
            a[i] = 0.0;
        }
    }

    public void aold_equal_a() {
        for (int i = 0; i != 3; i++) {
            aold[i] = a[i];
        }
    }

    public void update_position(double dt) {
        for (int i = 0; i != 3; i++) {
            double dt2 = dt * dt;
            r[i] += v[i] * dt + 0.5 * a[i] * dt2;
        }
    }

    public void update_velocity(double dt) {
        for (int i = 0; i != 3; i++) {
            v[i] += 0.5 * dt * (a[i] + aold[i]);
        }
    }
}