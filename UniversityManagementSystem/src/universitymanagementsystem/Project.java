package universitymanagementsystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    Project(){
        setSize(1366,768);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/images1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1366,710, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel((i3));
        add(image);
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        //Information
        JMenu newinformation = new JMenu("New Information");
        mb.add(newinformation);

        JMenuItem studentinfo = new JMenuItem("New Student Information");
        studentinfo.addActionListener(this);
        newinformation.add(studentinfo);

        JMenuItem facultyinfo = new JMenuItem("New Faculty Information");
        facultyinfo.addActionListener(this);
        newinformation.add(facultyinfo);

        //Details
        JMenu newdetails = new JMenu("View Details");
        mb.add(newdetails);

        JMenuItem student_details = new JMenuItem("View Student details");
        student_details.addActionListener(this);
        newdetails.add(student_details);

        JMenuItem faculty_details = new JMenuItem("View Faculty details");
        faculty_details.addActionListener(this);
        newdetails.add(faculty_details);


        //Leave
        JMenu leave = new JMenu("Apply Leave");
        mb.add(leave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.addActionListener(this);
        leave.add(studentleave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        //leave details
        JMenu leavedetails = new JMenu("Leave Details");
        mb.add(leavedetails);

        JMenuItem studentldetails = new JMenuItem("Student Leave Details");
        studentldetails.addActionListener(this);
        leavedetails.add(studentldetails);

        JMenuItem facultyldetails = new JMenuItem("Faculty Leave Details");
        facultyldetails.addActionListener(this);
        leavedetails.add(facultyldetails);

        //Exam details
        JMenu exam = new JMenu("Exams");
        mb.add(exam);

        JMenuItem examdetails = new JMenuItem("Exam results");
        examdetails.addActionListener(this);
        exam.add(examdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //information update
        JMenu updateinfo = new JMenu("Update Details");
        mb.add(updateinfo);

        JMenuItem updatestudentldetails = new JMenuItem("Update Student Details");
        updatestudentldetails.addActionListener(this);
        updateinfo.add(updatestudentldetails);

        JMenuItem updatefacultyldetails = new JMenuItem("Update Faculty Details");
        updatefacultyldetails.addActionListener(this);
        updateinfo.add(updatefacultyldetails);

        
        //Instant apps
        JMenu apps = new JMenu("Instant Apps");
        mb.add(apps);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.addActionListener(this);
        apps.add(Calculator);

        JMenuItem Np = new JMenuItem("Notepad");
        Np.addActionListener(this);
        apps.add(Np);

        //Exit
        JMenu exit = new JMenu("Exit");
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        exit.add(ex);
        ex.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();

        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ae){

            }
        }else if(msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ae) {

            }
        }else if(msg.equals("New Faculty Information")) {
            new Teacher();
        }else if(msg.equals("New Student Information")) {
            new Student();
        }else if(msg.equals("View Faculty details")) {
            new TeacherDetails();
        }else if(msg.equals("View Student details")) {
            new StudentDetails();
        }else if(msg.equals("Student Leave")) {
            new StudentLeave();
        }else if(msg.equals("Teacher Leave")) {
            new TeacherLeave();
        } else if(msg.equals("Student Leave Details")) {
            new Studentleavedetails();
        }else if(msg.equals("Faculty Leave Details")) {
            new Teacherleavedetails();
        } else if(msg.equals("Update Student Details")) {
            new UpdateStudent();
        }else if(msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if(msg.equals("Enter Marks")) {
            new MarksEnter();
        }else if(msg.equals("Exam results")) {
            new ExamDetails();
        } 
    }

    public static void main(String[] args) {
        new Project();
    }
}

 