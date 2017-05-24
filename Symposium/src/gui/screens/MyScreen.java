package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableGraphic;
import gui.components.TextArea;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class MyScreen extends Screen implements MouseListener {

	private Button button;
	private ClickableGraphic kitty;
	private boolean changed;

	public MyScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		ImageIcon icon = new ImageIcon("resources/sampleImages/HangInThere.jpg");
		int iconWidth = (int) (icon.getIconWidth());
		int iconHeight = (int) (icon.getIconHeight());
		kitty = new ClickableGraphic(0, 0, iconWidth, iconHeight, "resources/sampleImages/HangInThere.jpg");
		kitty.setAction(new Action() {
			public void act() {
				changed = !changed;
				kitty.loadImages(
						changed ? "resources/sampleImages/Springtrap.jpg" : "resources/sampleImages/HangInThere.jpg", 0,
						0);
			}
		});
		viewObjects.add(kitty);
		button = new Button(50, 50, 100, 100, "BTHS", Color.blue, new Action() {
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.cs);
			}
		});
		viewObjects.add(button);
	}

	public void mouseClicked(MouseEvent e) {
		if (button.isHovered(e.getX(), e.getY())) {
			button.act();
		}

		if (kitty.isHovered(e.getX(), e.getY())) {
			kitty.act();
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

	public MouseListener getMouseListener() {
		return this;
	}

}
