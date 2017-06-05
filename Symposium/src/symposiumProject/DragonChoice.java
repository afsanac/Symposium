package symposiumProject;

import gui.components.Action;

public class DragonChoice extends Decision {

	private int number = 0;
	
	public DragonChoice() {
		super();
		setDescription("You encountered a Dragon");
		addChoice(new Choice("Fight Dragon", new Action() {
			
			@Override
			public void act() {
				if(number == 0){
					GameScreen.result.setText("the Dragon injured you");
					GameScreen.player.injure();
					number++;
					GameScreen.game.nextChoice(1);//1 is the index of the dragon choice
				}else{
					GameScreen.player.kill();
					GameScreen.game.nextChoice();
					
				}
			}
		}));
		addChoice(new Choice("Flee", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("you narrowly escaped");
				GameScreen.game.nextExclusiveChoice(1);
			}
		}));
		// TODO Auto-generated constructor stub
	}

}
