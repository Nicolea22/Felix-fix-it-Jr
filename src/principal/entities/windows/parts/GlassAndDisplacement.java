package principal.entities.windows.parts;

import principal.Game;
import principal.graphics.Sprite;

public class GlassAndDisplacement{

	private Sprite glass;
	private int dispX;
	private int dispY;
	
	public GlassAndDisplacement(int i) {
		glass = Game.animations.getGlass(i);
		initDisplacement(i);
	}
	
	private void initDisplacement(int i){
		switch(i){
			case 0:
				dispX = 9;
				dispY = 12;
				break;
			case 1:
				dispX = 9;
				dispY = 12;
				break;
			case 2:
				dispX = 10;
				dispY = 11;
				break;
			case 3:
				dispX = 10;
				dispY = 10;
				break;
			case 4:
				dispX = 11;
				dispY = 11;
				break;
			case 5:
				dispX = 13;
				dispY = 11;
				break;
			case 6:
				dispX = 9;
				dispY = 11;
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
