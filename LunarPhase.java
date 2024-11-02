import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
class GUI implements ActionListener
{
    JTextField tday,tmonth,tyear;
    JLabel moonpic;
    JLabel info=new JLabel();
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
        ld.setBounds(500,25,100,50);
        lm.setBounds(660,25,100,50);
        ly.setBounds(820,25,100,50);

        tday=new JTextField();
        tmonth=new JTextField();
        tyear=new JTextField();

        tday.setFont(new Font("Arial", Font.PLAIN, 25));
        tmonth.setFont(new Font("Arial", Font.PLAIN, 25));
        tyear.setFont(new Font("Arial", Font.PLAIN, 25));

        tday.setHorizontalAlignment(JTextField.CENTER);
        tmonth.setHorizontalAlignment(JTextField.CENTER);
        tyear.setHorizontalAlignment(JTextField.CENTER);

        tday.setBounds(500,60,100,50);
        tmonth.setBounds(660,60,100,50);
        tyear.setBounds(820,60,100,50);

        moonpic=new JLabel();
        moonpic.setBounds(400,100,736,736);

        ImageIcon icon=new ImageIcon("Moon button.jpg");
        JButton button=new JButton(icon);
        button.setBounds(980,60,50,50);
        button.addActionListener(this);

        info.setBounds(10,100,400,800);

        frame.add(ld);frame.add(lm);frame.add(ly);
        frame.add(tday);frame.add(tmonth);frame.add(tyear);
        frame.add(button);
        frame.add(moonpic);
        frame.add(info);
        
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

        double lunarcycle_td=lunarcycle_d+(lunarcycle_h/24)+(lunarcycle_m/(60*24)+(lunarcycle_s/(60*60*24)));

        double illum=(difdays%lunarcycle_td)/lunarcycle_td;
        double illumpercent=illum*360;
        
        return illumpercent;
    }
    void Moonphase(double cillump)
    {
        if(cillump<10 || cillump>350)
        {
            moonpic.setIcon(null);
            moonpic.setText("<html><font size='5' color=white>OOPS ITS A NEW MOON</font></html>");
            info.setText("<html><font size='3' color=white>Fun Fact:NewMoon is moon which is \"new\",not old.\"Old\" moon is not new moon,but \"Old\" moon does not exist</font></html>");
        }
        else if(cillump>=10 && cillump<90)
        {
            moonpic.setPreferredSize(new Dimension(736,736));
            ImageIcon moon=new ImageIcon("Waxing crescent.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:Waxing crescent is the result when we google \"waxing crescent moon\".</font></html>");
        }
        else if(cillump>=90 && cillump<135)
        {
            moonpic.setPreferredSize(new Dimension(735,1109));
            ImageIcon moon=new ImageIcon("First quarter.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:This phase of the Moon is also known as a Half Moon because only half of the Moon is visible. Because the Earth, Moon, & Sun are at a right angle instead of a straight line, and the Moon and Sun pull in different directions, the First Quarter phase has the smallest effect on the ocean's tides.</font></html>");
        }
        else if(cillump>=135 && cillump<180)
        {
            moonpic.setPreferredSize(new Dimension(600,640));
            ImageIcon moon=new ImageIcon("Waxing Gibbous.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:A waxing gibbous moon is a phase of the moon that occurs when the moon is more than half full but not yet fully illuminated.</font></html>");
        }
        else if(cillump>=180 && cillump<225)
        {
            moonpic.setPreferredSize(new Dimension(735,952));
            ImageIcon moon=new ImageIcon("Full Moon.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:FullMoon is fully moon but not half.HalfMoon can never be full moon.</font></html>");
        }
        else if(cillump>=225 && cillump<270)
        {
            moonpic.setPreferredSize(new Dimension(736,883));
            ImageIcon moon=new ImageIcon("Waning Gibbous.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:A waning gibbous moon can surprise you if you happen to be out late in the evening and you catch it rising eerily, some hours after sunset. It’ll be glowing red like a misshapen full moon when it’s near the horizon.</font></html>");
        }
        else if(cillump>=270 && cillump<315)
        {
            moonpic.setPreferredSize(new Dimension(736,490));
            ImageIcon moon=new ImageIcon("Last Quarter.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:The moon has moved another quarter of the way around Earth, to the third quarter position. The sun's light is now shining on the other half of the visible face of the moon.</font></html>");
        }
        else if(cillump>=315 && cillump<=350)
        {
            moonpic.setPreferredSize(new Dimension(736,791));
            ImageIcon moon=new ImageIcon("Waning Crescent.jpg");
            moonpic.setIcon(moon);
            info.setText("<html><font size='3' color=white>Fun Fact:The moon appears as a crescent shape because we can only see a small sliver of the illuminated half. The term \"waning\" means decreasing, which is why this phase is called a waning crescent</font></html>");
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