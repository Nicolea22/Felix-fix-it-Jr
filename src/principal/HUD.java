package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import principal.entities.creatures.Felix;
import principal.util.ResourceLoader;

public class HUD {

	private Image lifeImage;
	private int lifeAmount;
	private Font font;
	
	public HUD(Felix felix) {
		lifeAmount = felix.getLife();
		font = new Font("Bold", Font.BOLD, 15);
		lifeImage = ResourceLoader.getLoader().loadImage("images/life.png");
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
		g.drawString("00000000000", 2, 25);
		g.drawString("00000000000", 343, 25);

		drawLife(g);
	}
	
	private void drawLife(Graphics2D g) {
		int lifePosX = 0;
		for (int i = 0; i < lifeAmount; i++) {
			g.drawImage(lifeImage, Constant.WIDTH - 50 - lifePosX, 0, null);
			lifePosX += lifeImage.getWidth(null) + 5;
		}
	}
	
	public void tick(Felix felix) {
		lifeAmount = felix.getLife();
	}
	
}
