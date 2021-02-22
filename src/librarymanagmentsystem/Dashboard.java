package librarymanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import static javax.swing.JOptionPane.*;

public class Dashboard implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2,b3,b4,b5,b6,logout;
    
    ImageIcon im1,im11,im2,im22,im3,im33,im4,im44,im5,im55,im6,im66;
    Image ig1,ig2,ig3,ig4,ig5,ig6;
    String s;
    Menubar mb;
    boolean b;

    public Dashboard(String s,boolean b){
        
        
        this.s=s;
        this.b=b;
        f= new JFrame("Dashboard");
        f.getContentPane().setBackground(new Color(56,137,139));
        
        //menubar class
        mb= new Menubar(s);
        mb.i1.addActionListener(this);
        mb.i2.addActionListener(this);
        mb.i3.addActionListener(this);
        f.setJMenuBar(mb.mb);
        
        l1 = new JLabel();
        l1.setBounds(0,0,1000,700);
        
        l2= new JLabel("Welcome To Deashboard "+s+"");
        l2.setBounds(250,5,500,60);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif",Font.BOLD,30));
        l1.add(l2);
        f.add(l1);
        
        JPanel panel = new JPanel();
        panel.setBounds(20,70,940,240);
        panel.setBackground(new Color(58,139,141));
        
        panel.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
//        panel.setBorder(BorderFactory.createTitledBorder("Operation")); 
       
        panel.setLayout(null);
        
        
        //Add student pic
        im1= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/studentAdd.png"));
        ig1= im1.getImage().getScaledInstance(150,160,Image.SCALE_DEFAULT);
        im11= new ImageIcon(ig1);
        
        //new student add
        b1= new JButton("New Student",im11);
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setVerticalTextPosition(JButton.BOTTOM);

        b1.setMargin(new Insets(0, 0, 0, 0)); //(int top, int left, int bottom, int right)
        b1.setLayout(null);
        b1.setBounds(50,25,145,185);
        b1.setBackground(new Color(58,139,150));
        b1.setForeground(Color.white);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
        b1.addActionListener(this);
        panel.add(b1);
        panel.setLayout(null);
        l1.add(panel);
        
        
        //add books
        im2= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/bookAdd.png"));
        ig2= im2.getImage().getScaledInstance(145,160,Image.SCALE_DEFAULT);
        im22= new ImageIcon(ig2);
        
        
        b2= new JButton("New book",im22);
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setVerticalTextPosition(JButton.BOTTOM);
        b2.setMargin(new Insets(0, 0, 0, 0));
        b2.setLayout(null);
        b2.setBounds(750,25,145,185);
        b2.setBackground(new Color(58,139,150));
        b2.setForeground(Color.white);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
        b2.addActionListener(this);
        panel.add(b2);
        
        
         //add Admin or librarian
        im3= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/employeeAdd.png"));
        ig3= im3.getImage().getScaledInstance(145,135,Image.SCALE_DEFAULT);
        im33= new ImageIcon(ig3);
        
        if(b==true){
        b3= new JButton("<html>Add Admin<br/>or Librarian</html>",im33);
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setVerticalTextPosition(JButton.BOTTOM);
        b3.setMargin(new Insets(0, 0, 0, 0));
        b3.setLayout(null);
        b3.setBounds(400,25,145,185);
        b3.setBackground(new Color(58,139,150));
        b3.setForeground(Color.white);
        b3.setFont(new Font("serif",Font.BOLD,18));
        b3.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
        b3.addActionListener(this);
        panel.add(b3);
        }
        
        
        
        //2nd panel
        JPanel panel2 = new JPanel();
        panel2.setBounds(20,350,940,240);
        panel2.setBackground(new Color(58,139,141));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
       
        panel2.setLayout(null);
        
        
        //Add student pic
        im4= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/bookSearch.png"));
        ig4= im4.getImage().getScaledInstance(145,160,Image.SCALE_DEFAULT);
        im44= new ImageIcon(ig4);
        
        //new student add
        b4= new JButton("Statistics",im44);
        b4.setHorizontalTextPosition(JButton.CENTER);
        b4.setVerticalTextPosition(JButton.BOTTOM);
        b4.setMargin(new Insets(0, 0, 0, 0));
        b4.setLayout(null);
        b4.setBounds(50,25,145,185);
        b4.setBackground(new Color(58,139,150));
        b4.setForeground(Color.white);
        b4.setFont(new Font("serif",Font.BOLD,20));
        b4.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
        b4.addActionListener(this);
        panel2.add(b4);
//        panel.setLayout(null);
        l1.add(panel2);
        
        
        //add books
        im5= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/retrieve.png"));
        ig5= im5.getImage().getScaledInstance(145,160,Image.SCALE_DEFAULT);
        im55= new ImageIcon(ig5);
        
        
        b5= new JButton("Book Retrieve",im55);
        b5.setHorizontalTextPosition(JButton.CENTER);
        b5.setVerticalTextPosition(JButton.BOTTOM);
        b5.setMargin(new Insets(0, 0, 0, 0));
        b5.setLayout(null);
        b5.setBounds(750,25,145,185);
        b5.setBackground(new Color(58,139,150));
        b5.setForeground(Color.white);
        b5.setFont(new Font("serif",Font.BOLD,20));
        b5.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
        b5.addActionListener(this);
        panel2.add(b5);
        
        
         //add Admin or librarian
        im6= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/issue.png"));
        ig6= im6.getImage().getScaledInstance(145,160,Image.SCALE_DEFAULT);
        im66= new ImageIcon(ig6);
        
        
        b6= new JButton("Book Issue",im66);
        b6.setHorizontalTextPosition(JButton.CENTER);
        b6.setVerticalTextPosition(JButton.BOTTOM);
        b6.setMargin(new Insets(0, 0, 0, 0));
        b6.setLayout(null);
        b6.setBounds(400,25,145,185);
        b6.setBackground(new Color(58,139,150));
        b6.setForeground(Color.white);
        b6.setFont(new Font("serif",Font.BOLD,20));
        b6.setBorder(BorderFactory.createLineBorder(new Color(31,94,40)));
        b6.addActionListener(this);
        panel2.add(b6);
        
         
        //frame setting
        f.setVisible(true);
        f.setSize(1000,700);
        f.setLocation(100,50);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } // constructor ends here
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==mb.i1){
            
            int input = JOptionPane.showConfirmDialog(null, 
                "Are you really want to Logout?", "Logout!", JOptionPane.YES_NO_OPTION);
            if(input==0){
            f.setVisible(false);
            new Login();
            }
            
        
        }
        
         if(ae.getSource()==mb.i2){
            
            new Student_details();
            
        }
          if(ae.getSource()==mb.i3){
            
            new Book_Stats();
            
        }
         
        if(ae.getSource()==b1){
            f.setVisible(false);
            new New_student(s,b);
        
        }
         if(ae.getSource()==b2){
            f.setVisible(false);
            new New_book(s,b);
        
        }
           if(ae.getSource()==b3){
            f.setVisible(false);
            new New_admin_librarian(s);
        
        }
           if(ae.getSource()==b4){
            f.setVisible(false);
            new Book_details(s,b);
        
        } 
              if(ae.getSource()==b5){
            f.setVisible(false);
            new Book_retrieve(s,true);
        
        }
              if(ae.getSource()==b6){
            f.setVisible(false);
            new Book_Issue(s,b);
        
        }
    
    
    
    }

    
    
}
