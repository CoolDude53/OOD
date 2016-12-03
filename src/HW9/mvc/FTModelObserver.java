package HW9.mvc;

import HW9.fish.Fish;

import java.util.Collection;

public interface FTModelObserver
{
    void update(Collection<Fish> fishes);

    void isSuspended(boolean b);
}
