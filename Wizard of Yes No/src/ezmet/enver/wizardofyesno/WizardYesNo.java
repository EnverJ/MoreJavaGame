package ezmet.enver.wizardofyesno;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WizardYesNo extends JFrame {
	private static final String[] ANSWER={"Yes","No"};
	
	public WizardYesNo(){
		Random rand=new Random();
		int numberOfAnswer=ANSWER.length;
		int pick=rand.nextInt(numberOfAnswer);
		String answer=ANSWER[pick];
		JLabel label=new JLabel();
		label.setText(answer);
		add(label);
		setSize(100,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new WizardYesNo();

	}

}
