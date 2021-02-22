package librarymanagmentsystem;

//import for design and action
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class IndexPage implements ActionListener {
    JFrame f;
    JButton b;
    JLabel l1,l2;
    
    IndexPage(){
        
        f= new JFrame("Library Managemnet System"); //creating the frame
       
        //adding image in the frame
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("librarymanagmentsystem/icons/index.jpg"));
        Image i2= i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        //label for image
        l1= new JLabel(i3);
        l1.setBounds(0,0,800,600);
        l1.setLayout(null);
        f.add(l1);
        
        //label for string
        l2= new JLabel("Library Managment System");
        l2.setBounds(207,50,400,50);
        l2.setFont(new Font("serif",Font.BOLD,28));
        l2.setForeground(new Color(255,0,0));
        l1.add(l2);
        
        b= new JButton("Click Here to Continue");
        b.setBounds(292,420,170,30);
        b.setBackground(new Color(50,100,150));
        b.setForeground(Color.black);
        b.addActionListener(this);
        l1.add(b);
         
        //Frame setting
        f.setVisible(true); //visiblity of frame true
        f.setSize(800, 600); //frame size
        f.setLocation(200,100); //frame open location
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource()== b){
            f.setVisible(false);
            new Login();
        } 
    
    }
    
}
