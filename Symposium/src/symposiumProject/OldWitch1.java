package symposiumProject;

import gui.components.Action;

public class OldWitch1 extends Decision {

	private int number = 0;
	
	public OldWitch1() {
		super();
		setDescription("Inside the house, you hear the old witch singing.");
		addChoice(new Choice("Explore the house", new Action() {
			
			@Override
			public void act() {
				if(number == 0){
					GameScreen.result.setText("The old Witch is angry! You touched one of her belongings");
					GameScreen.player.injure();
					number++;
					GameScreen.game.nextChoice(3);//1 is the index of the dragon choice
				}else{
					GameScreen.player.kill();
					GameScreen.game.nextChoice();
					
				}
			}
		}));
		addChoice(new Choice("Flee", new Action() {
			
			@Override
			public void act() {
				GameScreen.result.setText("The door is locked! You must find another exit!");
				GameScreen.game.nextExclusiveChoice(3);
				GameScreen.game.nextChoice(4);
			}
		}));
		// TODO Auto-generated constructor stub
	}

}