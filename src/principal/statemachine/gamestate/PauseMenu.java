package principal.statemachine.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.statemachine.GameState;

public class PauseMenu implements GameState{


	public Rectangle playButton1 = new Rectangle(200,150,100,50);
	public Rectangle playButton2 = new Rectangle(200,250,100,50);
	public Rectangle playButton3 = new Rectangle(200,350,100,50);
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		Font fnt0 = new Font("arial",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Pause", 200,100);
		
		
		Font fnt1 = new Font("arial",Font.BOLD,30);
		g.setFont(fnt1);
		g.drawString("Main Menu",playButton1.x+19,playButton1.y+30);
		g.draw(playButton1);
		g.drawString("Resume",playButton2.x+19,playButton2.y+30);
		g.draw(playButton2);
		g.drawString("Restart",playButton3.x+19,playButton3.y+30);
		g.draw(playButton3);
		
		
	}

}
