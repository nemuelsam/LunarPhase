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
        ld.setBounds(20,30,40,30);
        lm.setBounds(70,30,40,30);
        ly.setBounds(120,30,40,30);

        tday=new JTextField();
        tmonth=new JTextField();
        tyear=new JTextField();
        tday.setBounds(20,60,40,30);
        tmonth.setBounds(70,60,40,30);
        tyear.setBounds(120,60,40,30);

        JButton button=new JButton();
        button.setBounds(180,60,25,25);
        button.addActionListener(this);

        frame.add(ld);frame.add(lm);frame.add(ly);
        frame.add(tday);frame.add(tmonth);frame.add(tyear);
        frame.add(button);
        
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        LunarIllumination();
    }
    void LunarIllumination()
    {
        String sday=tday.getText();
        String smonth=tmonth.getText();
        String syear=tyear.getText();
    }
}
class LunarPhase
{
    public static void main(String args[])
    {
        new GUI();
    }
}