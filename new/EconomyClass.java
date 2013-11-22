package logic;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EconomyClass extends Room {

	@Override
	public JLabel getAsLabel() {
		// TODO Auto-generated method stub
		return new JLabel ("Economy room: " + roomNumber);
	}

	@Override
	public JButton getAsButton() {
		// TODO Auto-generated method stub
		return new JButton (roomNumber);
	}
	
	
	
}
