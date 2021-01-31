package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameBoard;

public class ViewScore extends  JPanel implements Observer{
	 private JLabel jlabel;
	 GameBoard gameBoard;
   public ViewScore(Observable observable) {
	   observable.addObserver(this);
	   jlabel = new JLabel();
	   add(jlabel);
   }

   
   @Override
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	   String score = String.valueOf(gameBoard.getScore());
	    String level = String.valueOf(gameBoard.getLevel());
	    String highScore = String.valueOf(gameBoard.getHighScore());
	    String s = "ScoreCurrent: "+ score+"    "+"Level: "+level+"  "+"HighScore: "+highScore;
	  g.drawString(s, 100, 200);
}
@Override
public void update(Observable o, Object arg) {
	if(o instanceof GameBoard) {
		GameBoard gameboard = (GameBoard) o;
	    String score = String.valueOf(gameboard.getScore());
	    String level = String.valueOf(gameboard.getLevel());
	    String highScore = String.valueOf(gameboard.getHighScore());
	    String s = "ScoreCurrent: "+ score+"    "+"Level: "+level+"  "+"HighScore: "+highScore;
		jlabel.setText(s);
		jlabel.setBackground(Color.GREEN);
		this.repaint();
		
	}
}
}
