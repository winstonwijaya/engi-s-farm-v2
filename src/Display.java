import java.util.*;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engisjava.src.renderable.Renderable;
import engisjava.src.renderable.cell.Cell;
import engisjava.src.renderable.cell.facility.Facility;
import engisjava.src.renderable.cell.facility.Mixer;
import engisjava.src.renderable.cell.facility.Truck;
import engisjava.src.renderable.cell.facility.Well;
import engisjava.src.farmanimal.FarmAnimal;
import engisjava.src.farmanimal.Chicken;
import engisjava.src.farmanimal.Cow;
import engisjava.src.farmanimal.Duck;
import engisjava.src.farmanimal.Goat;
import engisjava.src.farmanimal.Horse;
import engisjava.src.farmanimal.Pig;
import engisjava.src.renderable.cell.land.Land;
import engisjava.src.renderable.cell.land.Barn;
import engisjava.src.renderable.cell.land.Coop;
import engisjava.src.renderable.cell.land.Grassland;
import engisjava.Player;
import engisjava.Items;

class Display extends JFrame implements ActionListener{
	

	// constructor for ButtonFrame
	Display(String title) {
		super(title);                     // invoke the JFrame constructor
		//setLayout(new FlowLayout());      // set the layout manager
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Left")) {
            //pl.setX(pl.getX() + 1);
            System.out.println("Left");
        }
        else if (command.equals("Right")) {
            //pl.setX(pl.getX() - 1);
            System.out.println("Right");
		}
    }

}
