package librarymanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class Book_Stats extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5;
    JButton b4;
    JLabel jl1;
    JTextField tf1;
    Menubar Mb;
    String session, issue[][], columns[];
    boolean b;
    CardLayout card, card1;
    Border thatBorder3, thatBorder4, thatBorder, thatBorder1, thatBorder2;
    String book_id,name,author,genre,availability,issue_no, student_id,issue_date,last_day_to_return;  

    public Book_Stats() {

        super("Book Details");
        JFrame.setDefaultLookAndFeelDecorated(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Mb = new Menubar(session);
        Mb.i1.addActionListener(this);
        setJMenuBar(Mb.mb);

        thatBorder1 = new LineBorder(new Color(10, 120, 10));
        thatBorder2 = new TitledBorder(thatBorder1);

        Font font = new Font("Serif", Font.ITALIC, 12);
        thatBorder = new TitledBorder(thatBorder2, "BOOK RECORD SEARCH", TitledBorder.CENTER,
                TitledBorder.TOP, font, Color.RED);
        thatBorder3 = new TitledBorder(thatBorder2, "ALL BOOKS", TitledBorder.CENTER,
                TitledBorder.TOP, font, Color.RED);
        thatBorder4 = new TitledBorder(thatBorder2, "BOOk RECORDS", TitledBorder.CENTER,
                TitledBorder.TOP, font, Color.RED);

        p1 = new JPanel();

        p1.setLayout(new BorderLayout(12, 52));

        add(p1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 1, 0, 10));

        p1.add(p2, BorderLayout.CENTER);

        p5 = new JPanel();
        p5.setBorder(thatBorder3);

        card1 = new CardLayout(15, 15);
        p5.setLayout(card1);

        p2.add(p5);

        try {
            Conn c = new Conn();

            //Issue
            String ss = "select * from books order by book_genre";
            String columns1[] = {"Book ID", "Book Name", "Author","Book Genre","Available Books"};
            DefaultTableModel tableModel1 = new DefaultTableModel(columns1, 0);
            ResultSet rss = c.s.executeQuery(ss);

            while (rss.next()) {
                String book_id = rss.getString("book_id");
                String name = rss.getString("book_name");
                String author = rss.getString("author");
                String genre = rss.getString("book_genre");
                String availibility = rss.getString("available_books");

                // create a single array of one row's worth of data
                String[] datas1 = {book_id, name, author,genre,availibility};

                // and add this row of data into the table model
                tableModel1.addRow(datas1);
            }
            JTable jt1 = new JTable(tableModel1);
            jt1.setAutoCreateRowSorter(true);
            JScrollPane jsp1 = new JScrollPane(jt1);
            jsp1.setPreferredSize(new Dimension(400, 80));

            p5.add(jsp1);
//            p2.add(Box.createRigidArea(new Dimension(0, 10)));
//            p1.add(p2, BorderLayout.CENTER);

        } catch (Exception e) {
            e.printStackTrace();

        }

        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));
        p3.setBorder(thatBorder);

        jl1 = new JLabel("Book ID: ");
        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(120, 25));

        b4 = new JButton("search");
        b4.addActionListener(this);
        p3.add(jl1);
        p3.add(tf1);
        p3.add(b4);

        p2.add(p3);

        card = new CardLayout(15, 15);
        p4 = new JPanel();
        p4.setLayout(card);
        p2.add(p4);

        setVisible(true);
        setLocation(100, 100);
        setPreferredSize(new Dimension(800, 600));
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Mb.i1) {

            int input = JOptionPane.showConfirmDialog(null,
                    "Are you really want to Logout?", "Logout!", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
                setVisible(false);
                new Login();
            }
        }

        if (ae.getSource() == b4) {
            String id;
            id = tf1.getText();

//            JButton jb = new JButton("Hack Me");
//            p2.add(jb);
            try {
                Conn c = new Conn();
                int ace=0;
                //Issue
                String ss = "SELECT b.book_id,b.book_name,b.author,b.book_genre,b.available_books, i.issue_no,i.student_id,i.issue_date,i. last_day_of_return from books b inner join issue i on b.book_id= i.book_id where b.book_id="+id+" and i.book_id="+id+"";
                String columns1[] = {"Book ID", "Name", "Author","Genre","Available Books", "Issue No.","Student ID", "Issue Date", "Last day to Return"};
                DefaultTableModel tableModel1 = new DefaultTableModel(columns1, 0);
                ResultSet rss = c.s.executeQuery(ss);

                while (rss.next()) {
                    if(ace==0){
                     book_id = rss.getString("book_id");
                     name = rss.getString("book_name");
                     author = rss.getString("author");
                     genre = rss.getString("book_genre");
                     availability = rss.getString("available_books");                   
                                      
                    issue_no = rss.getString("issue_no");
                    student_id = rss.getString("student_id");
                    issue_date = rss.getString("issue_date");
                    last_day_to_return = rss.getString("last_day_of_return");
                    ace=1;
                    } else{
                     book_id = null;
                     name = null;
                     author = null;
                     genre = null;
                     availability = null;                   
                                      
                    issue_no = rss.getString("issue_no");
                    student_id = rss.getString("student_id");
                    issue_date = rss.getString("issue_date");
                    last_day_to_return = rss.getString("last_day_of_return");
                    
                    
                    }
                    

                    // create a single array of one row's worth of data
                    String[] datas1 = {book_id, name,author, genre,availability, issue_no, student_id, issue_date, last_day_to_return};

                    // and add this row of data into the table model
                    tableModel1.addRow(datas1);
                }
                JTable jt1 = new JTable(tableModel1);
                jt1.setAutoCreateRowSorter(true);
                JScrollPane jsp1 = new JScrollPane(jt1);
                jsp1.setPreferredSize(new Dimension(400, 80));

                p4.add(jsp1);
                p4.setBorder(thatBorder4);

                card.next(p4);
//            p2.add(Box.createRigidArea(new Dimension(0, 10)));
//            p1.add(p2, BorderLayout.CENTER);

            } catch (Exception e) {
                e.printStackTrace();

            }
            revalidate();
            repaint();

        }

    }

}
