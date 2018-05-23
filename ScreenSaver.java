// Author: Makhmud Islamov
// Date: 11/7/2017
// Homework assignment: 4
// Objective: to create screen saver program 

import java.awt.*;
import java.applet.*;
import java.awt.Dimension;
import java.awt.Toolkit;

// <applet code = "ScreenSaver" width = 300  height = 400> <param name = "shape1" value = "triangle">
// <param name = "shape2" value = "circle">
// </applet>

public class ScreenSaver extends Applet //declaring class
{
    int n = 3; //declaring global variables
    int x[];
    int y[];
    int cnt = 0;
    Dimension d;
    String str;
//***************************init()*******************************************
    public void init()
    {
        str = getParameter("shape1");
        // or getParameter("shape2"); for circle
        Toolkit tk = Toolkit.getDefaultToolkit(); // getting screensize
        d = tk.getScreenSize();
        setSize(d.width, d.height);
        setBackground(Color.pink);//variables initialization
        setForeground(Color.blue);
        x = new int[n];
        y = new int[n];    
    }
    
    //***************************paint()******************************************
        public void paint (Graphics g)
    {
        for(int i=0; i<n; i++)//fill x,y arrays
        {
            Dimension d = getSize(); // fullscreen
            x[i] = (int)(Math.random()* d.width);
            y[i] = (int)( Math.random()* d.height);
        }
        int a= (int)(255*Math.random());//random foreground color
        int b= (int)(255*Math.random());
        int c= (int)(255*Math.random());
        Color w = new Color(a,b,c);
        g.setColor(w);//predefined applet method calling
        if (str.equals("triangle"))
        {
            g.fillPolygon(x, y, n);//predefined applet method calling
        } else // circle
        {
            int diameter = (int)( Math.random()* 300);
            g.fillOval((int)(Math.random()* d.width), (int)( Math.random()* d.height), diameter, diameter);
        }
        sleep(100);//set time interval between shapes
        cnt += 1;
        
        if(cnt >= 500) // restarting after 500 shapes
        {
            clearScreen();//loop
            cnt =0;
        }
        paint(g);       
    }
    
    //************************* clearScreen()*********************************************
    public void clearScreen() //clearing the screen
    {
        Graphics g = getGraphics(); // made our own g
        g.setColor(getBackground()); // now background and foreground color is the same
        g.fillRect(0, 0, getSize().width, getSize().height); // getting width and height of current applet
        g.setColor(getForeground());
        g.dispose();      
    }
    
   //**********************sleep()************************************************
    public void sleep(long msec)
    {
        try
        {
            Thread.sleep(msec);
        }
        catch(InterruptedException e) {}
    }
    //*********************update()*************************************************
    
    public void update(Graphics g)
    {
        
        paint(g);
    }
 }
