package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_Door extends SuperObject {

    public obj_Door(){
        name = "Door";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/object/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
