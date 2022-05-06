package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.*;

public class TriquiPane extends JPanel implements ActionListener{

	private Image buttonImage;
	private Image X;
	private Image O;
	private Image winner;
	private JLabel showWinner;
	private CustomEvent event;
	private int turn;
	private JButton [] boxes;
	private String []  boxMirror;
	private boolean end;

	public TriquiPane() {
		turn = 1;
		this.setLayout(null);
		this.setBorder(new TitledBorder(null, "Tablero",
				TitledBorder.CENTER, TitledBorder .TOP , null,Color.black));
		this.setBackground(new Color(11, 83, 69 ));
		buttonImage = new ImageIcon(getClass().getResource("/Image/green.jpg"))
				.getImage();
		X = new ImageIcon(getClass().getResource("/Image/X.jpg"))
				.getImage();
		O = new ImageIcon(getClass().getResource("/Image/O.jpg"))
				.getImage();
       end = false;
       initTriqui();
	}

	public void initTriqui() {
		boxes = new JButton [9];
		boxMirror = new String [9];

		int size= 125;
		int y=20;
		int x=25;

		for (int i=0;i<9;i++) { 
			boxes[i]= new JButton();
			boxes[i].setBounds(x,y,size,size);
			boxes[i].addActionListener(this);
			add(boxes[i]);
			y+=size+20;
			if((i+1)%3==0) {
				y=20; 
				x+=size+20;   	   
			}
		}
		createTriqui();
	}
    public void createTriqui() {
    	end = false;
		for (int i=0;i<9;i++) { 
			boxMirror[i]="-";
			boxes[i].setIcon(new ImageIcon(buttonImage.
					getScaledInstance(125,125,Image.SCALE_SMOOTH)));

		}
    }
	public CustomEvent getEvent() {
		return event;
	}

	public void setEvent(CustomEvent event) {
		this.event = event;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(end==false) {		
			for (int i=0;i<boxes.length;i++) {  //filas 
				if(e.getSource().equals(boxes[i]) && boxMirror[i].equals("-")) {			
					if(turn==1) {
						boxes[i].setIcon(new ImageIcon(X.
								getScaledInstance(150,150,Image.SCALE_SMOOTH)));
						boxes[i].setName("X");
						turn = 0;
						boxMirror[i]="X";
					}else {
						boxMirror[i]="O";
						boxes[i].setIcon(new ImageIcon(O.
								getScaledInstance(150,150,Image.SCALE_SMOOTH)));
						boxes[i].setName("O");
						turn = 1;
					}
					event.sendTriqui(boxMirror,i);
				}
			}
		}
	}

	public void showWinnerT(int[] winOp, String resultString) {
		
		winner = new ImageIcon(getClass().getResource("/Image/"+resultString+"Winner.jpg"))
				.getImage();
        	boxes[winOp[0]].setIcon(new ImageIcon(winner.
					getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        	boxes[winOp[1]].setIcon(new ImageIcon(winner.
					getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        	boxes[winOp[2]].setIcon(new ImageIcon(winner.
					getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        	end = true;
	}
}
