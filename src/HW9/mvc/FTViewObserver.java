package HW9.mvc;

import java.awt.*;

public interface FTViewObserver
{
    void newFish(String ftype);

    void startStopPressed();

    void setSize(Dimension d);
}
