package ezmet.enver.framed;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LightButton extends JButton {
	private static final long serialVersionUID = 1L;
	private final int MAXSIZE = 50;
	private int row = 0;
	private int col = 0;

	public LightButton(int row, int col) {
		this.row = row;
		this.col = col;
		setBackground(Color.black);
		Dimension size = new Dimension(MAXSIZE, MAXSIZE);
		setPreferredSize(size);

	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void turnOn() {
		setBackground(Color.red);
	}

	public void turnOff() {
		setBackground(Color.black);
	}

	public boolean isLit() {
		Color color = getBackground();
		boolean isLit = color.equals(Color.red);
		return isLit;
	}

	public void toggle() {
		if (isLit()) {
			turnOff();

		} else {
			turnOn();
		}
	}
}
