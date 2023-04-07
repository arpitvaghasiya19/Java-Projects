package universitymanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class TeacherDetails extends JFrame implements ActionListener{

    Choice choiceempid;
    JTable table;
    JButton search,print,update,add,cancel;

    TeacherDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
               

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceempid = new Choice();
        choiceempid.setBounds(180,20,150,20);
        add(choiceempid);

        try{
            Connec c =  new Connec();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                choiceempid.add(rs.getString("EmpId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Connec c =  new Connec();
            ResultSet rs = c.s.executeQuery("select * from teacher");
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
        new TeacherDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == search){
           String query = "select * from teacher where EmpId = '"+ choiceempid.getSelectedItem()+"'";
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
           new Teacher();
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
