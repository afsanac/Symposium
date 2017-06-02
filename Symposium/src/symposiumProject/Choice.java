package symposiumProject;

import gui.components.Action;

public class Choice {
	
	private String description;
	private Action result;
	
	public Choice(String option1, Action result1){
		this.description = option1;
		this.result = result1;
	}

	public String getDescription() {
		return description;
	}

	public Action getResult() {
		return result;
	}
	
	
}
