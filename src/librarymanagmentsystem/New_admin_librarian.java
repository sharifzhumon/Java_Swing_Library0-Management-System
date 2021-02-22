package librarymanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class New_admin_librarian extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6;
    JPanel p;
    JTextField tf1,tf2,tf3,tf4;
    JPasswordField pf;
    JButton b1,b2;
    JComboBox cb;
    Menubar mb;
    String username,password,employee_id,question,answer,role,q,check;
    String s;
    
    New_admin_librarian(String s){
        
        super("new Admin-Librarian");
        this.s=s;
  
        //menubar class
        mb= new Menubar(s);
        mb.i1.addActionListener(this);
        mb.i2.addActionListener(this);
        mb.i3.addActionListener(this);
        setJMenuBar(mb.mb);
        
        //panel 
        p= new JPanel();
        p.setBounds(40,20,300,520);
        p.setBackground(Color.gray);
        p.setBorder(BorderFactory.createLineBorder(new Color(10,20,30)));
        p.setLayout(null);
        add(p);
        
        //username label
        l1= new JLabel("Your Preffered Username?");
        l1.setBounds(10,10,250,40);
        l1.setFont(new Font("serif",Font.BOLD,18));
        l1.setForeground(Color.black);
        p.add(l1);
        
        //username textfield
        tf1= new JTextField();
        tf1.setBounds(50,50,200,25);
        p.add(tf1);
        
        //password label
        l2= new JLabel("Your Preffered password?");
        l2.setBounds(10,80,250,40);
        l2.setFont(new Font("serif",Font.BOLD,18));
        l2.setForeground(Color.black);
        p.add(l2);
        
        //password textfield
        pf= new JPasswordField();
        pf.setBounds(50,120,200,25);
        p.add(pf);
        
        
        //employee_id label
        l3= new JLabel("Your Employee ID?");
        l3.setBounds(10,150,250,40);
        l3.setFont(new Font("serif",Font.BOLD,18));
        l3.setForeground(Color.black);
        p.add(l3);
        
        //employee_id textfield
        tf2= new JTextField();
        tf2.setBounds(50,190,200,25);
        p.add(tf2);
        
        
        //recovery quest label
        l4= new JLabel("Your Password Recovery Question?");
        l4.setBounds(10,220,280,40);
        l4.setFont(new Font("serif",Font.BOLD,18));
        l4.setForeground(Color.black);
        p.add(l4);
        
        //recovery question textfield
        tf3= new JTextField();
        tf3.setBounds(50,260,200,25);
        p.add(tf3);
        
        //recovery quest answer label
        l5= new JLabel("Your Recovery Question Answer?");
        l5.setBounds(10,290,280,40);
        l5.setFont(new Font("serif",Font.BOLD,18));
        l5.setForeground(Color.black);
        p.add(l5);
        
        //recovery quest answer textfield
        tf4= new JTextField();
        tf4.setBounds(50,330,200,25);
        p.add(tf4);
        
        //role label
        l6= new JLabel("Your Role?");
        l6.setBounds(10,360,280,40);
        l6.setFont(new Font("serif",Font.BOLD,18));
        l6.setForeground(Color.black);
        p.add(l6);
        
        String [] roles= {"librarian","admin"};
        cb= new JComboBox(roles);       
        cb.setBounds(50,400,200,25);
//        cb.setBackground(Color.blue);
        p.add(cb);
        
        //submit button
        b1= new JButton("Submit");
        b1.setBounds(50,440,200,25);
        b1.setBackground(Color.yellow);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        p.add(b1);
        
        
        //back button
        b2= new JButton("Back");
        b2.setBounds(50,480,200,25);
        b2.setBackground(Color.yellow);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        p.add(b2);
        
        
        
        
        
        setSize(400,650);
        setLayout(null);
        setVisible(true);
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
         new Dashboard(s,true);
        }
        
        if(ae.getSource()==b1){
        
            try{
                Conn c= new Conn();
                username= tf1.getText();
                password= pf.getText();
                employee_id=tf2.getText();
                question= tf3.getText();
                answer= tf4.getText();
                role=String.valueOf( cb.getSelectedItem());
                System.out.println("this is yoo: "+username+" "+employee_id);
                
                if(username.equals("")||password.equals("")||employee_id.equals("")||question.equals("")||answer.equals("")){
                JOptionPane.showMessageDialog(null, "Please Fill up All the fields");
                
                } else{
                
                //validation of username and employee id  if same
                check= "select username,employee_id from "+role+"";
                ResultSet rs= c.s.executeQuery(check);
                String test1="",test2="";
                boolean flag1=false;
                boolean flag2=false;
                while(rs.next()){
                    test1= rs.getString("username");
                    test2= rs.getString("employee_id");
                    System.out.println(test1+" "+test2);
                    if(test1.equals(username)){
                        flag1=true;
                    }
                    if(test2.equals(employee_id)){
                        flag2=true;
                    }
                
                }
                if(flag1==true && flag2==true){
                JOptionPane.showMessageDialog(null, "An Account already exist with this ID and Username");
                
                }else if(flag1==true){
                
                JOptionPane.showMessageDialog(null, "Username already exist. Please Try again with new Username");
                }else if(flag2==true){
                    JOptionPane.showMessageDialog(null, "An Account already exist with this ID");
               
                }else{
                
                q="insert into "+role+" values('"+ username +"','"+ password +"','"+ employee_id +"','"+ question +"','"+ answer +"')";
                System.out.println(q); 
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Dashboard(s,true);
                }
            }
            
            }catch(Exception e){
                e.printStackTrace();
            
            }
        
        
        
        
        
        }
    
    }
    
}
