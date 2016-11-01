package HW6.fish;

import javax.swing.*;

public class AngelFish extends Fish
{
    private ImageIcon leftimage, rightimage;

    public AngelFish()
    {
        super(upDownMovement);
        leftimage = new ImageIcon("./images/Langelfish.gif");
        rightimage = new ImageIcon("./images/Rangelfish.gif");
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
