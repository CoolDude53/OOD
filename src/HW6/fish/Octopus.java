package HW6.fish;

import javax.swing.*;

public class Octopus extends Fish
{
    private ImageIcon leftimage, rightimage;

    public Octopus()
    {
        super(oscillatingMovement);
        leftimage = new ImageIcon("./images/Loctopus.gif");
        rightimage = new ImageIcon("./images/Roctopus.gif");
    }

    protected ImageIcon leftImage()
    {
        return leftimage;
    }

    protected ImageIcon rightImage()
    {
        return rightimage;
    }
}

