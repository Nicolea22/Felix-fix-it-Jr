package principal.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import principal.entities.creatures.Felix;

public class KeyBoard extends KeyAdapter{

	private final int keysAmount = 256; 
	private boolean[] keys;

	public static boolean up;
	public static boolean down;
	public static boolean right;
	public static boolean left;
	public static boolean pause;
	public static boolean fix;
	

	public KeyBoard(){
		keys = new boolean[keysAmount];
	}
	
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_LEFT];
		fix = keys[KeyEvent.VK_SPACE];
		pause = keys[KeyEvent.VK_ESCAPE];
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		e.consume();
	}
	
	
//	
//	public void keyPressed(KeyEvent e) {
//		int key = e.getKeyCode();
//		
//		if (key == KeyEvent.VK_UP)
//			Felix.getFelix().setDy(-2.5f);
//		if (key == KeyEvent.VK_DOWN)
//			Felix.getFelix().setDy(2.5f);
//		if (key == KeyEvent.VK_RIGHT)
//			Felix.getFelix().setDx(2.5f);
//		if (key == KeyEvent.VK_LEFT)
//			Felix.getFelix().setDx(-2.5f);
//		if (key == KeyEvent.VK_ESCAPE)
//			System.exit(1);
//		
//		e.consume();
//	}
//	
//	
//	public void keyReleased(KeyEvent e) {
//		int key = e.getKeyCode();
//		if (key == KeyEvent.VK_UP)
//			Felix.getFelix().setDy(0);
//		if (key == KeyEvent.VK_DOWN)
//			Felix.getFelix().setDy(0);
//		if (key == KeyEvent.VK_RIGHT)
//			Felix.getFelix().setDx(0);
//		if (key == KeyEvent.VK_LEFT)
//			Felix.getFelix().setDx(0);
//		e.consume();
//	}
//	
	
}
	
	
