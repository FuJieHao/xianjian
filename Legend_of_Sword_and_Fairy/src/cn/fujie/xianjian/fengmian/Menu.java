package cn.fujie.xianjian.fengmian;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu  {
    Image[] menuImages;
    int menuX, menuY;
    int menuIndex;
    Image menuImage;

    public int getMenuIndex() {
        return menuIndex;
    }

    Menu () {
        this.menuImages = new Image[4];
        for (int i = 0; i < this.menuImages.length; i++) {
            try {
                this.menuImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/Menu/" + i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.menuX = 0;
        this.menuY = 0;
        this.menuIndex = 0;
        this.menuImage = this.menuImages[0];
    }

    public void up() {
        if (menuIndex == 0){
            menuIndex ++;
        } else {
            menuIndex --;
        }
        if (menuIndex <= 1) {
            menuIndex = 1;
        }
        menuImage = menuImages[menuIndex];
    }

    public void down() {
        if (menuIndex == 0){
            menuIndex ++;
        } else {
            menuIndex ++;
        }
        if (menuIndex >= menuImages.length) {
            menuIndex = 1;
        }
        menuImage = menuImages[menuIndex];
    }
}