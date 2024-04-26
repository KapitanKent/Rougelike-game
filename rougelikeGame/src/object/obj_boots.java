package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_boots extends  SuperObject{

    public obj_boots(){

        name = "Boots";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/object/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
