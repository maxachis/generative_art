import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;


public class emittingBezier {
    float rx, ry;
    float[][] xys;
    float[] radii = {0, 0, 0, 0};
    float[] thetas;
    float[] radspeeds;
    float[] thetaspeeds;

    public emittingBezier(float rx, float ry, float[] thetas, float[] radspeeds, float[] thetaspeeds) {
        this.rx = rx;
        this.ry = ry;
        this.xys = new float[][] {{rx, ry}, {rx, ry}, {rx, ry}, {rx, ry}};
        this.thetas = thetas;
        this.radspeeds = radspeeds;
        this.thetaspeeds = thetaspeeds;
    }

    public void updateBezier() {
        for (int i = 0; i < 4; i++) {
            radii[i] += radspeeds[i];
            thetas[i] += thetaspeeds[i];
            xys[i][0] = rx + radii[i] * cos(thetas[i]);
            xys[i][1] = ry + radii[i] * sin(thetas[i]);
        }
    }
}
