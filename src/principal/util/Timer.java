package principal.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import principal.Score;

public class Timer {
		
	private boolean reset = false;
	private long ms;
	private int second;
	private int minute;
	
	public Timer(int minute, int second, long beforeTime){
		ms = beforeTime;
		this.second = second;
		this.minute = minute;
	}
	
	public void tick() {
		countDown();
		if(second == 0 && minute == 0){
			Score.getScore().saveScore();
		}
		reset();
	}
	
	private void countDown(){
		if (System.currentTimeMillis() - ms > 1000){
			second--;
			ms = System.currentTimeMillis();
			if (second == -1){
				minute--;
				second = 59;
			}
		}
	}	
	
	private void reset() {
		if (reset){
			second = 0;
			minute = 0;
			reset = false;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Bold", Font.BOLD, 30));
		g.drawString(Integer.toString(minute) + ":" + Integer.toString(second) , 500, 23);
	}
}
