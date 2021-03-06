package ezmet.enver.guessmycolor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import ezmet.enver.mycomponents.TitleLabel;

public class GuessMyColor extends JFrame {
	private static final long serialVersion = 1L;
	private JPanel samplePanel = new JPanel();
	private JPanel targetPanel = new JPanel();

	private int targetRed = 0;
	private int targetGreen = 0;
	private int targetBlue = 0;

	private int red = 0;
	private int green = 0;
	private int blue = 0;

	public GuessMyColor() {
		initGUI();
		setTitle("Guess My Color");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		generateTargetColor();
	}

	private void updateColorSample() {
		Color color = new Color(red, green, blue);
		samplePanel.setBackground(color);
		if(red==targetRed&&green==targetGreen&&blue==targetBlue){
			String message="Congratlation!!! colors matched. Red= "+targetRed+", Green= "+targetGreen+", Blue= "+targetBlue;
			JOptionPane.showMessageDialog(this, message);
			
		}
	}

	private void increaseRed() {
		if (red <= 240) {
			red += 15;
			updateColorSample();
		}
	}

	private void decreaseRed() {
		if (red >= 15) {
			red -= 15;
			updateColorSample();
		}
	}

	private void increaseGreen() {
		if (green <= 240) {
			green += 15;
			updateColorSample();
		}
	}

	private void decreaseGreen() {
		if (green >= 15) {
			green -= 15;
			updateColorSample();
		}
	}

	private void increaseBlue() {
		if (blue < 240) {
			blue += 15;
			updateColorSample();
		}
	}

	private void decreaseBlue() {
		if (blue >= 15) {
			blue -= 15;
			updateColorSample();
		}
	}

	private void initGUI() {

		TitleLabel titleLabel=new TitleLabel("Guess My Color");
		add(titleLabel);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.BLUE);
		add(centerPanel, BorderLayout.CENTER);

		Dimension size = new Dimension(50, 50);
		samplePanel.setBackground(Color.BLACK);
		samplePanel.setPreferredSize(size);
		centerPanel.add(samplePanel);
		targetPanel.setBackground(Color.CYAN);
		targetPanel.setPreferredSize(size);
		centerPanel.add(targetPanel);

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.RED);
		add(leftPanel, BorderLayout.LINE_START);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.GREEN);
		add(rightPanel, BorderLayout.LINE_END);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.YELLOW);
		add(buttonPanel, BorderLayout.PAGE_END);

		Font font = new Font(Font.DIALOG, Font.BOLD, 18);

		JButton moreRedButton = new JButton("+");
		moreRedButton.setBackground(Color.RED);
		buttonPanel.add(moreRedButton);
		moreRedButton.setFont(font);
		moreRedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				increaseRed();

			}
		});
		buttonPanel.add(moreRedButton);

		JButton lessRedButton = new JButton("-");
		lessRedButton.setBackground(Color.RED);
		buttonPanel.add(lessRedButton);
		lessRedButton.setFont(font);
		lessRedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decreaseRed();

			}
		});

		JButton moreGreenButton = new JButton("+");
		moreGreenButton.setBackground(Color.GREEN);
		buttonPanel.add(moreGreenButton);
		moreGreenButton.setFont(font);
		moreGreenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				increaseGreen();

			}
		});

		JButton lessGreenButton = new JButton("-");
		lessGreenButton.setBackground(Color.GREEN);
		buttonPanel.add(lessGreenButton);
		lessGreenButton.setFont(font);
		lessGreenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decreaseGreen();

			}
		});

		JButton moreBlueButton = new JButton("+");
		moreBlueButton.setBackground(Color.BLUE);
		buttonPanel.add(moreBlueButton);
		moreBlueButton.setFont(font);
		moreBlueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				increaseBlue();

			}
		});

		JButton lessBlueButton = new JButton("-");
		lessBlueButton.setBackground(Color.BLUE);
		buttonPanel.add(lessBlueButton);
		lessBlueButton.setFont(font);
		lessBlueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decreaseBlue();

			}
		});

	}

	private void generateTargetColor() {
		Random rand = new Random();
		targetRed = rand.nextInt(18) * 15;
		targetGreen = rand.nextInt(18) * 15;
		targetBlue = rand.nextInt(18) * 15;
		Color targetColor = new Color(targetRed, targetGreen, targetBlue); // red,
																			// green,
																			// blue
		targetPanel.setBackground(targetColor);
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
