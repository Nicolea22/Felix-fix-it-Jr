package principal.graphics;

import java.awt.Image;

public class Sprite {
	
	private Image image;
	
	public Sprite(Image image){
		this.image = image;
	}
	
	public Image getImage(){
		return image;
	}
	
	
	public int getWidth(){
		return image.getWidth(null);
	}
	
	public int getHeight(){
		return image.getHeight(null);
	}
	
}
