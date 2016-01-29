package principal;

import principal.graphics.*;
import principal.statemachine.GameStatus;

public class Game {

	private boolean inGame;
	
	private Window window;
	private DrawingSurface drawingSurface;
	private GameStatus gameStatus;
	
	
	public static int  fps = 0;
	public static int  tps = 0;
	
	public Game() {
		inGame = true;
		drawingSurface = new DrawingSurface();
		window = new Window("Fix it, Felix Jr." , drawingSurface);
		gameStatus = new GameStatus();
	}
	
	
	public void startGame(){
		loopGame();
	} 
	
	// todo el bucle contabilizando cada una de las iteraciones y con cuentas para saber cuando actualizar y cuando dibujar
	private void loopGame() {
		
		int framesAmount = 0;
		int ticksAmount = 0;
		
		int NS_PER_SECOND = 1000000000;
		int TPS_OBJ = 60; // este numero es el que maneja la cantidad de Ticks por segundo.
		int NS_PER_TICK = NS_PER_SECOND/TPS_OBJ;
		
		long counterReference = System.nanoTime();
		long updateReference = System.nanoTime();
		
		double elapsedTime;
		double delta = 0;
		
		while (inGame)
		{		
			
			final long startLoop = System.nanoTime();
			elapsedTime = startLoop - updateReference;
			
			updateReference = startLoop;
			
			delta += elapsedTime/NS_PER_TICK;
			
			while (delta >= 1){
				tick();
				ticksAmount++;
				delta--;
			}
			
			draw();
			framesAmount++;
			
			if (System.nanoTime() - counterReference > NS_PER_SECOND){
				
				fps = framesAmount;
				tps = ticksAmount;
			
//				System.out.println("fps  "+ fps);
//				System.out.println("tps  "+ tps);
				
				framesAmount = 0;
				ticksAmount = 0;
				
				counterReference = System.nanoTime();
			}	
		}	
	}


	private void tick() {
		gameStatus.tick();
		drawingSurface.tick();
	}

	// se manda el game status porque sabe que dibujar en el momento indicado, ejemplo si pulso pausa
	// el game status va a dibujar una pantalla negra con un string que diga pausa 
	// (falta indicar en el codigo que cuando pulso escape el game status cambiara al modo pausa), si pongo game manager como status
	// dibujara los objetos que corresponden cuando estes jugando felix, pajaros, ralph, etc.
	
	private void draw(){
		drawingSurface.draw(gameStatus);
	}
	
	
}
