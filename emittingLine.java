import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class emittingLine {

    float rx, ry, x1, y1, x2, y2;
    float radius = 0;
    float lineLength;
    float theta;
    float radspeed;
    float thetaspeed;

    public emittingLine(float rx, float ry, float lineLength, float theta, float radspeed, float thetaspeed) {
        this.rx = rx;
        this.ry = ry;
        this.lineLength = lineLength;
        this.theta = theta;
        this.radspeed = radspeed;
        this.thetaspeed = thetaspeed;
    }

    public void updateLine() {
        radius += radspeed;
        theta += thetaspeed;
        if (radius < lineLength) {
            x1 = rx;
            y1 = rx;
            x2 = rx + radius * cos(theta);
            y2 = ry + radius * sin(theta);
        } else {
            x1 = rx + (radius - lineLength) * cos(theta);
            y1 = ry + (radius - lineLength) * sin(theta);
            x2 = rx + radius * cos(theta);
            y2 = ry + radius * sin(theta);
        }

    }

}
