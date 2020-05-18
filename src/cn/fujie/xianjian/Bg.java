package cn.fujie.xianjian;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bg {

    public  Image[] bgImages;
    public  int index;
    public  Image bgImage;
    public  int bgX, bgY;
    public  BufferedImage bgData;
    public  int colorValue;

    public Bg(String path) {
        this.index = 0;
        try {
            bgImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/"+ path +"/0.png"));
            bgData = ImageIO.read(new File("Legend_of_Sword_and_Fairy/"+ path +"/RedMap.png"));

        } catch (IOException e) {
            //e.printStackTrace();
        }

        colorValue = 0;
        bgY = -300; bgX = -300;
    }
}
