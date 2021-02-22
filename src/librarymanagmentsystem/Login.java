package librarymanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2,b3;
    JComboBox cb;
    JTextField tf;
    JPasswordField pf;
    
    public Login(){
        f= new JFrame("Login");
        f.getContentPane().setBackground(new Color(50,100,150));
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/login.png"));
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        l1= new JLabel();
        l1.setBounds(0,0,400,400);
        l1.setLayout(null);
        f.add(l1);
        
        //Login text
        l2= new JLabel("Login");
        l2.setBounds(150,0,100,50);
        l2.setLayout(null);
        l2.setFont(new Font("serif",Font.BOLD,30));
        l2.setForeground(Color.white);
        l1.add(l2);
        
        //Name field string
        l3= new JLabel("Username:");
        l3.setBounds(30,70,130,30);
        l3.setLayout(null);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setForeground(Color.white);
        l1.add(l3);
        
        //name textfield
        tf= new JTextField();
        tf.setBounds(130,70,120,30);
        l1.add(tf);
        
          //Role field string
        l4= new JLabel("Role:");
        l4.setBounds(30,120,100,30);
        l4.setLayout(null);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l4.setForeground(Color.white);
        l1.add(l4);
        
        //combo box field
        String [] roles= {"librarian","admin"};
        cb= new JComboBox(roles);       
        cb.setBounds(130,120,120,30);
        l1.add(cb);
        
        //Password field string
        l5= new JLabel("Password:");
        l5.setBounds(30,170,120,30);
        l5.setLayout(null);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l5.setForeground(Color.white);
        l1.add(l5);
        
        //password field
        pf= new JPasswordField();
        pf.setBounds(130,170,120,30);
        l1.add(pf);
        
        
        l6= new JLabel(i3);
        l6.setBounds(270,80,100,100);
        l1.add(l6);
        
        //login button
        b1= new JButton("Login");
        b1.setBounds(50,230,65,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l1.add(b1);
        
         //cancel button
        b2= new JButton("Cancel");
        b2.setBounds(150,230,75,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l1.add(b2);
        
        //Forgot password button
        b3= new JButton("Forgot Password?");
        b3.setBounds(50,280,176,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        l1.add(b3);
        
        
        f.setVisible(true);
        f.setSize(400,400);
        f.setLocation(200,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
    } //constructor ends here
    
    @Override
    public void actionPerformed(ActionEvent ae){
            
        if(ae.getSource()==b1){ //if login button pressed
        
        try{
            Conn c= new Conn();
            String user= tf.getText();
            String role=String.valueOf( cb.getSelectedItem());
//            System.out.println(role);
            String password= pf.getText();
            
            String q= "select * from "+role+" where username='"+user+"' and password='"+password+"'"; //query
//            System.out.println(role);
//            System.out.println(q);
            ResultSet rs= c.s.executeQuery(q);
            
            if(rs.next()){ //if resultset value exist
                f.setVisible(false);
//                System.out.println("Sucess");
            if(role.equals("librarian")){
                new Dashboard(user,false);  
            }else if(role.equals("admin")){
            
                new Dashboard(user,true); 
            }
           
                
            } else{
            
                JOptionPane.showMessageDialog(null, "Invalid Login, Please Try Again");
                tf.setText("");
                cb.setSelectedIndex(0);
                pf.setText("");
            
            }
            
            
        }catch(Exception e){
         e.printStackTrace();
        
        }
        }
        
        if(ae.getSource()==b2){
                tf.setText("");
                cb.setSelectedIndex(0);
                pf.setText("");
        
        
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Forgot_Password();
        
        }
    
    
    
    
    }
        
    
}
