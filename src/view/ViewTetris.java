package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controller.IController;
import model.GameBoard;
import sound.Music;

public class ViewTetris extends JFrame implements IViewTetris {
//	private static final long serialVersionUID = 1L;
	private JButton newgamebt, optionbt, quitbt, resumebt, levelbt, highscorebt;
	private IController controller;
	private IViewTetris iviewTetris;

	public ViewTetris(IController controller) {
		
		super("Tetris - Group11");
		this.controller = controller;
		init();
	}
	public void init() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("image\\GameBackgroud1.png")));
		getContentPane().setLayout(null);
		addButton();
		mouseEventButton();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void addButton() {
		/** GridLayout */
		JPanel p = new JPanel(new GridLayout(6, 1, 5, 10));
		p.setSize(new Dimension(150, 280));
		getContentPane().add(p);
		/** create button */
		p.add(new CircleDecorater(newgamebt = new JButton("NewGame")));
		p.add(new CircleDecorater(resumebt = new JButton("Resume")));
		p.add(new CircleDecorater(levelbt = new JButton("Level")));
		p.add(new CircleDecorater(highscorebt = new JButton("High Score")));
		p.add(new CircleDecorater(optionbt = new JButton("Option")));
		p.add(new CircleDecorater(quitbt = new JButton("Quit")));
		
		/** set font and size for text in button */
		newgamebt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
		resumebt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
		highscorebt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
		levelbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
		optionbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
		quitbt.setFont(new Font("SVN-Block", Font.PLAIN, 16));
		/** set  border for button */
		newgamebt.setBorder(new LineBorder(Color.ORANGE, 3));
		resumebt.setBorder(new LineBorder(Color.ORANGE, 3));
		highscorebt.setBorder(new LineBorder(Color.ORANGE, 3));
		levelbt.setBorder(new LineBorder(Color.ORANGE, 3));
		optionbt.setBorder(new LineBorder(Color.ORANGE, 3));
		quitbt.setBorder(new LineBorder(Color.ORANGE, 3));
		
		p.setOpaque(false);
		p.setLocation(100, 250);
		
	}

	public void mouseEventButton() {
		newgamebt.addMouseListener(addEvent());
		resumebt.addMouseListener(addEvent());
		highscorebt.addMouseListener(addEvent());
		levelbt.addMouseListener(addEvent());
		optionbt.addMouseListener(addEvent());
		quitbt.addMouseListener(addEvent());
	}


	public MouseListener addEvent() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == newgamebt) {
					startGame();
				}
				if (e.getSource() == quitbt) {
					closeGame();
				}
				if (e.getSource() == optionbt) {
					showOption();
				}
				if (e.getSource() == resumebt) {
					resume();
				}
				if (e.getSource() == highscorebt) {
					showHighScore();
				}
				if (e.getSource() == levelbt) {
					showLevel();
				}
				super.mouseClicked(e);
			}

		

		};
	}

	public void resume() {
			controller.resume();
	}

	public void closeGame() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure to close this game?", "Close Tetris",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void startGame() {
		setVisible(false);
		controller.start();
	}

	@Override
	public void start() {

	}

	@Override
	public void update() {

	}

	@Override
	public void pause() {
		setVisible(true);
	}

	@Override
	public void lose() {
		setVisible(true);
	}

	public void showLevel() {
		new ViewLevel(controller);
	}

	@Override
	public void hidden() {
		setVisible(false);
	}
	public void showHighScore() {
		new ViewHighScore();
	}
	public void showOption() {
		new ViewOption();
		
		
	}

	

	
}
