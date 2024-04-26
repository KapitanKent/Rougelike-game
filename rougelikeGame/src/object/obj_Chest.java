package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_Chest extends SuperObject{
    public obj_Chest(){
        name = "chest";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/object/chest.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
