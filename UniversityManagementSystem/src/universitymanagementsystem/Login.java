package universitymanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField tfusername,tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("User Name ");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password ");
        lblpassword.setBounds(40,60,100,20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,60,150,20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.DARK_GRAY);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.addActionListener(this);
        add(cancel);

        setLocation(400,200);
        setSize(380,240);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            setVisible(false);
        }else if(e.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String query = "select * from login where username='" + username+ "'and password='"+password+"'";

            try{
                Connec c = new Connec();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
                c.s.close();
            }catch (Exception e1){

            }

        }
    }
}

