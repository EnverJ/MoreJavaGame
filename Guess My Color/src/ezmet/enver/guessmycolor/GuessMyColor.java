package ezmet.enver.guessmycolor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GuessMyColor extends JFrame {
	private static final long serialVersion = 1L;
	private JPanel samplePanel=new JPanel();
	private JPanel targetPanel=new JPanel();

	public GuessMyColor() {
		initGUI();
		setTitle("Guess My Color");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initGUI() {
		
		JLabel titleLabel = new JLabel();
		Font titleFont = new Font(Font.SERIF, Font.BOLD, 52);
		titleLabel.setFont(titleFont);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setText("Guess My Color");
		add(titleLabel, BorderLayout.PAGE_START);
		
		JPanel centerPanel=new JPanel();
		centerPanel.setBackground(Color.BLUE);
		add(centerPanel,BorderLayout.CENTER);
		
		Dimension size=new Dimension(50,50);
		samplePanel.setBackground(Color.BLACK);
		samplePanel.setPreferredSize(size);
		centerPanel.add(samplePanel);
		targetPanel.setBackground(Color.CYAN);
		targetPanel.setPreferredSize(size);
		centerPanel.add(targetPanel);
		
		JPanel leftPanel=new JPanel();
		leftPanel.setBackground(Color.RED);
		add(leftPanel,BorderLayout.LINE_START);
		
		JPanel rightPanel=new JPanel();
		rightPanel.setBackground(Color.GREEN);
		add(rightPanel,BorderLayout.LINE_END);
		
		JPanel buttonPanel=new JPanel();
		buttonPanel.setBackground(Color.YELLOW);
		add(buttonPanel,BorderLayout.PAGE_END);

	}

	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);

		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GuessMyColor();

			}

		});

	}

}
