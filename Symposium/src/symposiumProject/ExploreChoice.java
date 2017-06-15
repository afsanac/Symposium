package symposiumProject;

import gui.components.Action;

public class ExploreChoice extends Decision {

	public ExploreChoice() {
		super();
		setDescription("You encounter a Death Forest");
		addChoice(new Choice("Explore the Forest", new Action() {

			@Override
			public void act() {
				GameScreen.player.kill();
				GameScreen.game.nextChoice();
			}
		}));
		addChoice(new Choice("Do not go", new Action() {
			
			@Override
			public void act() {
				GameScreen.game.nextChoice();
			}
		}));
		// TODO Auto-generated constructor stub
	}

}
