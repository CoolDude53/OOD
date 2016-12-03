package HW9.mvc;

import HW9.fish.Fish;
import HW9.fish.factory.FishFactory;

import java.awt.*;
import java.util.Collection;

public class FishtankController implements FTModelObserver, FTViewObserver
{
    private FishtankModel model;
    private View view;

    public FishtankController(FishtankModel model, View view)
    {
        this.model = model;
        this.view = view;

        model.addObserver(this);
        view.addObserver(this);
    }

    @Override
    public void newFish(String fishtype)
    {
        FishFactory ff = FishFactory.getFactory(fishtype);
        Fish f = ff.create();
        model.addFish(f);
        view.addFish(f);
    }

    @Override
    public void startStopPressed()
    {
        isSuspended(!model.isSuspended());
    }

    @Override
    public void setSize(Dimension d)
    {
        model.setSize(d);
    }

    @Override
    public void update(Collection<Fish> fishes)
    {
        view.update(fishes);
    }

    @Override
    public void isSuspended(boolean b)
    {
        model.setSuspended(b);
    }

    public FishtankModel getModel()
    {
        return model;
    }

    public View getView()
    {
        return view;
    }
}