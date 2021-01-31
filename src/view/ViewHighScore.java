package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.HighScore;

public class ViewHighScore extends JFrame {
	protected JPanel highScore;
	private ArrayList<HighScore> listHighScore;

	public ViewHighScore() {
		super.setTitle("HighScore");
		init();
	}

	public void init() {
		

		highScore = new JPanel();
		highScore.setBackground(Color.yellow);
		highScore.setLayout(null);
		add(highScore);
		setLayout(new BorderLayout());
		setResizable(false);
		setSize(300, 485);
		setVisible(true);
		setFocusable(true);
		setLocationRelativeTo(null);
       
	}
  
	 JPanel pnHighScore = new JPanel();
      
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		if (listHighScore == null) {
			drawHighScore(g2d);
		}
	}

	private void drawHighScore(Graphics2D g2d) {
		g2d.setStroke(new java.awt.BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", 0, 30));
		g2d.setColor(Color.BLACK);
//		g2d.drawString("DIEM CAO", 300, 340);
		int y = 250;

		for (int i = 0; i < listHighScore.size(); i++) {
			g2d.drawString("" + (i + 1), 225, y);
			g2d.drawString("" + listHighScore.get(i).getName(), 330, y);
			g2d.drawString("" + listHighScore.get(i).getScore(), 595, y);
			y = y + 35;
		}

	}

	public void setListHighScore(ArrayList<HighScore> newListHighScore) {
		this.listHighScore = newListHighScore;

	}
}
