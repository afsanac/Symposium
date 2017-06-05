package symposiumProject;

public class Player implements Character {
	boolean alive;
	boolean injured;

	public Player() {
		alive = true;
		injured = false;
	}

	
	@Override
	public void kill() {
		alive = false;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}


	@Override
	public void injure() {
		injured = true;
		
	}


	@Override
	public boolean isInjured() {
		return injured;
	}

}
