package HW6.fish;

import javax.swing.*;

public class MeanFish extends Fish
{
    private ImageIcon leftimage, rightimage;

    public MeanFish()
    {
        super(horizontalMovement);
        leftimage = new ImageIcon("./images/Lmeaniefish.gif");
        rightimage = new ImageIcon("./images/Rmeaniefish.gif");
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
