package principal.entities.windows.parts;

import principal.graphics.Sprite;
import principal.util.ResourceLoader;

public class GlassAndDisplacement{

	private Sprite glass;
	private int dispX;
	private int dispY;
	
	public GlassAndDisplacement(int i) {
		glass = new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/glasses/"+i+".png"));
		initDisplacement(i);
	}
	
	private void initDisplacement(int i){
		switch(i){
			case 0:
				dispX = 9;
				dispY = 12;
				break;
			case 1:
				dispX = 10;
				dispY = 11;
				break;
			case 2:
				dispX = 10;
				dispY = 10;
				break;
			case 3:
				dispX = 11;
				dispY = 11;
				break;
			case 4:
				dispX = 13;
				dispY = 11;
				break;
			case 5:
				dispX = 9;
				dispY = 11;
				break;
			default:
				break;
		}
	}
	

	public int getDispX() {
		return dispX;
	}
	
	public int getDispY() {
		return dispY;
	}
	
	public Sprite getImage(){
		return glass;
	}
	
}
