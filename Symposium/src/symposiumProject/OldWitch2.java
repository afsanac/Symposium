package symposiumProject;

import gui.components.Action;

public class OldWitch2 extends Decision {

	private int number = 0;
	
	public OldWitch2() {
		super();
		setDescription("The old Witch is raging with anger, and she coming towards you.");
		addChoice(new Choice("Fight the Witch", new Action() {
			
			@Override
			public void act() {
				if(number == 0){
					GameScreen.result.setText("Oh no! The old Witch tried to eat you!");
					GameScreen.player.injure();
					number++;
					GameScreen.game.nextChoice(3);//1 is the index of the dragon choice
				}else{
					GameScreen.player.kill();
					GameScreen.game.nextChoice();
					
				}
			}
		}));
		addChoice(new Choice("Climb the chimney", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("you narrowly escaped");
				GameScreen.game.nextExclusiveChoice(2);
				GameScreen.game.nextExclusiveChoice(3);
			}
		}));
		// TODO Auto-generated constructor stub
	}
	
}