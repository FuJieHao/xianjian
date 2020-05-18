package cn.fujie.xianjian;

import java.io.*;

public class Schedule implements Serializable {
    boolean isRead;
    int x, y;
    int scene;

    Schedule () {
        isRead = false;
        x = 0;
        y = 0;
        scene = 0;
    }

    void save(Lxy lxy, int sceneID) {
        Schedule schedule = new Schedule();
        schedule.isRead = true;
        schedule.x = lxy.lxyX;
        schedule.y = lxy.lxyY;
        schedule.scene = sceneID;
        try {
            FileOutputStream file = new FileOutputStream("cunchu.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(schedule);
            file.close();
            out.close();
        } catch (Exception e) {

        }
    }
    Schedule read() {

        try {
            FileInputStream file = new FileInputStream("cunchu.dat");
            ObjectInputStream in = new ObjectInputStream(file);
            Schedule schedule = (Schedule)in.readObject();
            file.close();
            in.close();
            return schedule;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

}
