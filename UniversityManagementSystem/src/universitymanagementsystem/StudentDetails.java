package universitymanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class StudentDetails extends JFrame implements ActionListener{

    Choice choiceroll;
    JTable table;
    JButton search,print,update,add,cancel;

    StudentDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
               

        JLabel heading = new JLabel("Search by En Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceroll = new Choice();
        choiceroll.setBounds(180,20,150,20);
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

        table = new JTable();

        try{
            Connec c =  new Connec();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,790,550);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(22,70,90,20);
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(122,70,90,20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(222,70,90,20);
        add.addActionListener(this);
        add(add);
        
        print = new JButton("Print");
        print.setBounds(322,70,90,20);
        print.addActionListener(this);
        add(print);
                
        cancel = new JButton("Cancel");
        cancel.setBounds(422,70,90,20);
        cancel.addActionListener(this);
        add(cancel);
                
        setLocation(250,70);
        setSize(800,650);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == search){
           String query = "select * from student where Enno = '"+ choiceroll.getSelectedItem()+"'";
           try{
               Connec c = new Connec();
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e2){
               e2.printStackTrace();
           }
       }else if(e.getSource() == update){
           setVisible(false);
       }else if(e.getSource() == add){
           setVisible(false);
           new Student();
       }else if(e.getSource() == print){
           try{
               table.print();
           }catch(Exception e1){
               e1.printStackTrace();
           }
       }else{
           setVisible(false);
       }
    }
}
