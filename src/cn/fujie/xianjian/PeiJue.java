package cn.fujie.xianjian;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PeiJue {
    public Image[] images;
    public int x,y;
    public int index;
    public int meetDir;
    public String[] speechPack;

     public PeiJue(int picnum, String path, int x, int y, int meetDir) {
        images = new Image[picnum];
        this.x = x;
        this.y = y;
        this.index = 0;
        this.meetDir = meetDir;
        circu(path, images);
    }

    void circu(String path, Image[] images) {
        for(int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/" + path + "/" + i + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}