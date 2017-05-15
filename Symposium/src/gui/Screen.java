package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import gui.components.Visible;

public abstract class Screen {
	
	private int width;
	private int height;
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;


	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		this.width = width;
		this.height = height;
		initObjects(viewObjects);
		initImage();
	}

	public abstract void initObjects(ArrayList<Visible> viewObjects);

	private void initImage() {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}

	public BufferedImage getImage(){
		return image;
	}

	public int getWidth(){
		return image.getWidth();
	}

	public int getHeight(){
		return image.getHeight();
	}

	public void update() {
		//this is where you draw stuff
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		//make background
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		//draw all visible components
		for(int i = 0; i < viewObjects.size(); i++){
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
		//		g.setFont(new Font("Helvetica",Font.PLAIN,20));
		//		g.drawString("Hello",	 40, 80);
		//		g.drawOval(0, 40, 120, 80);
		//		g.drawRect(20, 120, 80, 110);
		//		g.drawLine(100, 120, 110, 200);
		//		
		//		g.setColor(Color.green);
		//		for(int i = 0; i < image.getWidth(); i+=4){
		//			g.drawLine(i, 230, i, 238);
		//		

	}

	
	//represents ABILITY to listen to mouse
	//but isn't actually doing something
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	
	public MouseListener getMouseListener(){
		return null;
	}
	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void remove(Visible v){
		
		/**
		 * Note: in this implementation, we have a very simple command: remove(v)
		 * however, remove is sorta a big deal on the AP EXAM: Here's why:
		 * 
		 * When an object is removed from a List, every other object is moved up in order.
		 * Therefore, all of their respective indices change. You MUST, MUST MUST be aware of this.
		 * 
		 * Here is a CLASSSSSIC example:
		 * 
		 * The following in WRONG
		 * suppose you have a List<Integer> with {4,8,7,1}
		 * and you want to remove all Integers greater than 5.
		 * You do this:
		 * for(int i = 0; i < list.size(); i++{
		 * if(list.get(i) > 5 list.remove(i)
		 * }
		 * 
		 * YOU FAILLLLLLLLLL
		 * 
		 *  Why do you fail?
		 * i = 0, nothing changes
		 * i = 1, , the '8' is removed
		 * 
		 * now we have:
		 * {4,7,1}
		 * 
		 * THESE TWO WAYS ARE CORRECT:
		 * 
		 * for(int i = 0; i < list.size(); i++){
		 * if(list.get(i) > 5 list.remove(i)
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ONE MORE NOTE:
		 * if you call list.remove(int) will return the object being removed at that index
		 * 
		 * 
		 */
		
		viewObjects.remove(v);
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			// the "back" us index 0
			viewObjects.add(0, v);
			// this moves everything else forward in the list
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}
	
	
	
	
}

	
