package principal.entities.windows.parts;

import principal.graphics.Sprite;

public class Glass {
	
	private GlassAndDisplacement[] glasses;
	
	
	public Glass(){
		glasses = new GlassAndDisplacement[6];
		for (int i = 0; i < glasses.length; i++) {
			glasses[i] = new GlassAndDisplacement(i);
		}
	}
	
	public int getDispX(int i) {
		return glasses[i].getDispX();
	}
	
	public int getDispY(int i) {
		return glasses[i].getDispY();
	}
	
	public Sprite getGlass(int i){
		return glasses[i].getImage();
	}
	
	
}
