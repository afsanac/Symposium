package symposiumProject;

import gui.components.Action;

public class MushroomGarden extends Decision {

	public MushroomGarden() {
		super();
		setDescription("You found the mushroom garden!");
		addChoice(new Choice("Eat a Mushroom", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("OH NO! You ate a deadly mushroom! Ypu stupid human!");
				GameScreen.player.kill();
				GameScreen.game.nextChoice();
			}
		}));
		addChoice(new Choice("Explore", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("The mushrooms are a beauty but careful, don't ever eat one for they are all deadly.");
				GameScreen.game.nextChoice();
			}
		}));
		// TODO Auto-generated constructor stub
	}

}