package librarymanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class New_student extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JPanel p;
    JTextField tf1,tf2;
    JComboBox cb;
    JButton b1,b2;
    Menubar mb;
    String q,flag;
    String student_id,name,department;
    String session;
    boolean b;
    
    
    public New_student(String session, boolean b){
    
        super("New Student");
        
        //determining admin or librarian (role)
        this.session=session;
        this.b=b;
        
        //menubar class
        mb= new Menubar(session);
        mb.i1.addActionListener(this);
        mb.i2.addActionListener(this);
        mb.i3.addActionListener(this);
        setJMenuBar(mb.mb);
        
        //panel to hold
        p= new JPanel();
        p.setBounds(30, 30, 325, 380);
        p.setBackground(Color.green);
        p.setBorder(BorderFactory.createLineBorder(Color.blue));
        p.setLayout(null);
        add(p);
        
        //student id label
        l1= new JLabel("Student ID");
        l1.setBounds(90,20,200,35);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setForeground(Color.white);
        p.add(l1);
        
        //student id textfield
        tf1= new JTextField();
        tf1.setBounds(90,60,150,25);
        p.add(tf1);
        
        
         //student name label
        l2= new JLabel("Student Name");
        l2.setBounds(90,100,200,35);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l2.setForeground(Color.white);
        p.add(l2);
        
        //student name textfield
        tf2= new JTextField();
        tf2.setBounds(90,140,150,25);
        p.add(tf2);
        
        //student department label
        l3= new JLabel("Department");
        l3.setBounds(90,180,200,35);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setForeground(Color.white);
        p.add(l3);
        
        //department choose combobox
        String [] combo={"CSE","Pharmacy","Architecture","Civil","EEE","English","Law"};
        cb= new JComboBox(combo);
        cb.setBounds(90,220,150,25);
        p.add(cb);
        
        //Add student(submit) Button
        b1= new JButton("Add Student");
        b1.setBounds(90,270,150,25);
        b1.setBackground(Color.green);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        p.add(b1);
        
         //back Button
        b2= new JButton("Back");
        b2.setBounds(90,310,150,25);
        b2.setBackground(Color.green);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        p.add(b2);
        
        
        
        //frame setting
        setLayout(null);
        setVisible(true);
        setSize(400,500);
        setLocation(100,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    } //constructor ends here
    
    @Override
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==mb.i1){
             int input = JOptionPane.showConfirmDialog(null, 
                "Are you really want to Logout?", "Logout!", JOptionPane.YES_NO_OPTION);
            if(input==0){
            setVisible(false);
            new Login();
            }
        
        }
          if(ae.getSource()==mb.i2){
            
            new Student_details();
            
        }
            if(ae.getSource()==mb.i3){
            
            new Book_Stats();
            
        }
        
        if(ae.getSource()==b2){
            setVisible(false);
        new Dashboard(session,b);
        
        }
        
        if(ae.getSource()==b1){
        
            student_id=tf1.getText();
            name=tf2.getText();
            department= String.valueOf(cb.getSelectedItem());
            
            if((student_id.equals(""))||(name.equals(""))){
                JOptionPane.showMessageDialog(null,"please fill out all the fields");
            }else{
            
            try{
                Conn c= new Conn();
                q="insert into students values('"+student_id+"','"+name+"','"+department+"')";
                flag="select student_id from students where student_id="+student_id+"";
                
                ResultSet rss= c.s.executeQuery(flag);
                if(rss.next()){
                   JOptionPane.showMessageDialog(null,"An account is already exist with this id");
                
                } else{
                
                 c.s.executeUpdate(q);
                 JOptionPane.showMessageDialog(null,"Account created successfully");
//                 setVisible(false);
//                 new Login();
//                   new Dashboard(session,b);
                   tf1.setText("");
            tf2.setText("");
            cb.setSelectedIndex(0);
                }
                
                
            
            
            }catch(Exception e){
            
                e.printStackTrace();
            }
        
        }
        }
    
    
    }
    
}
