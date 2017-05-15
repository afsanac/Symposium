package symposiumProject;

import gui.GUIApplication;

public class Game extends GUIApplication {
	public Game(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initScreen() {
		GameScreen gamscreen = new GameScreen(getWidth(), getHeight());
		setScreen(gamscreen);
		
	}

}
