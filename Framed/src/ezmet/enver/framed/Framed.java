package ezmet.enver.framed;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import ezmet.enver.mycomponents.TitleLabel;

public class Framed extends JFrame {
	private static final long serialVersionUID=1L;
	private static final int GRIDSIZE=3;
	private LightButton[][] lighButton=new LightButton[GRIDSIZE][GRIDSIZE];
	
	public Framed(){
		initGUI();
		setTitle("Framed");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		newGame();
	
	}
	private void newGame(){
		// turn all Lights on, then turn middle lights off
		for(int row=0;row<GRIDSIZE;row++){
			for(int col=0;col<GRIDSIZE;col++){
				lighButton[row][col].turnOn();
			}
		}
		lighButton[1][1].toggle();
		Random rand=new Random();
		int numberOfTimes=rand.nextInt(10)+10;
		for(int i=0;i<numberOfTimes;i++){
			int row=rand.nextInt(GRIDSIZE);
			int col=rand.nextInt(GRIDSIZE);
			toggleLights(row, col);
			
			
		}
	}
	private void initGUI(){
		TitleLabel titleLabel=new TitleLabel("Framed");
		add(titleLabel,BorderLayout.PAGE_START);
		JPanel centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel,BorderLayout.CENTER);
		for(int row=0;row<GRIDSIZE;row++){
			for(int col=0;col<GRIDSIZE;col++){
				lighButton[row][col]=new LightButton(row, col);
				lighButton[row][col].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						LightButton button=(LightButton) e.getSource();
						int row=button.getRow();
						int col=button.getCol();
						toggleLights(row,col);
						endGameDone();
						
					}
				});
				
				centerPanel.add(lighButton[row][col]);
			}
		}
	}
	private void endGameDone(){
		// do the lights on from a frame
		boolean done=lighButton[0][0].isLit()
				&&lighButton[0][1].isLit()
				&&lighButton[0][2].isLit()
				&&lighButton[1][0].isLit()
				&&!lighButton[1][1].isLit()
				&&lighButton[1][2].isLit()
				&&lighButton[2][0].isLit()
				&&lighButton[2][1].isLit()
				&&lighButton[2][2].isLit();
		if(done){
			String message="Congratlation!!!You won! Do you want to play again?";
			int option=JOptionPane.showConfirmDialog(this, message,"Play again?",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION){
				newGame();
			}
			else{
				System.exit(0);
			}
		}
	}
	
	private void toggleLights(int row, int col){
		lighButton[row][col].toggle();
		// top left corner
		if(row==0&&col==0){
			lighButton[row][col+1].toggle();
			lighButton[row+1][col].toggle();
			lighButton[row+1][col+1].toggle();
		}
		//top right corner
		else if(row==0&&col==2){
			lighButton[row][col-1].toggle();
			lighButton[row+1][col-1].toggle();
			lighButton[row+1][col].toggle();
		}
		// button left corner
		else if(row==2&&col==0){
			lighButton[row-1][col].toggle();
			lighButton[row-1][col+1].toggle();
			lighButton[row][col+1].toggle();
		}
		//button right corner
		else if(row==2&&col==2){
			lighButton[row-1][col].toggle();
			lighButton[row-1][col-1].toggle();
			lighButton[row][col-1].toggle();
		}
		// top row middle
		else if(row==0&&col==1){
			lighButton[row][col-1].toggle();
		//	lighButton[row+1][col].toggle();
			lighButton[row][col+1].toggle();
		}
		// button row middle 
		else if(row==2&&col==1){
			lighButton[row][col-1].toggle();
			lighButton[row][col+1].toggle();
		}
		
		// left side middle
		else if (row==1&&col==0){
			lighButton[row-1][col].toggle();
			lighButton[row+1][col].toggle();
		}
		// right side middle
		else if(row==1&&col==2){
			lighButton[row-1][col].toggle();
			lighButton[row+1][col].toggle();
		}
		//center
		else if(row==1&&col==1){
			lighButton[row-1][col].toggle();
			lighButton[row+1][col].toggle();
			lighButton[row][col-1].toggle();
			lighButton[row][col+1].toggle();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String className=UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
		catch(Exception e){}
			EventQueue.invokeLater(new Runnable(){
				public void run(){
					new Framed();
				}
			});
			
		

	}

}
