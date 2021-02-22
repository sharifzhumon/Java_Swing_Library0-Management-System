package librarymanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class New_book extends JFrame implements ActionListener{
    JPanel p;
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1,tf2,tf3,tf4;
    JComboBox cb;
    JButton b1,b2;
    Menubar mb;
    String session,flag,q,book_id,book_name,book_genre,avaialable_books,author_name;
    boolean b;
    
    public New_book(String session, boolean b){
    
        super("Add New Book");
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
        p.setBounds(30, 30, 325, 530);
        p.setBackground(Color.green);
        p.setBorder(BorderFactory.createLineBorder(Color.blue));
        p.setLayout(null);
        add(p);
        
        //book id label
        l1= new JLabel("Book ID");
        l1.setBounds(90,20,200,35);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setForeground(Color.white);
        p.add(l1);
        
        //book id textfield
        tf1= new JTextField();
        tf1.setBounds(90,60,150,25);
        p.add(tf1);
        
        
         //book name label
        l2= new JLabel("Book Name");
        l2.setBounds(90,100,200,35);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l2.setForeground(Color.white);
        p.add(l2);
        
        //book name textfield
        tf2= new JTextField();
        tf2.setBounds(90,140,150,25);
        p.add(tf2);
        
         //author name label
        l3= new JLabel("Author Name");
        l3.setBounds(90,180,200,35);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setForeground(Color.white);
        p.add(l3);
        
        //author name textfield
        tf3= new JTextField();
        tf3.setBounds(90,220,150,25);
        p.add(tf3);
        
        //Book genre label
        l4= new JLabel("Book Genre");
        l4.setBounds(90,260,200,35);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l4.setForeground(Color.white);
        p.add(l4);
        
        //department choose combobox
        String [] combo={"CSE","Pharmacy","Architecture","Civil","EEE","English","Law"};
        cb= new JComboBox(combo);
        cb.setBounds(90,300,150,25);
        p.add(cb);
        
        //Available books label
        l5= new JLabel("Available Books");
        l5.setBounds(90,340,200,35);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l5.setForeground(Color.white);
        p.add(l5);
        
        //Available books textfield
        tf4= new JTextField();
        tf4.setBounds(90,380,150,25);
        p.add(tf4);
        
        //Add student(submit) Button
        b1= new JButton("Add Book");
        b1.setBounds(90,430,150,25);
        b1.setBackground(Color.green);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        p.add(b1);
        
         //back Button
        b2= new JButton("Back");
        b2.setBounds(90,470,150,25);
        b2.setBackground(Color.green);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        p.add(b2);
        
        
        //frame setting
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
        new Dashboard(session,b);
        
        }
        if(ae.getSource()==b1){
        
            book_id=tf1.getText();
            book_name=tf2.getText();
            author_name=tf3.getText();
            book_genre= String.valueOf(cb.getSelectedItem());
            avaialable_books= tf4.getText();
            
            if((book_id.equals(""))||(book_name.equals(""))||(author_name.equals(""))||(avaialable_books.equals(""))){
                JOptionPane.showMessageDialog(null,"please fill out all the fields");
            }else{
            
            try{
                Conn c= new Conn();
                q="insert into books values('"+book_id+"','"+book_name+"','"+author_name+"','"+book_genre+"','"+avaialable_books+"')";
                flag="select book_id from books where book_id="+book_id+"";
                
                ResultSet rss= c.s.executeQuery(flag);
                if(rss.next()){
                   JOptionPane.showMessageDialog(null,"This books is already registered");
                
                } else{
                
                 c.s.executeUpdate(q);
                 JOptionPane.showMessageDialog(null,"Book Registered successfully");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                cb.setSelectedIndex(0);
                }
                
                
            
            
            }catch(Exception e){
            
                e.printStackTrace();
            }
        
        }
        }   
    
    
    
    }
    
}
