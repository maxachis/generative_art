import org.apache.commons.io.FileUtils;
import processing.core.PApplet;

import java.io.File;
import java.io.IOException;

public class Recorder extends PApplet {

    int numFrames;
    PApplet core;
    public Recorder(int numFrames, PApplet core) {
        this.numFrames = numFrames;
        this.core = core;
        File file = new File("output");
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void record() {
        this.numFrames--;
        this.core.saveFrame("output/frame-########.png");
        if (this.numFrames == 0) {
            this.exit();
        }
    }

}
