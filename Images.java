package pkg21;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Images {

    BufferedImage cards[][] = new BufferedImage[4][13];
    BufferedImage cardSheet;
    BufferedImage background;
    BufferedImage icon;

    public Images() {
        try {
            icon = ImageIO.read(getClass().getResource("/icon.png"));
            cardSheet = ImageIO.read(getClass().getResource("/cards.png"));
            for (int i = 0; i < 4; i++) {
                for (int e = 0; e < 13; e++) {
                    cards[i][e] = cardSheet.getSubimage(e * 79, i * 123, 79, 123);
                }
            }
            background = cardSheet.getSubimage(0, 4 * 123, 79, 123);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
