package symposiumProject;

import gui.components.Action;

public class Unicorn extends Decision {

	private int number = 0;
	
	public Unicorn() {
		super();
		setDescription("OH! She's a beauty! That's Belle, one of the friendliest unicorn in the land. All you have to do"
				+ "is walk up to her slowly and she'll let you ride her. She doesn't like being surprised.");
		addChoice(new Choice("Ride", new Action() {
			
			@Override
			public void act() {
				if(number == 0){
					GameScreen.result.setText("Belle kick you to the side and injured you! I told you be careful");
					GameScreen.player.injure();
					number++;
					GameScreen.game.nextChoice(6);//1 is the index of the dragon choice
				}else{
					GameScreen.player.kill();
					GameScreen.game.nextChoice();
					
				}
			}
		}));
		addChoice(new Choice("Walk Slowly", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("You're riding Belle as she races through enchanted forest. Oh what great sights you're seeing!");
				GameScreen.game.nextExclusiveChoice(6);
			}
		}));
		// TODO Auto-generated constructor stub
	}

}