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
        Calendar cdate=Calendar.getInstance();
        cdate.set(Integer.parseInt(syear),Integer.parseInt(smonth)-1,Integer.parseInt(sday));
        
        Calendar rdate=Calendar.getInstance();
        if(cdate.get(Calendar.YEAR)>=2000 && cdate.get(Calendar.YEAR)<=2999);
        {
            rdate.set(2000,0,6);
        }
        else if(cdate.get(Calendar.YEAR)>=1900 && cdate.get(Calendar.YEAR)<=1999)
        {
            rdate.set(1900,10,6);
        }
        else if(cdate.get(Calendar.YEAR)>=3000 && cdate.get(Calendar.YEAR)<=3999)
        {
            rdate.set(3000,0,27);
        }
        else if(cdate.get(Calendar.YEAR)>=1800 && cdate.get(Calendar.YEAR)<=1899)
        {
            rdate.set(3000,0,27);
        }
        long refmilli=rdate.getTimeInMillis();
        long chkmilli=cdate.getTimeinMillis();
        long difmilli=chkmilli-refmilli;
        long difdays=difmilli/(1000*60*60*24);

        float lunarcycle_d=29;
        float lunarcycle_h=12;
        float lunarcycle_m=44;
        float lunarcycle_s=2;

        float lunarcycle_td=(lunarcycle_d)+(lunarcycle_h/24)+(lunarcycle_m/(60*24))+(lunarcycle_s/(60*60*24));

        int illum=difdays%

    }
}
class LunarPhase
{
    public static void main(String args[])
    {
        new GUI();
    }
}