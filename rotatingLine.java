public class rotatingLine {

    float rx;
    float ry;
    float radius;
    float thetaSpeed;
    float theta = 0;

    public rotatingLine(float rx, float ry, float radius, float thetaSpeed) {
        this.rx = rx;
        this.ry = ry;
        this.radius = radius;
        this.thetaSpeed = thetaSpeed;
    }

    void updateTheta() {
        this.theta += thetaSpeed;
    }

}
