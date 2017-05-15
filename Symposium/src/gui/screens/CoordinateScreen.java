package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.MovingComponents;
import gui.components.TextArea;
import gui.sampleGames.MouseFollower;

public class CoordinateScreen extends Screen  implements MouseMotionListener, MouseListener{

	//FIELD
	private Button button;
	private TextLabel text;
	private TextArea area;
	private Graphic bowser;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<Visible> viewObjects) {

		text = new TextLabel(20, 200, 500, 40, "Still hungry");
		
		viewObjects.add(text);
		area = new TextArea(20, 250, 500, 100, "hello there, I'm hungry");
		viewObjects.add(area);
		
		bowser = new Graphic(30,30,.5, "resources/sampleImages/cat.jpg"); 
		viewObjects.add(bowser);
		
		MovingComponents c = new MovingComponents(20, 20, 100, 100);
		viewObjects.add(c);
		c.setVy(2);
		c.setVy(1);
		c.play();
		
		
		
		button = new Button(40,50,100,30,"Button",new Color(0,76,153), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		
		
		viewObjects.add(button);
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get mouse X coordinate
		int my = e. getY();//get Y coord
		text.setText("Mouse at: "+mx +", "+my);
	}

	public MouseMotionListener getMouseMotionListener(){ 
		return this;
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		if(button.isHovered(m.getX(), m.getY()));
		button.act();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
