package principal;

public class TestGame {

	
	/* Los rectangulos verdes son las cajas de colisiones que hicimos 
	 * para poder debugear y saber si funciona bien la colision con otros objetos.
	 *
	 * Tambien esta el paquete state machine, ese paquete guarda los estados de todo 
	 * lo que pasa en el juego, si se encuentra en pausa que dibujar, si felix esta moviendose
	 * tambien que va a pasar con felix incluyendo el dibujo.
	 */
	
	public static void main(String[] args) {
		Game game = Game.getGame();
		game.startGame();
	}

}
