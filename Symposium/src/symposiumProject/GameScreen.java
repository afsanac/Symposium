package symposiumProject;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
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
	private String[] locations;

	public GameScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void setLabelFont(TextLabel label, String fontname, float size){
		try {
			File fontFile = new File("resources/"+fontname+".ttf");
			//			File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(size);
			label.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		String[] setTo = {"You're in Enchanted Forest", "You found the old witch well!", "Oh no! You found the great dragon!"};
		title = new TextLabel(300, 100, 200, 50, "Fairly Oddventure");
		setLabelFont(title, "Marchand de Venise", 55f);
		author = new TextLabel(300, 150, 250, 50, "By Afsana Chadni");
		intro = new TextLabel(50, 10, 600, 100, "Welcome To FaeryLand! My name is Pixie and I'll be your guide");

		gameStarter = new Button(300, 200, 200, 50, "Start Game", Color.CYAN, new Action() {

			public void act() {
				viewObjects.remove(title);
				viewObjects.remove(author);
				viewObjects.remove(gameStarter);
				viewObjects.add(intro);
				exitIntro = new Button(400, 400, 200, 50, "Exit", Color.DARK_GRAY, new Action() {

					public void act() {
						remove(intro);
						remove(exitIntro);
						
					}
				});

			}
		});
		viewObjects.add(title);
		viewObjects.add(author);
		viewObjects.add(gameStarter);
//		viewObjects.add(exitIntro);

	}

}
