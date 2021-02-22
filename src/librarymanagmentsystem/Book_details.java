package librarymanagmentsystem;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Book_details extends JFrame implements ActionListener {

    JPanel p1, p2, p, p3;
    JButton b1;
    JLabel l1, l2, l3, l4;
    Menubar Mb;
    String issue[][], columns[],session;
    boolean b;
    int count, column1;

    public Book_details(String session, boolean b) {

        super("Book Details");
        this.session=session;
        this.b= b;

        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); //frame layout
//        add(Box.createVerticalGlue());

        Mb = new Menubar(session);
        Mb.i1.addActionListener(this);
        Mb.i2.addActionListener(this);
        Mb.i3.addActionListener(this);
        setJMenuBar(Mb.mb);

        p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(204, 255, 255));

        p3 = new JPanel();
        p3.setLayout(new GridLayout());

        b1 = new JButton("Back");
        b1.setBackground(new Color(128, 128, 128));
        b1.setForeground(Color.white);
        b1.setFont(new Font("serif", Font.BOLD, 25));
        b1.addActionListener(this);
        p3.add(b1);

        p.add(p3);
        p.add(Box.createVerticalGlue());
        add(p);

        //back button
        //issue book panel
        p1 = new JPanel();
        p1.add(Box.createHorizontalGlue());
        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        p1.setBackground(new Color(204, 255, 255));
//        p1.setPreferredSize(new Dimension(100, 200));
        p1.setBorder(BorderFactory.createTitledBorder(null, "Issued Books", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman", Font.PLAIN, 18), Color.RED));

//        p1.add(Box.createHorizontalGlue());
        p.add(p1);

//        add(Box.createRigidArea(new Dimension(0, 80))); //filler component for spacing
//        p.add(Box.createVerticalGlue());
        p2 = new JPanel();
        p2.add(Box.createHorizontalGlue());
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
        p2.setBackground(new Color(204, 255, 255));
//        p2.setPreferredSize(new Dimension(100, 200));
        p2.setBorder(BorderFactory.createTitledBorder(null, "Retrieved Books", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman", Font.PLAIN, 18), Color.RED));
//        p2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//        p2.setBorder(TitledBorder.setTitleColor(Color.WHITE));
        try {
            Conn c = new Conn();

            //Issue
            String ss = "select * from issue";
            String columns1[] = {"Isuue No.", "Book ID", "Student ID", "Issue Date", "Last Day To Return"};
            DefaultTableModel tableModel1 = new DefaultTableModel(columns1, 0);
            ResultSet rss = c.s.executeQuery(ss);

            while (rss.next()) {
                String issue_no1 = rss.getString("issue_no");
                String book_id1 = rss.getString("book_id");
                String student_id1 = rss.getString("student_id");
                String issue_date1 = rss.getString("issue_date");
                String last_day_of_return1 = rss.getString("last_day_of_return");

                // create a single array of one row's worth of data
                String[] datas1 = {issue_no1, book_id1, student_id1, issue_date1, last_day_of_return1};

                // and add this row of data into the table model
                tableModel1.addRow(datas1);
            }
            JTable jt1 = new JTable(tableModel1);
            JScrollPane jsp1 = new JScrollPane(jt1);
            jsp1.setPreferredSize(new Dimension(500, 80));
            p1.add(jsp1);
            p.add(p1);
            p1.add(Box.createHorizontalGlue());
            p.add(Box.createVerticalGlue());

            //Retrieve
            String s = "select * from retrieve";
            String columns[] = {"Retrieve No.", "Issue No.", "Book ID", "Student ID", "Issue Date", "Last Day To Return", "Retrieve Date"};
            DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            ResultSet rs = c.s.executeQuery(s);

            while (rs.next()) {
                String retrieve_no = rs.getString("retrieve_no");
                String issue_no = rs.getString("issue_no");
                String book_id = rs.getString("book_id");
                String student_id = rs.getString("student_id");
                String issue_date = rs.getString("issue_date");
                String last_day_of_return = rs.getString("last_day_of_return");
                String retrieve_date = rs.getString("retrieve_day");

                // create a single array of one row's worth of data
                String[] datas = {retrieve_no, issue_no, book_id, student_id, issue_date, last_day_of_return, retrieve_date};

                // and add this row of data into the table model
                tableModel.addRow(datas);
            }
            JTable jt = new JTable(tableModel);
            JScrollPane jsp = new JScrollPane(jt);
            jsp.setPreferredSize(new Dimension(500, 80));
            p2.add(jsp);
            p.add(p2);
            p2.add(Box.createHorizontalGlue());
// p2.add(Box.createRigidArea(new Dimension(100, 0)));
            p.add(Box.createVerticalGlue());
//            p.add(Box.createRigidArea(new Dimension(0, 50)));

        } catch (Exception e) {
            e.printStackTrace();

        }

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
           if(ae.getSource()==Mb.i2){
            
            new Student_details();
            
        }
             if(ae.getSource()==Mb.i3){
            
            new Book_Stats();
            
        }
           

        if (ae.getSource() == b1) {
            setVisible(false);
            new Dashboard(session, b);

        }
    }

}
