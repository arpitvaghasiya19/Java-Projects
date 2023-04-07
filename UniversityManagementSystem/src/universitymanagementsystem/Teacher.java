package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Teacher extends JFrame implements ActionListener {

    JTextField tfname,tffname,tfaddress,tfphone,tfmail,tfx,tf12,tfadr;
    JLabel lblempid;
    JDateChooser dcdob;
    JComboBox quaBox,deptBox;
    JButton submit,cancel;

    Random ran = new Random();
    long  emp = Math.abs((ran.nextLong()%9000L) + 107000L);

    Teacher(){
        setLocation(250,70);
        setSize(800,650);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(230,40,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lblemp = new JLabel("Emp Id");
        lblemp.setBounds(50,200,100,30);
        lblemp.setFont(new Font("serif",Font.BOLD,20));
        add(lblemp);


        lblempid = new JLabel("100"+emp);
        lblempid.setBounds(200,200,150,30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone no");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfmail = new JTextField();
        tfmail.setBounds(200,300,150,30);
        add(tfmail);

        JLabel lbl10 = new JLabel("Class X(%)");
        lbl10.setBounds(400,300,200,30);
        lbl10.setFont(new Font("serif",Font.BOLD,20));
        add(lbl10);

        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel lbl12 = new JLabel("Class XII (%)");
        lbl12.setBounds(50,350,200,30);
        lbl12.setFont(new Font("serif",Font.BOLD,20));
        add(lbl12);

        tf12 = new JTextField();
        tf12.setBounds(200,350,150,30);
        add(tf12);

        JLabel lbladr = new JLabel("Aadhar No ");
        lbladr.setBounds(400,350,200,30);
        lbladr.setFont(new Font("serif",Font.BOLD,20));
        add(lbladr);

        tfadr = new JTextField();
        tfadr.setBounds(600,350,150,30);
        add(tfadr);

        JLabel lbledu = new JLabel("Highest Qua.");
        lbledu.setBounds(50,400,200,30);
        lbledu.setFont(new Font("serif",Font.BOLD,20));
        add(lbledu);

        String qualification[] = {"BE","BSc","Msc","BBA","MBA","BCA","MCA","PhD"};
        quaBox = new JComboBox(qualification);
        quaBox.setBounds(200,400,150,30);
        add(quaBox);

        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(400,400,200,30);
        lbldept.setFont(new Font("serif",Font.BOLD,20));
        add(lbldept);

        String dept[] = {"Computer","Electroncs","Mechanical","Automobile","Civil","IC"};
        deptBox = new JComboBox(dept);
        deptBox.setBounds(600,400,150,30);
        add(deptBox);

        submit = new JButton("Login");
        submit.setBounds(250,500,120,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.DARK_GRAY);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,500,120,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Teacher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String empid = lblempid.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone =tfphone.getText();
            String email = tfmail.getText();
            String x = tfx.getText();
            String xii = tf12.getText();
            String aadhar = tfadr.getText();
            String qual = (String) quaBox.getSelectedItem();
            String dept = (String) deptBox.getSelectedItem();

            try{
                String query = "insert into teacher values('"+name+"', '"+fname+"', '"+empid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"','"+aadhar+"','"+qual+"','"+dept+"')";
                Connec c= new Connec();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher's details Inserted Successfully");
                setVisible(false);
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}

