package symposiumProject;

import java.util.ArrayList;

public class Decision {

	private ArrayList<Choice> choices;
	private String description;
	
	public Decision() {
		choices = new ArrayList<Choice>();
	}
	
	public void addChoice(Choice c){
		choices.add(c);
	}

	public ArrayList<Choice> getChoices() {
		return choices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
