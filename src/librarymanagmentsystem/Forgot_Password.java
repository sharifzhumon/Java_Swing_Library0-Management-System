package librarymanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Forgot_Password implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2,b3,b4,b5;
    JTextField t1,t2,t3,t4;
    JComboBox cb;
    String username,password,ques,ans,admin,pass;
    
    public Forgot_Password(){
        
        f= new JFrame("Forgot password");
        f.getContentPane().setBackground(new Color(0,150,150)); //frame color
        
        //main label to store all other label
        l1= new JLabel();
        l1.setBounds(0,0,400,400);
        l1.setLayout(null);
        f.add(l1);
        
        //employee id label
        l2= new JLabel("Employee ID");
        l2.setBounds(20,30,200,25);
        l2.setLayout(null);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l2.setForeground(Color.white);
//        l2.setVisible(false);
        l1.add(l2);
        
        
        //employee id textfield
        t1= new JTextField();
        t1.setBounds(20,60,190,25);
//         t1.setVisible(false);
        l1.add(t1);
        
        //employee role label
        l3= new JLabel("Employee role");
        l3.setBounds(20,100,200,25);
        l3.setLayout(null);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setForeground(Color.white);
//         l3.setVisible(false);
        l1.add(l3);
        
        //employee role dropdown
        String c1[]= {"librarian","admin"} ;
        cb= new JComboBox(c1);
        cb.setBounds(20,130,190,25);
//         c1.setVisible(false);
        l1.add(cb);
        
        //Submit button
        b1= new JButton("Submit");
        b1.setBounds(20,180,80,25);
        b1.setBackground(new Color(0,170,170));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
//        b1.setVisible(false);
        l1.add(b1);
        
        //cancel button
        b2= new JButton("Cancel");
        b2.setBounds(130,180,80,25);
        b2.setBackground(new Color(0,170,170));
        b2.setForeground(Color.white);
//         b2.setVisible(false);
        b2.addActionListener(this);
        l1.add(b2);
        
        //employee question
        l4= new JLabel();
        l4.setBounds(20,230,300,25);
        l4.setFont(new Font("serif",Font.BOLD,19));
        l4.setForeground(Color.white);
        l4.setVisible(false);
        l1.add(l4);
        
        //question answer field
        t2= new JTextField();
        t2.setBounds(20,260,190,25);
        t2.setVisible(false);
        l1.add(t2);
        
        //quest answer query buttons
        b3= new JButton("Submit");
        b3.setBounds(20,300,80,25);
        b3.setBackground(new Color(0,170,170));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
         b3.setVisible(false);
        l1.add(b3);
        
        b4= new JButton("Cancel");
        b4.setBounds(130,300,80,25);
        b4.setBackground(new Color(0,170,170));
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        b4.setVisible(false);
        l1.add(b4);
        
        
        //username label
        l5= new JLabel("Username");
        l5.setBounds(20,30,200,25);
        l5.setLayout(null);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l5.setForeground(Color.white);
        l5.setVisible(false);
        l1.add(l5);
        
        //username return textfield
        t3= new JTextField();
        t3.setBounds(20,60,190,25);
        t3.setVisible(false);
        l1.add(t3);
        
        //password label
        l6= new JLabel("Password");
        l6.setBounds(20,100,200,25);
        l6.setLayout(null);
        l6.setFont(new Font("serif",Font.BOLD,20));
        l6.setForeground(Color.white);
        l6.setVisible(false);
        l1.add(l6);
        
        //password return textfield
        t4= new JTextField();
        t4.setBounds(20,130,190,25);
        t4.setVisible(false);
        l1.add(t4);
        
          //Ok button
        b5= new JButton("OK");
        b5.setBounds(20,180,190,25);
        b5.setBackground(new Color(0,170,170));
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        b5.setVisible(false);
        l1.add(b5);
               
        //frame setting
        f.setVisible(true);
        f.setSize(300,400);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    }// constructor ends here
    
    
    @Override
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
           
            try{
                Conn c= new Conn();
//                System.out.println("Connection");
               
                String user= t1.getText();
                String role= String.valueOf(cb.getSelectedItem());
                 
                String q="select * from "+role+" where employee_id='"+user+"'";
//                System.out.println(q);
                ResultSet rs= c.s.executeQuery(q);
                
                if(rs.next()){
                    username= rs.getString("username");
                    password=rs.getString("password");
                    ques= rs.getString("secret_ques");
                    ans= rs.getString("secret_ques_ans");
                    
                    l4.setText(ques);
                    l4.setVisible(true);
                    t2.setVisible(true);
                    b3.setVisible(true);
                    b4.setVisible(true);

                }
            else{
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID, Please Try Again");
                     t1.setText("");
                     cb.setSelectedIndex(0);
                
                }

            }catch(Exception e){
                e.printStackTrace();
//                System.out.println("I am from b1 exception");
            }
        
        }
        if(ae.getSource()==b3){
                        String answer= t2.getText();
//                        System.out.println(answer);
                            if(ans.equals(answer)){ 
                                
                                l2.setVisible(false);
                                t1.setVisible(false);
                                l3.setVisible(false);
                                cb.setVisible(false);       
                                b1.setVisible(false);
                                b2.setVisible(false);
                                
                                //second field
                                l4.setVisible(false);
                                t2.setVisible(false);
                                b3.setVisible(false);
                                b4.setVisible(false);
                                
                                l5.setVisible(true);
                                t3.setText(username);
                                t4.setText(password);
                                t3.setVisible(true);
                                t4.setVisible(true);
                                b5.setVisible(true);
   
                            } else{
                            
                                JOptionPane.showMessageDialog(null, "Invalid Answer, Please Try Again");
                                t2.setText("");
                            }
                    
                    
                    }
                     if(ae.getSource()==b5){
                            f.setVisible(false);
                            new Login();
                                    
                         }
                     
                      if(ae.getSource()==b4){
                          
                                t1.setText("");
                                cb.setSelectedIndex(0);
                                l4.setVisible(false);
                                t2.setVisible(false);
                                b3.setVisible(false);
                                b4.setVisible(false);
                                    
                         }
                      if(ae.getSource()==b2){
                            f.setVisible(false);
                            new Login();
                                    
                         }
    
    
    
    }
    
    
}
