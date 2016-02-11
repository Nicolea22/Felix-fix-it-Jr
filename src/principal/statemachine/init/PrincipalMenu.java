package principal.statemachine.init;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import principal.Constant;
import principal.Game;
import principal.Level;
import principal.Score;
import principal.entities.Building;
import principal.entities.creatures.Cloud;
import principal.graphics.DrawingSurface;
import principal.graphics.Sprite;
import principal.input.KeyBoard;
import principal.input.MouseInput;
import principal.statemachine.GameState;
import principal.statemachine.GameStatus;
import principal.statemachine.gamestate.GameManager;

public class PrincipalMenu implements GameState{
	
	private int DISP_X = 30;
	
	public Rectangle playButton = new Rectangle(Constant.WIDTH/2 - 100/2 - 20 , 270, 100, 50);
	public Rectangle scoreButton = new Rectangle(Constant.WIDTH/2 - 100/2  - 20, 320,100, 50);
	public Rectangle helpButton = new Rectangle(Constant.WIDTH/2 - 100/2 - 20, 370, 100, 50);
	public Rectangle configButton = new Rectangle(Constant.WIDTH - 50, 0, 45, 45);
	public Rectangle quitButton = new Rectangle(Constant.WIDTH/2 - 100/2 - 20, 420, 100, 50);
		
	private boolean drawString;
	private int counter = 0;
	
	private Building building;
	
	private Font font;
	private Font font2;
	private Sprite menu;
	
	private String[] levels;
	
	private boolean barspacePushed;
	
	private Cloud cloud;
	private Cloud cloud1;
	
	private Sprite config;
	
	public PrincipalMenu() {
		
		font = new Font("arial",Font.ROMAN_BASELINE, 25);
		font2 = new Font("arial", Font.ITALIC, 12);
		
		menu = Game.animations.getMenu();
		
		barspacePushed = false;
		
		building = Building.getBuilding();
		config = Game.animations.getConfig();
		
		cloud = new Cloud(Constant.WIDTH/2, 300);
		cloud1 = new Cloud(0, 150);
		
		levels = new String[10];
	}
	
	
	private void initLevels() {
		for (int i = 0; i < levels.length; i++){
			levels[i] = "Level " + (i+1);
		}
	}
	
	
	@Override
	public void tick(long beforeTime) {
		cloud.tick(null, beforeTime);
		cloud1.tick(null, beforeTime);
		if (barspacePushed){
			if (MouseInput.leftClick) {
				if (playButton.contains(MouseInput.getPointer())){
					GameManager.getGameManager().resetGameManager();
					restart();
				}else
					if (scoreButton.contains(MouseInput.getPointer())){
						GameStatus.changeState(3);
					}else
						if (helpButton.contains(MouseInput.getPointer())){
							GameStatus.changeState(4);
						}else
							if (configButton.contains(MouseInput.getPointer())){
									drawFrame();
							}else
								if (quitButton.contains(MouseInput.getPointer())) {
									Game.quitGame();
								}		
			}										
		}
	}
	

	private void drawFrame() {
		
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Choose");
		initLevels();
		final JComboBox combo = new JComboBox(levels);
		
		frame.setSize(300, 90);
		frame.setVisible(true);
		
		panel.setBackground(Color.BLACK);
		panel.add(button, BorderLayout.EAST);
		panel.add(combo, BorderLayout.SOUTH);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Level.getLevel().chooseLevel((String)combo.getSelectedItem());
				GameManager.setChoose(true);
				frame.setVisible(false);
			}
			
		});
		
	}
	
	
	



	private void restart() {
		GameManager.getGameManager().resetGameManager();
		GameStatus.changeState(1);	
		Score.getScore().reset();
		DrawingSurface.resetSurface();
	}
	
	@Override
	public void draw(Graphics2D g, long beforeTime) {
		
		clean(g);
		
		// Anti aliasing
		g.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		cloud.draw(g, beforeTime);
		cloud1.draw(g, beforeTime);		
		
		building.draw(g, beforeTime);

		
		g.setFont(font);
		g.setColor(Color.YELLOW);
	
		drawPressBar(g);

		g.drawImage(menu.getImage(), Constant.WIDTH/2 - menu.getWidth()/2 + 13,
				Constant.HEIGHT/2 - menu.getHeight()/2 - 100,null);
		if (barspacePushed){
			
			g.drawImage(config.getImage(), Constant.WIDTH - 50, 0, null);
			
			g.setColor(Color.BLACK);
			g.fillRect(Constant.WIDTH/2 - 100/2 - 18, 270, 75, 40);
			g.fillRect(Constant.WIDTH/2 - 100/2 - 18, 320, 176, 40);
			g.fillRect(Constant.WIDTH/2 - 100/2 - 18, 370, 98, 40);
			g.fillRect(Constant.WIDTH/2 - 100/2 - 18, 420, 70, 40);
			
			g.setColor(Color.RED);
			
			g.setFont(font);
			
			g.drawString("PLAY", playButton.x + 8, playButton.y + 30);
//			g.draw(playButton);
			
			g.drawString("HIGHSCORES", scoreButton.x + 8 , scoreButton.y + 30);
//			g.draw(scoreButton);
			
			g.drawString("RULES", helpButton.x + 8, helpButton.y + 30);
//			g.draw(helpButton);
			g.drawString("QUIT",quitButton.x + 8, quitButton.y + 30);
			
			
		}
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString("Powered by Bonfils, Suarez and Dominguez Vega", DISP_X, Constant.HEIGHT - 50);	
	}

	
	private void clean(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constant.WIDTH, Constant.HEIGHT);
	}
	
	
	private void drawPressBar(Graphics2D g) {
		counter++;
		if (counter  > 3000 && !barspacePushed){
			counter = 0;
			drawString = !drawString;
		}
		if (drawString){
			g.drawString("Press Barspace to Start", Constant.WIDTH/2 - 135 ,Constant.HEIGHT/2 + 40);
		}
		if (KeyBoard.fix){
			barspacePushed = true;
			drawString = false;
		}
	}
	
	
}
