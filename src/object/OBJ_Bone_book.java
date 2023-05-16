package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Bone_book extends SuperObject{

    public OBJ_Bone_book() {

        name = "Bone_book";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Bone_book.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
