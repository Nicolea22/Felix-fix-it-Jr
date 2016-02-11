package principal.input;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	private static int x;
	private static int y;
	
	public static boolean leftClick;
	
	
	public MouseInput() {
		leftClick = false;
	}
	

	public void tick() {
		if (leftClick) {		
			leftClick = !leftClick;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();
		
		leftClick = true;
		
	}
	

	
	public static Point getPointer(){
		return new Point(x,y);
	}
	
	
}
