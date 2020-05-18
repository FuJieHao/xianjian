package cn.fujie.xianjian;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChuanSongMen {
    public Image[] images;
    public int x,y;
    public int index;
    public int source;
    public int destination;

    public ChuanSongMen(int picnum, int x, int y, String path, int destination, int source) {
        this.x = x;
        this.y = y;
        this.index = 0;
        this.destination = destination;
        this.source = source;
        images = new Image[picnum];
        for(int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/" + path + "/" + String.format("100%02d",i) + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
