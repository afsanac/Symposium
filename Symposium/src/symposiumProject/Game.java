package symposiumProject;

import gui.GUIApplication;

public class Game extends GUIApplication {
	public Game(int width, int height) {
		super(width, height);
		
	}
public static void main(String[] args){
	 Game g = new Game(800, 500);
	 Thread game = new Thread(g);
	 game.start();
}
	@Override
	public void initScreen() {
		GameScreen gs = new GameScreen(getWidth(), getHeight());
		setScreen(gs);
		
	}

}
