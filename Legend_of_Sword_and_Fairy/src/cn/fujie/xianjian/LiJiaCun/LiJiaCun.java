package cn.fujie.xianjian.LiJiaCun;
import cn.fujie.xianjian.*;

import javax.swing.*;
import java.awt.*;

public class LiJiaCun extends Scene {

    //38shang  40xia, zuo37 you39
    PeiJue aw = new PeiJue(17,"AWangShen",550,540,37);
    PeiJue wc= new PeiJue(14,"WangCaiSao",900,620,39);
    PeiJue az = new PeiJue(6,"AZhu",1000,720,39);
    PeiJue xh = new PeiJue(4,"XiaoHai",1130,830,37);
    PeiJue mj = new PeiJue(6,"MuJi",1010,790,39);
    PeiJue xj = new PeiJue(2,"XiaoJi",1060,780,39);
    PeiJue xxj = new PeiJue(2,"XiaoXiaoJi",1060,810,39);
    ChuanSongMen cs_jia = new ChuanSongMen(66,920,400,"ChuanSong",Scene.jia, Scene.ljc);
    ChuanSongMen cs_sc = new ChuanSongMen(66,100,650,"ChuanSong",Scene.ljcSc, Scene.ljc);

    public LiJiaCun(Lxy lxy, JPanel panel, Chat chat) {
        super(lxy, panel, chat);
        bg = new Bg("LiJiaCun");
        bg.colorValue = -521461;
        peijues = new PeiJue[7];
        csms = new ChuanSongMen[2];

        aw.speechPack = sp.aw; wc.speechPack = sp.wc; az.speechPack = sp.az;
        xh.speechPack = sp.xh; mj.speechPack = sp.mj; xj.speechPack = sp.xj;
        xxj.speechPack = sp.xxj;
        peijues[0] = aw; peijues[1] = wc; peijues[2] = az; peijues[3] = xh; peijues[4] = mj; peijues[5] = xj; peijues[6] = xxj;
        csms[0] = cs_sc; csms[1] = cs_jia;
        //bg.bgX = -300; bg.bgY = -300;
    }

    public boolean peijueAnimation() {
        super.peijueAnimation();

        if (peijues == null) {
            return false;
        }
        for (int i = 0; i < peijues.length; i++) {
            peijues[i].index++;
            if (peijues[i].index >= peijues[i].images.length) {
                peijues[i].index = 0;
            }
        }
        csAnimation(cs_jia);
        csAnimation(cs_sc);
        return true;
    }

    public void paint(Graphics graph) {
        super.paint(graph);

        graph.drawImage(bg.bgImage,bg.bgX,bg.bgY,panel);

        graph.drawImage(aw.images[aw.index],aw.x + bg.bgX,aw.y + bg.bgY,panel);
        graph.drawImage(wc.images[wc.index],wc.x + bg.bgX,wc.y + bg.bgY,panel);
        graph.drawImage(az.images[az.index],az.x + bg.bgX,az.y + bg.bgY,panel);
        graph.drawImage(xh.images[xh.index],xh.x + bg.bgX,xh.y + bg.bgY,panel);
        graph.drawImage(mj.images[mj.index],mj.x + bg.bgX,mj.y + bg.bgY,panel);
        graph.drawImage(xj.images[xj.index],xj.x + bg.bgX,xj.y + bg.bgY,panel);
        graph.drawImage(xxj.images[xxj.index],xxj.x + bg.bgX,xxj.y + bg.bgY,panel);
        graph.drawImage(cs_jia.images[cs_jia.index],cs_jia.x+bg.bgX,cs_jia.y+bg.bgY,panel);
        graph.drawImage(cs_sc.images[cs_sc.index],cs_sc.x+bg.bgX,cs_sc.y+bg.bgY,panel);

        graph.drawImage(lxy.lxyImage,lxy.lxyX + bg.bgX,lxy.lxyY + bg.bgY,panel);

         for (int i = 0; i < strArr.size(); i++) {
             graph.drawString(strArr.get(i),chat.chatBgX+10,chat.chatBgY+50 + 26 * i);
         }
         graph.drawImage(chat.chatbg,chat.chatBgX,chat.chatBgY,panel);

    }
}
