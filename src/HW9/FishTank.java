package HW9;

import HW9.mvc.FishCounterView;
import HW9.mvc.FishtankController;
import HW9.mvc.FishtankModel;
import HW9.mvc.FishtankView;

import javax.swing.*;

public class FishTank
{
    public static void main(String[] args)
    {
        FishtankView view = new FishtankView();
        FishCounterView counterView = new FishCounterView();
        FishtankModel model = new FishtankModel();
        FishtankController controller = new FishtankController(model, view);
        FishtankController controller1 = new FishtankController(model, counterView);

        FishFrame frame = new FishFrame(controller);

        frame.setVisible(true);
        Timer t = new Timer(100, model);
        t.start();  //do the animation forever
    }
}
