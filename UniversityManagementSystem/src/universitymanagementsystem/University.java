package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;

public class University extends JFrame implements Runnable{
    Thread t;
    University(){
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900,650, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel((i3));
//        add(image);
        t = new Thread(this);
        t.start();

        setLocation(250,70);
        setSize(900,650);
        setVisible(true);
    }

    public static void main(String args[]){
        new University();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e) {

        }
    }
}

