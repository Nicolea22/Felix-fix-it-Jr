package principal.statemachine.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.Constant;
import principal.Score;
import principal.input.MouseInput;
import principal.statemachine.GameState;
import principal.statemachine.GameStatus;

public class ScoreMenu implements GameState{
	
	private Font font;
	private Font font1;
	
	public Rectangle backButton = new Rectangle(300, 450, 100, 50);
	
	public ScoreMenu() {
		font = new Font("Bold", Font.BOLD,15);
		font1 = new Font("Bold", Font.BOLD, 70);
	}
	
	@Override
	public void tick(long time) {
		if (MouseInput.leftClick){
			if (backButton.contains(MouseInput.getPointer())){
				GameStatus.changeState(0);
				GameManager.setChoose(false);
			}
		}
		
	}

	@Override
	public void draw(Graphics2D g, long time) {
		
		g.setColor(Color.WHITE);
	
		g.setFont(font1);
		g.drawString("HIGHSCORES", 30,  100);
		
		g.setFont(font);	
		for (int i = 0; i < 4; i++){
			String scores = Score.getScore().getCertainName(i)+":   "+Score.getScore().getCertainScore(i);
			g.drawString(scores, 30, 100 + (i+1) * 50);
		}
		
		g.drawString("Back",backButton.x + 19,backButton.y+30);
		g.draw(backButton);
		
	}

}
