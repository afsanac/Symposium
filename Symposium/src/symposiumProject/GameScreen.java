package symposiumProject;

import java.awt.Color;
import java.util.List;

import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable {

	private TextLabel title;
	private TextLabel author;
	private TextLabel intro;
	private Button gameStarter;
	private Button exitIntro;

	public GameScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextLabel(300, 100, 200, 50, "Faery Adventure");
		author = new TextLabel(300, 150, 250, 50, "By Afsana Chadni");
		intro = new TextLabel(50, 100, 700, 300, "Welcome To FaeryLand" + "My name is Pixie and I'll be your guide");
		
		gameStarter = new Button(300, 200, 200, 50, "Start Game", Color.CYAN, new Action(){

			public void act(){
				viewObjects.remove(title);
				viewObjects.remove(author);
				viewObjects.remove(gameStarter);
				viewObjects.add(intro);
				exitIntro = new Button(400, 400, 200, 50, "Exit", Color.DARK_GRAY, new Action(){
					
					public void act(){
						remove(intro);
						remove(exitIntro);
					}
				});
				
			}
		});
		
	}

}
