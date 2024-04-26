package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_crystal extends  SuperObject{

    public obj_crystal(){
        name = "crystal";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/object/crystal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
