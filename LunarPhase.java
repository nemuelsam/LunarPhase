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

        ImageIcon bgIcon=new ImageIcon ("sky.jpg");
        JLabel bgLabel= new JLabel(bgIcon);
        bgLabel.setBounds(0,0,500,500);


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

        ImageIcon icon=new ImageIcon("Moon button.jpg");
        JButton button=new JButton(icon);
        button.setBounds(180,60,25,25);
        button.addActionListener(this);
        
        frame.add(bgLabel);
        frame.add(ld);frame.add(lm);frame.add(ly);
        frame.add(tday);frame.add(tmonth);frame.add(tyear);
        frame.add(button);
        
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        double illump=LunarIllumination();
        System.out.println(illump);
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
}
class LunarPhase
{
    public static void main(String args[])
    {
        new GUI();
    }
}