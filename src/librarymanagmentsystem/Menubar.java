package librarymanagmentsystem;
import javax.swing.*;
import java.awt.*;

public class Menubar {
    JMenuBar mb;
    JMenu m;
    JMenuItem i1,i2,i3;
    String s;
    public Menubar(String s){
        this.s= s;
        mb= new JMenuBar();
        m= new JMenu("Menu");
        m.setForeground(Color.white);
        
        i1= new JMenuItem("Logout ("+s+")");

        
        i2= new JMenuItem("Student Details");
        i3= new JMenuItem("Book Details");
        m.add(i1);

        m.addSeparator();
        m.add(i2);
        m.addSeparator();
        m.add(i3);

        mb.add(m);
        mb.setBackground(new Color(49,179,110));
    
    
    }
}
