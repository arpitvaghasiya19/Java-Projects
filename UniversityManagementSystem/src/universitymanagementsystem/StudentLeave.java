package universitymanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;


public class StudentLeave extends JFrame implements ActionListener{
    
    Choice choiceroll, ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    StudentLeave(){
        setSize(450,600);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("Apply Leave for Student");
        heading.setFont(new Font("serif",Font.BOLD,23));
        heading.setBounds(20,20,350,25);
        add(heading);
        
        JLabel lblenno = new JLabel("Search by En Number");
        lblenno.setFont(new Font("tamoha",Font.PLAIN,19));
        lblenno.setBounds(60,100,250,20);
        add(lblenno);

        choiceroll = new Choice();
        choiceroll.setBounds(60,130,250,20);
        add(choiceroll);

        try{
            Connec c =  new Connec();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()){
                choiceroll.add(rs.getString("Enno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setFont(new Font("tamoha",Font.PLAIN,19));
        lbldate.setBounds(60,180,250,20);
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,250,30);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Date");
        lbltime.setFont(new Font("tamoha",Font.PLAIN,19));
        lbltime.setBounds(60,260,250,20);
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60,290,250,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.DARK_GRAY);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new StudentLeave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == submit){
           String enno = choiceroll.getSelectedItem();
           String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
           String dduration = ctime.getSelectedItem();
           
           String query = "insert into studentleave values('"+enno+"', '"+date+"', '"+dduration+"')";
           
           try{
               Connec c= new Connec();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Leave Confirmed");
               setVisible(false);
           }catch(Exception e1){
               e1.printStackTrace();
           }
       }else{
           setVisible(false);
       }
    }
}
