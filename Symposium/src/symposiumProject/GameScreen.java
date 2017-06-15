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
	private Button choice1Button;
	private Button choice2Button;
	
	
	private Decision[] allDecisions={new ExploreChoice(),new DragonChoice(), new OldWitch(), new OldWitch1(), new OldWitch2(), 
			new MushroomGarden(), new Unicorn()};
	
	public static TextLabel result;
	public static GameScreen game;		
	public static Character player;

	public GameScreen(int width, int height) {
		super(width, height);
		game = this;
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
		player = new Player();
		title = new TextLabel(300, 100, 200, 50, "Fairly Oddventure");
		setLabelFont(title, "Marchand de Venise", 55f);
		author = new TextLabel(300, 150, 250, 50, "By Afsana Chadni");
		result= new TextLabel(50, 10, 600, 100, "");
		viewObjects.add(result);
		intro = new TextLabel(50, 60, 600, 100, "Welcome To FaeryLand! My name is Pixie and I'll be your guide. As you exlpore FaeryLand with me as your"
				+ "guide you will see many magical lands and with it's beautiful inhabits. But be careful some of these inhabits are vicious, dont be"
				+ "fooled by their looks or you will be dead! Don't worrt too much, I'll at least warn, or let you know you're hurt. Now let's get on "
				+ "with the exploring!");
		choice1Button = new Button(300, 400, 180, 50, "a", Color.MAGENTA, null);
		choice2Button = new Button(500, 400, 180, 50, "b", Color.BLUE, null);

		gameStarter = new Button(300, 200, 200, 50, "Start Game", Color.GREEN, new Action() {

			public void act() {
				viewObjects.remove(title);
				viewObjects.remove(author);
				viewObjects.remove(gameStarter);
				addObject(choice1Button);
				addObject(choice2Button);
				addObject(intro);
				nextChoice();
				viewObjects.add(intro);
//				

			}
		});
		viewObjects.add(title);
		viewObjects.add(author);
		viewObjects.add(gameStarter);


	}

	//random
	protected void nextChoice() {
		int i = (int) (Math.random()*allDecisions.length);
		nextChoice(i);
	}

	//anything but i
	protected void nextExclusiveChoice(int i) {
		int j = (int) (Math.random()*allDecisions.length);
		while(j==i){
			j = (int) (Math.random()*allDecisions.length);
		}
		nextChoice(j);
	}

	//select
	public void nextChoice(int i) {
		if(player.isAlive()){
			Decision d= allDecisions[i];
			intro.setText(d.getDescription());
			
			Choice c1= d.getChoices().get(0);
			Choice c2= d.getChoices().get(1);
			choice1Button.setText(c1.getDescription());
			choice2Button.setText(c2.getDescription());
			choice1Button.setAction(c1.getResult());
			choice2Button.setAction(c2.getResult());
		}else{
			intro.setText("game Over");
			remove(choice1Button);
			remove(choice2Button);
		}
	}

}
