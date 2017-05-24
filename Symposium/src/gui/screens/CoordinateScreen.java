package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener {

	private Button button;
	private TextLabel text;
	private TextArea area;
	private Graphic springtrap;

	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		springtrap = new Graphic(0, 0, "resources/sampleImages/Springtrap.jpg");
		viewObjects.add(springtrap);
		text = new TextLabel(20, 200, 500, 40, "Some text");
		viewObjects.add(text);
		area = new TextArea(20, 300, 500, 100,
				"This is really long text. It prints over multiple lines, as you can see. We worked on this in class. "
						+ "It is called TextArea");
		viewObjects.add(area);
		button = new Button(20, 100, 80, 40, "Button", Color.red, new Action() {
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		viewObjects.add(button);
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		int mx = e.getX(); // get mouse X coordinate
		int my = e.getY(); // get mouse Y coordinate
		text.setText("Mouse at: " + mx + "," + my);
	}

	public MouseMotionListener getMouseMotionListener() {
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (button.isHovered(e.getX(), e.getY())) {
			button.act();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public MouseListener getMouseListener() {
		return this;
	}

}