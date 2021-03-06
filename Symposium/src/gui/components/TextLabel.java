package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextLabel extends Component {

	private String text;
	private Font font;
	private int size;

	public TextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h);
		this.text = text;
		this.font = new Font("Helvetica", Font.PLAIN,20);
		
		this.size = 20;
		update();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		update();
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
		update();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		update();
	}

	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		drawText(g);
	}

	protected void drawText(Graphics2D g) {
		g.setColor(Color.red);
		g.setFont(font);
		if (text != null) {
			g.drawString(text, 4, getHeight() - 5);
		}
	}



}
