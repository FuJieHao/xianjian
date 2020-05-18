package cn.fujie.xianjian;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Lxy {

    static public int up = 38;
    static public int down = 40;
    static public int left = 37;
    static public int right = 39;

    public Image[][] lxyImages;
    public int lxyX, lxyY;
    public int lxyIndex;
    public Image lxyImage;

    public int lxyDir;

    public Lxy() {
        this.lxyImages = new Image[4][8];
        for (int j = 0; j < this.lxyImages.length; j++) {
            for (int i = 0; i < this.lxyImages[j].length; i++) {
                try {
                    this.lxyImages[j][i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/LiXiaoYao_" + (j+1) +"/" + i + ".png"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        this.lxyX = 800;
        this.lxyY = 600;
        this.lxyIndex = 0;
        this.lxyImage = this.lxyImages[0][0];
    }

    public void move(Scene scene, int direc, int zf, int lxyDir) {

        int height =  scene.bg.bgImage.getHeight(null);
        int width = scene.bg.bgImage.getWidth(null);
        if (height <= 738) {height = 738;}
        if (width <= 1024) {width = 1024;}
        if (direc == 3 || direc == 0) {
            int temp = this.lxyY;
            if (direc == 3) {
                if (this.lxyY <= 0) {
                    this.lxyY = temp;
                } else {
                    this.lxyY = temp + (5 * zf);
                }
            } else if (direc == 0) {

                if (this.lxyY >= height -this.lxyImage.getHeight(null)) {
                    this.lxyY = temp;
                } else  {
                    this.lxyY = temp + (5 * zf);
                }
            }

        }else if (direc == 1 || direc == 2) {
            int temp = this.lxyX;
            if (direc == 1) {
                if (this.lxyX <= 0) {
                    this.lxyX = temp;
                } else {
                    this.lxyX = temp + (5 * zf);
                }
            } else if (direc == 2) {
                if (this.lxyX >= width -this.lxyImage.getWidth(null)) {
                    this.lxyX = temp;
                } else  {
                    this.lxyX = temp + (5 * zf);
                }
            }
        }

        this.lxyIndex++;
        if (this.lxyIndex >= this.lxyImages[direc].length) {
            this.lxyIndex = 0;
        }
        this.lxyImage = this.lxyImages[direc][this.lxyIndex];

        this.lxyDir = lxyDir;

        cheack(scene);
        peiJueCheack(scene.peijues);
    }

    void cheack(Scene scene) {
        if (scene.bg.bgData == null) {
            return;
        }
        int x = this.lxyX + this.lxyImage.getWidth(null)/2;
        int y = this.lxyY + this.lxyImage.getHeight(null);
        if (scene.bg.bgData.getRGB(x,y) == scene.bg.colorValue) {
            if (this.lxyDir == 38 || this.lxyDir == 40) {
                if (this.lxyDir == 38) {
                    this.lxyY += 5;
                } else if (this.lxyDir == 40) {
                    this.lxyY -=5;
                }
            }else if (this.lxyDir == 37 || this.lxyDir == 39) {
                if (this.lxyDir == 37) {
                    this.lxyX += 5;
                } else if (this.lxyDir == 39) {
                    this.lxyX -= 5;
                }
            }
        }
    }

    void peiJueCheack(PeiJue[] peiJues) {

        int x_l = this.lxyX;
        int y_l = this.lxyY + this.lxyImage.getHeight(null);
        int x_r = x_l + this.lxyImage.getWidth(null);
        int y_r = y_l;
        int x_u = x_l + this.lxyImage.getWidth(null) / 2;
        int y_u = y_l;
        int x_d = x_u;
        int y_d = y_u;

        for (int i = 0; i < peiJues.length; i++) {

            int x1 = peiJues[i].x;
            int y1 = peiJues[i].y + peiJues[i].images[0].getHeight(null) / 2;
            int x2 = x1;
            int y2 = y1 + peiJues[i].images[peiJues[i].index].getHeight(null) / 2;
            int x3 = x2 + peiJues[i].images[peiJues[i].index].getWidth(null);
            int y3 = y2;
            int x4 = x3;
            int y4 = y1;

            //System.out.println(String.format("%d,%d,%d,%d,%d,%d,%d,%d",x1,y1,x2,y2,x3,y3,x4,y4));
            if (this.lxyDir == right && x_r > x1+20 && x_r < x4 && y_r > y1 && y_r < y2) {
                this.lxyX -= 5;
            } else if (this.lxyDir == left && x_l < x4 -10 && x_l> x1 && y_l > y4 && y_l < y3) {
                this.lxyX += 5;
            } else if (this.lxyDir == up && y_u < y2 && y_u > y1 && x_u > x2 && x_u < x3) {
                this.lxyY += 5;
            } else if (this.lxyDir == down && y_d > y1 && y_d < y2 && x_d > x1 && x_d < x4) {
                this.lxyY -= 5;
            }
        }
    }

    int[] csmCheack(ChuanSongMen[] csms) {
        int[] return_v = {0,0};
        int x = this.lxyX;
        int y = this.lxyY + this.lxyImage.getHeight(null);
        for (int i = 0; i < csms.length; i++) {
            int x1 = csms[i].x + 20;
            int y1 = csms[i].y + 30;
            int x2 = x1;
            int y2 = y1 + csms[i].images[csms[i].index].getHeight(null) -50;
            int x3 = x2 + csms[i].images[csms[i].index].getWidth(null) -80;
            int y3 = y2;
            int x4 = x3;
            int y4 = y1;
            if (x > x1 && x < x4 && y > y1 && y < y2) {
                return_v[0] = csms[i].destination;
                return_v[1] = csms[i].source;
                return return_v;
            }
        }
        return return_v;
    }

    boolean isMeet(PeiJue peijue) {

        int x = this.lxyX;
        int y = this.lxyY + this.lxyImage.getHeight(null);
        int x2,y2;
        int x1,y1;
        y2 = peijue.y + peijue.images[peijue.index].getHeight(null);
        y1 = y2 - 30;
        if (peijue.meetDir == 37) {
            x2 = peijue.x + peijue.images[peijue.index].getWidth(null);
            x1 = x2 - 30;
            if (this.lxyDir == peijue.meetDir && x > x1 && x < x2 && y > y1 && y < y2) {
                return true;
            } else {
                return false;
            }
        } else if (peijue.meetDir == 39){
            x2 = peijue.x - 50;
            x1 = x2 + 30;
            if (this.lxyDir == peijue.meetDir && x < x1 && x > x2 && y > y1 && y < y2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void yiwei(int x, int y) {
        this.lxyX = x;
        this.lxyY = y;
    }

    public void direct(int direct) {
        if (direct == up) {
            this.lxyImage = this.lxyImages[3][0];
        } else if (direct == down) {
            this.lxyImage = this.lxyImages[0][0];
        } else if (direct == left) {
            this.lxyImage = this.lxyImages[1][0];
        } else if (direct == right) {
            this.lxyImage = this.lxyImages[2][0];
        }
    }
}
