package cn.fujie.xianjian.LiJiaCunShiChang;

import cn.fujie.xianjian.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LiJiaCunSC extends Scene {

    ChuanSongMen cs_ljc = new ChuanSongMen(66,-60,670,"ChuanSong",Scene.ljc, Scene.ljcSc);

    public LiJiaCunSC(Lxy lxy, JPanel panel, Chat chat) {
        super(lxy, panel, chat);

        bg = new Bg("LiJiaCunShiChang");
        bg.bgImages = new Image[3];
        for(int i = 0; i < bg.bgImages.length; i++) {
            try {
                bg.bgImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/" + "LiJiaCunShiChang" + "/" + i + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bg.colorValue = -65536;
        bg.bgX = -300; bg.bgY = -300;
        csms = new ChuanSongMen[1];
        csms[0] = cs_ljc;
    }

    public boolean sceneAnimation() {
        super.sceneAnimation();
        csAnimation(cs_ljc);
        if (this.bg.bgImages == null) {
            return false;
        } else {
            this.bg.index++;
            if (this.bg.index >= this.bg.bgImages.length) {
                this.bg.index = 0;
            }
            return true;
        }
    }



    public void paint(Graphics graph) {
        super.paint(graph);

        graph.drawImage(bg.bgImages[bg.index],bg.bgX,bg.bgY,panel);
        graph.drawImage(cs_ljc.images[cs_ljc.index],cs_ljc.x+bg.bgX,cs_ljc.y+bg.bgY,panel);
        graph.drawImage(lxy.lxyImage,lxy.lxyX + bg.bgX,lxy.lxyY + bg.bgY,panel);
    }
}
