package librarymanagmentsystem;

import static com.mysql.cj.util.StringUtils.*; //used for isNullorEmpty methods
import java.lang.String.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;

public class Book_retrieve extends JFrame implements ActionListener {

    JPanel p;
    JLabel l1, l2, l3, l4;
    JTextField tf1, tf2, tf3, tf4;
    JButton b1, b2;
    LocalDate today;
    Menubar mb;
    String session, current_date, book_id, student_id, q1, q2, q3, book_name;
    boolean b;
    int check, flag, limit;

    public Book_retrieve(String session, boolean b) {

        super("Book Retrieve");
        this.session = session;
        this.b = b;
        //date measuring
        today = LocalDate.now(); //date is on date type format

//        System.out.println(today.getClass().getName()); //check object type
        current_date = String.valueOf(today); //calculate todays date by converting to string format

//        System.out.println(current_date.getClass().getName());//check object type
        //menubar class
        mb = new Menubar(session);
        mb.i1.addActionListener(this);
        mb.i2.addActionListener(this);
        mb.i3.addActionListener(this);
        setJMenuBar(mb.mb);

        //panel to hold everything
        p = new JPanel();
        p.setBounds(30, 30, 320, 380);
        p.setBackground(Color.green);
        p.setBorder(BorderFactory.createLineBorder(Color.yellow));
        p.setLayout(null);
        add(p);

        //book id label
        l1 = new JLabel("Book ID");
        l1.setBounds(90, 20, 200, 35);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        l1.setForeground(Color.white);
        p.add(l1);

        //book id textfield
        tf1 = new JTextField();
        tf1.setBounds(90, 60, 150, 25);
        p.add(tf1);

        //Student ID label
        l2 = new JLabel("Student ID");
        l2.setBounds(90, 100, 200, 35);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        l2.setForeground(Color.white);
        p.add(l2);

        //Student ID textfield
        tf2 = new JTextField();
        tf2.setBounds(90, 140, 150, 25);
        p.add(tf2);

        //retrieve  date label
        l3 = new JLabel("Retrieve date");
        l3.setBounds(90, 180, 200, 35);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        l3.setForeground(Color.white);
        p.add(l3);

        //retrieve date textfield
        tf3 = new JTextField();
        tf3.setBounds(90, 220, 150, 25);
        tf3.setText(current_date);
        p.add(tf3);

        //retrieve book(submit) Button
        b1 = new JButton("Retrieve Book");
        b1.setBounds(90, 270, 150, 25);
        b1.setBackground(Color.green);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        p.add(b1);

        //back Button
        b2 = new JButton("Back");
        b2.setBounds(90, 310, 150, 25);
        b2.setBackground(Color.green);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        p.add(b2);

        //frame setting
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
        setLocation(100, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } //constructor ends here

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == mb.i1) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Are you really want to Logout?", "Logout!", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
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

        if (ae.getSource() == b2) {
            setVisible(false);
            new Dashboard(session, b);

        }

        if (ae.getSource() == b1) {
            flag = 0;
            limit = 0;

            book_id = tf1.getText();
            student_id = tf2.getText();
            if ((isNullOrEmpty(book_id)) || (isNullOrEmpty(student_id)) || (book_id.matches("\\W+")) || (student_id.matches("\\W+"))) { //check if fields are empty or not

//            if ((book_id.equals("")) || (student_id.equals(""))) {
                JOptionPane.showMessageDialog(null, "please fill out all the fields");
            } else {
                try {

                    Conn c = new Conn(); // making connection

                    String[] spt = book_id.split("\\W+"); //splitting all the book ids for all non alphanumeric characters               
                    int[] result = new int[spt.length]; //getting results for update in books table column available_books
                    String[] finalresult = new String[spt.length]; // stores new result of string[] apt without empty string
                    String stu = "select student_id from students where student_id=" + student_id + ""; //query to check student validity
                    ResultSet st = c.s.executeQuery(stu);
                    if (st.next()) { ///check if student is registered

                        for (String x : spt) {

                            q2 = "select * from books where book_id=" + x + ""; ///check for available books
                            ResultSet rs = c.s.executeQuery(q2);

                            if (rs.next()) {
                                check = Integer.valueOf(rs.getString("available_books")); //number of books checking
                                book_name = rs.getString("book_name"); //stroes book name

                                finalresult[limit] = x; //stores book id if book available
                                result[limit] = check + 1; //stores avialble books if retrieve so book will be +1
                                limit++; //stores number of books id and available books

                            } else { //if book is not available
                                flag = 1;
                                JOptionPane.showMessageDialog(null, "There is no book registered with this id: " + x + "");
                            }

                        }
                        if (flag == 0) {
                            for (String x : spt) {

                                String t1, t2;
                                t1 = "select book_id from issue where student_id=" + student_id + " and book_id='" + x + "'";
                                ResultSet rsss = c.s.executeQuery(t1);
                                if (!rsss.next()) {

                                    flag = 1;
                                    JOptionPane.showMessageDialog(null, "This book: " + x + " is not issued to student id: " + student_id + " ");

                                }
                            }
                        }
                        if (flag == 0) {
                            limit = 0;
                            for (String z : finalresult) {

                                String issue = "select issue_no,issue_date,last_day_of_return from issue where book_id=" + z + " and student_id=" + student_id + ""; //issue details query
                                ResultSet iss = c.s.executeQuery(issue);

                                if (iss.next()) { //getting isue details
                                    String issue_no = iss.getString("issue_no");
                                    String issue_date = iss.getString("issue_date");
                                    String last_day_of_return = iss.getString("last_day_of_return");

                                    q1 = "insert into retrieve(issue_no,book_id,student_id,issue_date,last_day_of_return,retrieve_day)values(" + issue_no + ",'" + z + "'," + student_id + ",'" + issue_date + "','" + last_day_of_return + "','" + current_date + "')"; //insert into retrieve as retrieve complete
                                    c.s.executeUpdate(q1);
                                    q3 = "update books set available_books=" + result[limit] + " where book_id=" + z + ""; //update in books
                                    c.s.executeUpdate(q3);

                                    String issue_delete = "delete from issue where issue_no=" + issue_no + "";
                                    c.s.executeUpdate(issue_delete);
                                    limit++;

                                }

                            }
                            JOptionPane.showMessageDialog(null, "Book retrieved");
                           tf1.setText("");
                           tf2.setText("");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "There is no student registered with id=" + student_id + "");

                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        }

    }

}
