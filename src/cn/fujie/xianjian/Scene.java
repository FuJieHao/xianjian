package cn.fujie.xianjian;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene{

    static public int fengMian = 0;
    static public int ljc = 2;
    static public int ljcSc = 3;
    static public int jia = 4;

    public Bg bg;
    public PeiJue[] peijues;
    public ChuanSongMen[] csms;
    public SpeechPack sp = new SpeechPack();

    public int xMin,yMin,xMax,yMax;
    public Lxy lxy;
    public JPanel panel;
    public Chat chat;
    public ArrayList<String> strArr;

    public Scene() {

    }

    public Scene(Lxy lxy, JPanel panel, Chat chat) {
        this.peijues = new PeiJue[0];
        this.csms = new ChuanSongMen[0];
        this.lxy = lxy;
        this.panel = panel;
        this.chat = chat;
    }

    public boolean sceneAnimation() {
        return false;
    }

    public boolean peijueAnimation() {
        return false;
    }

    public void csAnimation(ChuanSongMen csm) {
        csm.index++;
        if (csm.index >= csm.images.length) {
            csm.index = 0;
        }
    }

    public void paint(Graphics graph) {

        xMin = 0; xMax = panel.getWidth() - bg.bgImage.getWidth(null);
        yMin = 0; yMax = panel.getHeight() - bg.bgImage.getHeight(null);

        bg.bgY = (panel.getHeight() - lxy.lxyImage.getHeight(null)) / 2 - lxy.lxyY;
        if (bg.bgY >= yMin) {
            bg.bgY = yMin;
        }else if (bg.bgY <= yMax) {
            bg.bgY = yMax;
        }
        bg.bgX = (panel.getWidth() - lxy.lxyImage.getWidth(null)) / 2 - lxy.lxyX;
        if (bg.bgX >= xMin) {
            bg.bgX  = xMin;
        }else if (bg.bgX <= xMax) {
            bg.bgX= xMax;
        }

        chat.chatBgX = (panel.getWidth() - chat.chatbg.getWidth(null)) / 2;
        strArr = new ArrayList();
        if (chat.isMeetPeiJue == false) {
            chat.chatBgY = panel.getHeight();
            strArr.add(chat.chatStrs[chat.chatIndex]);
        } else {
            if (chat.mark  == true) {
                graph.setColor(Color.BLUE);
                graph.setFont(new Font("宋体",Font.BOLD, 26));

                String tmpStr = chat.chatStrs[chat.chatIndex];
                int tmpWidth = chat.chatbg.getWidth(null);
                int w =  graph.getFontMetrics(graph.getFont()).stringWidth(tmpStr);
                strArr = chat.huanhang(tmpStr,tmpWidth,w);
                chat.chatBgY = panel.getHeight() - chat.chatbg.getHeight(null);
            } else {
                chat.chatBgY = panel.getHeight();
                strArr.add(chat.chatStrs[chat.chatIndex]);
            }
        }
        //graph.drawImage(Toolkit.getDefaultToolkit().getImage(MyFirstPanel.class.getResource("Legend_of_Sword_and_Fairy/LiJiaCun/0.png")),
        // -300,-300,this);
    }
}
