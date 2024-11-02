import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class GUI() implements ActionListener
{
    JTextField tday,tmonth,tyear;
    GUI()
    {
        JFrame frame=new JFrame("LUNAR PHASE");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel ld,lm,ly;
        ld=new JLabel("Day");
        lm=new JLabel("Month");
        ly=new JLabel("Year");
        ld.setBounds(20,30,20,20);
        lm.setBounds(50,30,20,20);
        ly.setBounds(80,30,20,20);
        

    }
}