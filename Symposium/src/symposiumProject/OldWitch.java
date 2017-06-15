package symposiumProject;

import gui.components.Action;

public class OldWitch extends Decision {

	private int number = 0;
	
	public OldWitch() {
		super();
		setDescription("You're in front of the old Witch's House");
		addChoice(new Choice("Go inside", new Action() {
			
			@Override
			public void act() {
					GameScreen.result.setText("Oh no! The old Witch tried to eat you!");
					GameScreen.game.nextChoice(2);//1 is the index of the dragon choice
					
				}
		}));
		addChoice(new Choice("Flee", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("you narrowly escaped");
				GameScreen.game.nextExclusiveChoice(2);
				GameScreen.game.nextChoice(3);
			}
		}));
		// TODO Auto-generated constructor stub
	}

}