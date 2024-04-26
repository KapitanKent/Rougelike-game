package object;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_Key extends SuperObject{

    public obj_Key(){
        name = "key";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/object/key.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
