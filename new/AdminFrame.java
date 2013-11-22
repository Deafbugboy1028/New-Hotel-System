package gui;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;

import logic.EconomyClass;
import logic.Room;

public class AdminFrame extends JFrame {
	
	private Room r;
	
	public AdminFrame () {
		r = new EconomyClass ();
		add (r.getAsButton());
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String [] args) {
		new AdminFrame ();
		File f = new File ("images/default.jpeg");
		System.out.println (f.exists());
	}
	
}