package HW9;

import HW9.mvc.FishtankController;
import HW9.mvc.FishtankView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FishFrame extends JFrame implements ActionListener
{
    FishtankController controller;

    public FishFrame(FishtankController controller)
    {
        this.controller = controller;
        setTitle("Fish Tank");
        setSize(650, 400);
        setLocation(20, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(new FishMenuBar(controller));
        getContentPane().add((FishtankView) controller.getView());
        controller.setSize(getSize());

        addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent e)
            {
                // code to execute when the view is resized
                controller.getModel().setSize(getSize());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        controller.update(controller.getModel().getFishes());
        repaint();
    }
}