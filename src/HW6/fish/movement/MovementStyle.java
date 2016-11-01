package HW6.fish.movement;

public abstract class MovementStyle
{
    private int xspeed;
    private int yspeed;
    private int xDirectionChangeFreq;  // the fish changes horizontal direction 0.5% of the time
    private int yDirectionChangeFreq; // the fish changes vertical direction 1% of the time

    public MovementStyle(int xspeed, int yspeed, int xDirectionChangeFreq, int yDirectionChangeFreq)
    {
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.xDirectionChangeFreq = xDirectionChangeFreq;
        this.yDirectionChangeFreq = yDirectionChangeFreq;
    }

    public int moveX(int pos, int fishwidth, int tankwidth)
    {
        if (changesDirection(xDirectionChangeFreq) ||
                (pos + xspeed + fishwidth > tankwidth) ||
                (pos + xspeed < 0))
        {
            xspeed = -xspeed;
            return pos;
        }
        else
            return pos + xspeed;
    }

    public int moveY(int pos, int fishheight, int tankheight)
    {
        if (changesDirection(yDirectionChangeFreq) ||
                (pos + yspeed + fishheight > tankheight) ||
                (pos + yspeed < 0))
        {
            yspeed = -yspeed;
            return pos;
        }
        else
            return pos + yspeed;
    }

    public boolean movesRight()
    {
        return xspeed >= 0;
    }

    private boolean changesDirection(int frequency)
    {
        return Math.random() * 1000 < frequency;
    }
}
