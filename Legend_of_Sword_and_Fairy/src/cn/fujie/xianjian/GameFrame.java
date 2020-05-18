package cn.fujie.xianjian;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame implements ActionListener {

    public static void main(String[] args) {

        JFrame window = new JFrame();

        window.setSize(1024,768);
        window.setLocationRelativeTo(null);
        window.setTitle("勇哥历险记！--0.12");
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                //输入对话框
                //JOptionPane.showInputDialog(null);
                //消息对话框
                //JOptionPane.showMessageDialog(null);
                //呈现一个确认对话框
                int result = JOptionPane.showConfirmDialog(null, "确认退出？","退出游戏",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        GamePanel panel = new GamePanel();
        window.add(panel);

        //创建线程类的实例化对象，关联自定义画板对象
        Thread thread = new Thread(panel);
        //启动线程
        thread.start();

        window.addKeyListener(panel);
        panel.addKeyListener(panel);

        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
