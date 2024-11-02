import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class GUI implements ActionListener
{
    JTextField tday,tmonth,tyear;
    public GUI()
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

        tday=new JTextField();
        tmonth=new JTextField();
        tyear=new JTextField();
        tday.setBounds(20,60,20,20);
        tmonth.setBounds(50,60,20,20);
        tyear.setBounds(80,60,20,20);

        JButton button=new JButton();
        button.setBounds(120,60,20,20);
        button.addActionListener(this);

        frame.add(ld);frame.add(lm);frame.add(ly);
        frame.add(tday);frame.add(tmonth);frame.add(tyear);
        frame.add(button);
        
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        System.out.println("Clicked");
    }
}
class LunarPhase
{
    public static void main(String args[])
    {
        new GUI();
    }
}