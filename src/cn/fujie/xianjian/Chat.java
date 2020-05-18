package cn.fujie.xianjian;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Chat {
    public Image chatbg;
    public String[] chatStrs = {""};
    public int chatBgX,chatBgY;

    public int chatIndex;
    public boolean mark;
    public boolean isMeetPeiJue;

    public Chat () {

        try {
            chatbg = ImageIO.read(new File("Legend_of_Sword_and_Fairy/LiaoTian/0.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.isMeetPeiJue = false;
        this.mark = false;
        this.chatIndex = 0;

        this.chatBgX = 0;
        this.chatBgY = 0;
    }

    public ArrayList huanhang(String tmpStr, int tmpWidth, int w) {
        double bili = w * 1.0 / (tmpWidth - 2 * 10);
        int len = tmpStr.length();
        int start = 0;
        int end = (int)(len / bili);
        ArrayList<String> strArray = new ArrayList<>();
        if (w >tmpWidth - 2 * 10) {
            for (int i = 0; i < (int)bili + 1; i++) {
                strArray.add(tmpStr.substring(start,end));
                start += (int)(len / bili);
                if (i + 1 == (int)bili) {
                    end = len - 1;
                } else {
                    end += (int)(len / bili);
                }
            }
        } else {
            strArray.add(tmpStr);
        }
        return strArray;
    }
}
