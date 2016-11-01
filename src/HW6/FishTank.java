package HW6;

import javax.swing.*;

public class FishTank
{
    public static void main(String[] args)
    {
        FishFrame frame = new FishFrame();
        frame.setVisible(true);
        Timer t = new Timer(100, frame);
        t.start();  //do the animation forever
    }
}
