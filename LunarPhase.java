import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
class GUI implements ActionListener
{
    JTextField tday,tmonth,tyear;
    JLabel moonpic;
    
    public GUI()
    {
        JFrame frame=new JFrame("LUNAR PHASE");
        frame.setSize(1920,1280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.BLACK);

        JLabel ld,lm,ly;
        ld=new JLabel("<html><font size='5' color=white>Day</font></html>");
        lm=new JLabel("<html><font size='5' color=white>Month</font></html>");
        ly=new JLabel("<html><font size='5' color=white>Year</font></html>");
        ld.setBounds(800,25,50,50);
        lm.setBounds(860,25,55,50);
        ly.setBounds(920,25,50,50);

        tday=new JTextField();
        tmonth=new JTextField();
        tyear=new JTextField();
        tday.setBounds(800,60,50,50);
        tmonth.setBounds(865,60,50,50);
        tyear.setBounds(925,60,50,50);

        moonpic=new JLabel();
        moonpic.setBounds(800,200,300,200);

        ImageIcon icon=new ImageIcon("Moon button.jpg");
        JButton button=new JButton(icon);
        button.setBounds(980,60,50,50);
        button.addActionListener(this);
        
        frame.add(ld);frame.add(lm);frame.add(ly);
        frame.add(tday);frame.add(tmonth);frame.add(tyear);
        frame.add(button);
        
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        double illump=LunarIllumination();
        Moonphase(illump);
    }
    double LunarIllumination()
    {
        String sday=tday.getText();
        String smonth=tmonth.getText();
        String syear=tyear.getText();
        Calendar cdate=Calendar.getInstance();
        cdate.set(Integer.parseInt(syear),Integer.parseInt(smonth)-1,Integer.parseInt(sday));
        
        Calendar rdate=Calendar.getInstance();
        if(cdate.get(Calendar.YEAR)>=2000 && cdate.get(Calendar.YEAR)<=2999)
        {
            rdate.set(2000,0,6);
            rdate.set(Calendar.HOUR,18);
            rdate.set(Calendar.MINUTE,14);
        }
        else if(cdate.get(Calendar.YEAR)>=1900 && cdate.get(Calendar.YEAR)<=1999)
        {
            rdate.set(1901,0,20);
            rdate.set(Calendar.HOUR,14);
            rdate.set(Calendar.MINUTE,36);
        }
        else if(cdate.get(Calendar.YEAR)>=3000 && cdate.get(Calendar.YEAR)<=3999)
        {
            rdate.set(3000,0,27);
            rdate.set(Calendar.HOUR,18);
            rdate.set(Calendar.MINUTE,14);
        }
        else if(cdate.get(Calendar.YEAR)>=1800 && cdate.get(Calendar.YEAR)<=1899)
        {
            rdate.set(1801,0,14);
            rdate.set(Calendar.HOUR,16);
            rdate.set(Calendar.MINUTE,34);
        }
        long refmilli=rdate.getTimeInMillis();
        long chkmilli=cdate.getTimeInMillis();
        long difmilli=chkmilli-refmilli;
        double difdays=(double)difmilli/(double)(1000*60*60*24);

        double lunarcycle_d=29;
        double lunarcycle_h=12;
        double lunarcycle_m=44;
        double lunarcycle_s=2;


        double illum=(difdays%lunarcycle_d)/lunarcycle_d;
        double illumpercent=illum*360;

        return illumpercent;
    }
    void Moonphase(double illump)
    {

        if(illump<1 || illump>359)
        {
            moonpic.setText("<html><font size='5' color=white>OOPS ITS A NEW MOON</font></html>");
        }
        else if(illump<90)
        {
            ImageIcon moon=new ImageIcon("Waxing Crescent.jpeg");
            moonpic.setIcon(moon);
        }
        else if(illump<135)
        {
            ImageIcon moon=new ImageIcon("First Quarter.jpeg");
            moonpic.setIcon(moon);
        }
        else if(illump<180)
        {
            ImageIcon moon=new ImageIcon("Waxing Gibbous.jpeg");
            moonpic.setIcon(moon);
        }
        else if(illump<225)
        {
            ImageIcon moon=new ImageIcon("Full moon.jpeg");
            moonpic.setIcon(moon);
        }
        else if(illump<270)
        {
            ImageIcon moon=new ImageIcon("Waning gibbous.jpeg");
            moonpic.setIcon(moon);
        }
        else if(illump<315)
        {
            ImageIcon moon=new ImageIcon("Last quarter.jpeg");
            moonpic.setIcon(moon);
        }
        else
        {
            ImageIcon moon=new ImageIcon("Waning cresent.jpeg");
            moonpic.setIcon(moon);
        }
    }
}
class LunarPhase
{
    public static void main(String args[])
    {
        new GUI();
    }
}