package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import principal.entities.creatures.Felix;
import principal.graphics.Sprite;
import principal.util.Timer;

public class HUD {

	private Sprite lifeImage;
	private int lifeAmount;
	private Font font;
	private Timer clock;
	private Felix felix;
	
	private static HUD hud = new HUD();
	
	private HUD() {
		clock = new Timer(180000);
		font = new Font("Bold", Font.BOLD, 15);
		lifeImage = Game.animations.getLife();
	}
	
	
	public void setFelix(Felix felix){
		this.felix = felix;
	}


	public static HUD getHud(){
		return hud;
	}
	
	public void draw(Graphics2D g) {
		
		// Anti aliasing
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		g.setFont(font);

		// background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constant.WIDTH, 30);
		
		// lineas amarillas
		g.setColor(Color.YELLOW);
		g.fillRect(0, 30, Constant.WIDTH, 2);
		g.fillRect(0, 26, Constant.WIDTH, 2);
				
		g.setColor(Color.RED);
		g.drawString("SCORE", 0, 11);
		
		// valores
		g.setColor(Color.WHITE);
		g.drawString(""+Score.getScore().getActualScore(), 2, 25);

		clock.draw(g);
		
		drawLife(g);
	}
	
	
	
	
	private void drawLife(Graphics2D g) {
		int lifePosX = 0;
		for (int i = 0; i < lifeAmount; i++) {
			g.drawImage(lifeImage.getImage(), Constant.WIDTH - 50 - lifePosX, 0, null);
			lifePosX += lifeImage.getImage().getWidth(null) + 5;
		}
	}

	
	
	public void reset(){
		clock.reset(); 
	}
	
	public void tick() {
		lifeAmount = felix.getLife();
		clock.tick();
	}
	
}
