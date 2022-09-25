import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class emittingPoint {
    float rx, ry, x, y;
    float radius = 0;
    float theta;
    float radspeed;
    float thetaspeed;

    public emittingPoint(float rx, float ry, float radspeed, float theta, float thetaspeed) {
        this.rx = rx;
        this.ry = ry;
        this.theta = theta;
        this.radspeed = radspeed;
        this.thetaspeed = thetaspeed;
    }

    public void updatePoint() {
        radius += radspeed;
        theta += thetaspeed;
        x = rx + radius * cos(theta);
        y = ry + radius * sin(theta);
    }

}
