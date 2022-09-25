public class rotatingBezier {

    float rx;
    float ry;
    float[] radii;

    float[] thetaSpeeds;
    float[] theta = {0, 0, 0};

    public rotatingBezier(float rx, float ry, float[] radii, float[] thetaSpeeds) {
        this.rx = rx;
        this.ry = ry;
        this.radii = radii;
        this.thetaSpeeds = thetaSpeeds;
    }

    void updateTheta() {
        for (int i = 0; i < 3; i++) {
            theta[i] += thetaSpeeds[i];
        }
    }
}
