package HW9;

import HW9.mvc.FishtankController;

import javax.swing.*;

@SuppressWarnings("serial")
public class FishMenuBar extends JMenuBar
{
    public FishMenuBar(FishtankController fc)
    {  // set up the menu bar
        JMenu animation = new JMenu("Animation");
        add(animation);
        JMenuItem startstop = new JMenuItem("Stop");
        animation.add(startstop);
        startstop.addActionListener(e ->
        {
            String label = startstop.getText();
            fc.isSuspended(!label.equals("Start"));
            String newlabel = label.equals("Start") ? "Stop" : "Start";
            startstop.setText(newlabel);

        });

        JMenu newmenu = new JMenu("New Fish");
        add(newmenu);
        JMenuItem angelfish = new JMenuItem("Angel Fish");
        newmenu.add(angelfish);
        angelfish.addActionListener(e -> fc.newFish(angelfish.getText()));
        JMenuItem meanie = new JMenuItem("Mean Fish");
        newmenu.add(meanie);
        meanie.addActionListener(e -> fc.newFish(meanie.getText()));
        JMenuItem octopus = new JMenuItem("Octopus");
        newmenu.add(octopus);
        octopus.addActionListener(e -> fc.newFish(octopus.getText()));
    }
}

