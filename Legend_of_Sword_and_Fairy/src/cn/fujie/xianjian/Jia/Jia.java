package cn.fujie.xianjian.Jia;

import cn.fujie.xianjian.*;

import javax.swing.*;
import java.awt.*;

public class Jia extends Scene {

    ChuanSongMen cs_ljc = new ChuanSongMen(66,110,435,"ChuanSong",Scene.ljc, Scene.jia);

    public Jia(Lxy lxy, JPanel panel, Chat chat) {
        super(lxy,panel,chat);

        bg = new Bg("Jia");
        bg.bgX = 0;
        bg.bgY = 0;

        csms = new ChuanSongMen[1];
        csms[0] = cs_ljc;
    }

    public boolean sceneAnimation() {
        csAnimation(cs_ljc);
        return true;
    }

    public void paint(Graphics graph) {
        super.paint(graph);
        int bgX = 0; int bgY = 0;
        graph.drawImage(bg.bgImage,bgX,bgY,1006,721,panel);
        graph.drawImage(cs_ljc.images[cs_ljc.index],cs_ljc.x,cs_ljc.y,panel);
        graph.drawImage(lxy.lxyImage,lxy.lxyX ,lxy.lxyY,panel);
    }
}
