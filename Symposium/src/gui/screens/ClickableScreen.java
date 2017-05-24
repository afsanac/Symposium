package gui.screens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import gui.Screen;
import gui.components.Clickable;
import gui.components.Visible;

public abstract class ClickableScreen extends Screen implements MouseListener {

	private ArrayList<Clickable> clickables;

	public ClickableScreen(int width, int height) {
		super(width, height);
	}

	public void mouseClicked(MouseEvent e) {
		for (Clickable c : clickables) {
			if (c.isHovered(e.getX(), e.getY())) {
				c.act();
				break;
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for (Visible v : viewObjects) {
			if (v instanceof Clickable) {
				clickables.add((Clickable) v);
			}
		}
	}

	public abstract void initAllObjects(ArrayList<Visible> viewObjects);

	public MouseListener getMouseListener() {
		return this;
	}

	public void addObject(Visible v) {
		super.addObject(v);
		if (v instanceof Clickable) {
			clickables.add((Clickable) v);
		}
	}

	public void remove(Visible v) {
		super.remove(v);
		clickables.remove(v);
	}

	public void moveToBack(ArrayList<Visible> viewObjects, Visible v) {
		if (viewObjects.contains(v)) {
			viewObjects.remove(v);
			// the "back" is index 0
			viewObjects.add(0, v);
			// this moves everything else forward in the list
		}
	}

	public void moveToFront(ArrayList<Visible> viewObjects, Visible v) {
		if (viewObjects.contains(v)) {
			viewObjects.remove(v);
			viewObjects.add(v);
			
		}
	}

}
