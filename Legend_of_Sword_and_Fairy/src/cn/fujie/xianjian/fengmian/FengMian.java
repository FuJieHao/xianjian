package cn.fujie.xianjian.fengmian;

import cn.fujie.xianjian.Bg;
import cn.fujie.xianjian.Chat;
import cn.fujie.xianjian.Scene;
import javax.swing.*;
import java.awt.*;

public class FengMian extends Scene {

    public Menu menu = new Menu();

    public FengMian (JPanel panel, Chat chat) {
        this.panel = panel;
        this.chat = chat;
        bg = new Bg("FengMian");
        bg.bgX = 0;
        bg.bgY = 0;
    }

    public void paint(Graphics graph) {
        menu.menuX = (panel.getWidth() - menu.menuImage.getWidth(null))/2;
        menu.menuY = (panel.getHeight() - menu.menuImage.getHeight(null))/2;
        //super.paint(graph);
        graph.drawImage(bg.bgImage,bg.bgX,bg.bgY,1006,721,panel);
        graph.drawImage(menu.menuImage,menu.menuX,menu.menuY,panel);
    }
}
