package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import principal.entities.ID;
import principal.entities.creatures.Felix;
import principal.util.ResourceLoader;
import principal.util.Timer;

public class HUD {

	private Image lifeImage;
	private int lifeAmount;
	private Font font;
	private Timer clock;
	private Felix felix;
	
	private static HUD hud = new HUD();
	
	private HUD() {
		initFelix();
		clock = new Timer(10, 10,System.currentTimeMillis());
		font = new Font("Bold", Font.BOLD, 15);
		lifeImage = ResourceLoader.getLoader().loadImage("images/life.png");
	}
	
	
	private void initFelix(){
		for (int i = 0; i < Handler.objects.size(); i++) {
			if (Handler.objects.get(i).getID() == ID.Felix){
				felix = (Felix)Handler.objects.get(i);
			}
		}
	}


	public static HUD getHud(){
		return hud;
	}
	
	public void draw(Graphics2D g) {
		
		g.setFont(font);

		// background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constant.WIDTH, 30);
		
		// lineas amarillas
		g.setColor(Color.YELLOW);
		g.fillRect(0, 30, Constant.WIDTH, 2);
		g.fillRect(0, 26, Constant.WIDTH, 2);
				
		g.setColor(Color.RED);
		g.drawString("SCORE", 343, 11);
		g.drawString("HIGHSCORE", 0, 11);
		
		// valores
		g.setColor(Color.WHITE);
		g.drawString(""+Score.getScore().getHighScore(), 2, 25);
		g.drawString(""+Score.getScore().getActualScore(), 343, 25);

		clock.draw(g);
		
		drawLife(g);
	}
	
	
	
	private void drawLife(Graphics2D g) {
		int lifePosX = 0;
		for (int i = 0; i < lifeAmount; i++) {
			g.drawImage(lifeImage, Constant.WIDTH - 50 - lifePosX, 0, null);
			lifePosX += lifeImage.getWidth(null) + 5;
		}
	}
	
	public void reset(){
		initFelix();
		clock = new Timer(10, 10,System.currentTimeMillis());
	}
	
	public void tick() {
		
		lifeAmount = felix.getLife();
		clock.tick();
	}
	
}
