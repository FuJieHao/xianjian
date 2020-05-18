package cn.fujie.xianjian;
import cn.fujie.xianjian.Jia.Jia;
import cn.fujie.xianjian.LiJiaCun.LiJiaCun;
import cn.fujie.xianjian.LiJiaCunShiChang.LiJiaCunSC;
import cn.fujie.xianjian.fengmian.FengMian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class GamePanel extends JPanel implements Runnable, KeyListener,Serializable {

    Schedule schedule = new Schedule();

    Scene scene;
    Lxy lxy = new Lxy();
    Chat chat = new Chat();
    FengMian fengmian = new FengMian(this, chat);
    LiJiaCun ljc = new LiJiaCun(lxy,this, chat);
    LiJiaCunSC ljcSc = new LiJiaCunSC(lxy,this, chat);
    Jia home = new Jia(lxy,this, chat);
    int sceneID;

    public GamePanel() {
        if (schedule.read() == null) {
            scene = fengmian;
            sceneID = Scene.fengMian;
        } else {
            if (schedule.read().scene == Scene.ljc) {
                scene = ljc;
            } else if (schedule.read().scene == Scene.ljcSc) {
                scene = ljcSc;
            } else if (schedule.read().scene == Scene.jia) {
                scene = home;
            }
            sceneID = schedule.read().scene;
            lxy.lxyX = schedule.read().x;
            lxy.lxyY = schedule.read().y;
        }
    }

    public void paint(Graphics graph) {
        super.paint(graph);
        //graph.drawLine(10,20,30,40);
        scene.paint(graph);
    }

    //runnable重载方法
    public void run() {

        while (true) {
            int sleep;
            stop(1);
            if (scene.peijueAnimation()) {
                sleep = 130;
                //停顿
                stop(sleep);
            }
            if (scene.sceneAnimation()) {
                //停顿
                sleep = 250;
                stop(sleep);
            }
        }
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (chat.mark == false) {
            //KeyEvent.VK_SPACE
            if (keyCode == 32) {
                int mark = 0;
                for (int i = 0; i < scene.peijues.length; i++) {
                    if (lxy.isMeet(scene.peijues[i]) == true) {
                        chat.isMeetPeiJue = true;
                        chat.chatStrs = scene.peijues[i].speechPack;
                        chat.mark = !chat.mark;
                        mark = 1;
                    }
                }
                if (mark == 0) {
                    chat.isMeetPeiJue = false;
                }
            }
            if (sceneID == Scene.fengMian) {

                if (keyCode == 38) {
                    fengmian.menu.up();
                    repaint();

                } else if (keyCode == 40) {
                    fengmian.menu.down();
                } else if (keyCode == 10 && fengmian.menu.getMenuIndex() != 0) {
                    if (fengmian.menu.getMenuIndex() == 3) {
                        System.out.println("退出游戏");
                        System.exit(0);
                    } else {
                        scene = ljc;
                        sceneID = Scene.ljc;
                        repaint();
                    }
                }
            } else {
                //上
                if (keyCode == 38) {
                    lxy.move(scene,3,-1,Lxy.up);
                    //下
                } else if (keyCode == 40) {
                    lxy.move(scene,0,1,Lxy.down);
                    //左
                } else if (keyCode == 37) {
                    lxy.move(scene,1,-1,Lxy.left);
                    //右
                } else if (keyCode == 39) {
                    lxy.move(scene,2,1,Lxy.right);

                } else if (keyCode == KeyEvent.VK_ENTER) {
                    if (lxy.csmCheack(scene.csms)[0] != 0) {
                        int destination = lxy.csmCheack(scene.csms)[0];
                        int source = lxy.csmCheack(scene.csms)[1];
                        if (destination == Scene.ljc) {
                            scene = ljc;
                            sceneID = Scene.ljc;
                            if (source == Scene.ljcSc) {
                                lxy.yiwei(165,680);
                                lxy.direct(Lxy.right);
                            } else if (source == Scene.jia) {
                                lxy.yiwei(980,440);
                                lxy.direct(Lxy.down);
                            }
                            repaint();
                        } else if (destination == Scene.ljcSc) {
                            scene = ljcSc;
                            sceneID = Scene.ljcSc;
                            lxy.direct(Lxy.right);
                            lxy.yiwei(0,700);
                            repaint();
                        } else if (destination == Scene.jia) {
                            scene = home;
                            sceneID = Scene.jia;
                            lxy.yiwei(150,470);
                            lxy.direct(Lxy.up);
                            repaint();
                        }
                    }
                } else if (keyCode == 83) {
                    schedule.save(lxy,sceneID);
                }
            }
            repaint();
        } else {
            if (keyCode == 32) {
                if (chat.chatIndex >= chat.chatStrs.length - 1) {
                    chat.chatIndex = 0;
                    chat.mark = !chat.mark;
                } else  {
                    chat.chatIndex ++;
                }
                repaint();
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }

    void stop(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //刷新操作
        repaint();
    }

}
