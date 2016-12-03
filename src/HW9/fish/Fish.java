package HW9.fish;

import HW9.fish.movement.MovementStyle;

import javax.swing.*;
import java.awt.*;

public abstract class Fish
{
    private MovementStyle ms;
    private Point currentpos = new Point(20, 20);

    protected void setMovementStyle(MovementStyle ms)
    {
        this.ms = ms;
    }

    public void move(Dimension tanksize)
    {
        ImageIcon image = getImage();
        int x = moveX(currentpos.x, image.getIconWidth(), tanksize.width);
        int y = moveY(currentpos.y, image.getIconHeight(), tanksize.height);
        currentpos = new Point(x, y);
    }

    public void display(JComponent c, Graphics g)
    {
        ImageIcon img = getImage();
        img.paintIcon(c, g, currentpos.x, currentpos.y);
    }

    private ImageIcon getImage()
    {
        if (movesRight())
            return rightImage();
        else
            return leftImage();
    }

    public int moveX(int pos, int fishwidth, int tankwidth)
    {
        if (changesDirection(ms.xDirectionChangeFreq()) ||
                (pos + ms.xspeed() + fishwidth > tankwidth) ||
                (pos + ms.xspeed() < 0))
        {
            ms.changeXdirection();
            return pos;
        }
        else
            return pos + ms.xspeed();
    }

    public int moveY(int pos, int fishheight, int tankheight)
    {
        if (changesDirection(ms.yDirectionChangeFreq()) ||
                (pos + ms.yspeed() + fishheight > tankheight) ||
                (pos + ms.yspeed() < 0))
        {
            ms.changeYdirection();
            return pos;
        }
        else
            return pos + ms.yspeed();
    }

    public boolean movesRight()
    {
        return ms.xspeed() >= 0;
    }

    private boolean changesDirection(int frequency)
    {
        return Math.random() * 1000 < frequency;
    }

    public abstract ImageIcon rightImage();

    public abstract ImageIcon leftImage();
}
