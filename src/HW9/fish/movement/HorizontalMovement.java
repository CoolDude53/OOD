package HW9.fish.movement;

public class HorizontalMovement implements MovementStyle
{
    private int xspeed;

    public HorizontalMovement(int x)
    {
        xspeed = x;
    }

    public int xspeed()
    {
        return xspeed;
    }

    public int yspeed()
    {
        return 0;
    }

    ;

    public int xDirectionChangeFreq()
    {
        return 1;
    }

    public int yDirectionChangeFreq()
    {
        return 0;
    }

    public void changeXdirection()
    {
        xspeed = -xspeed;
    }

    public void changeYdirection()
    {
    }
}