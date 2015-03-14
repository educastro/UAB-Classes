package lab09;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
  A class for labeled points
 */
@SuppressWarnings("serial")
public class LabeledRectangle extends Rectangle {

	private String text;

	/**
      Constructs a LabeledRectangle object
      @param x is the point x where the rectangle should be
      @param y is the point y where the rectangle should be
      @param width is the width size of the rectangle
      @param height is the height size of the rectangle
      @param text is the string that will be printed inside the rectangle
	 */
	public LabeledRectangle(int x, int y, int width, int height, String text) {
		super(x, y, width, height);
		this.text = text;
	}

	/**
      Draws the rectangle
      @param g is the graph object that will be used for printing the rectangle
	 */
	public void draw(Graphics g) {
		/**
		 * The following two lines prints the rectangle as a Graphic2D component. It uses the
		 * variables initialized by the class constructor.
		 */
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Rectangle2D.Double(this.x, this.y, this.width, this.height));

		/**
		 * The following lines takes the text passed as parameter for the constructor, discover
		 * its sizes and calculates where it should be in order to be placed in the center of the
		 * rectangle.
		 */
		Font fontText = g2.getFont();
		FontRenderContext fontTextContainer = g2.getFontRenderContext();
		Rectangle2D textBox = fontText.getStringBounds(text, fontTextContainer);

		double ascent = -textBox.getY();
		double advance = textBox.getWidth();
		double h = textBox.getHeight() - ascent;

		double shiftX = (float)(this.x + (super.getWidth() - advance) / 2);
		double shiftY = (float)(this.y + (ascent + super.getHeight() - (h)) / 2);

		//double shiftX = (float)(this.x + (super.getWidth() - advance) / 2);
		//double shiftY = (float)(this.y + (ascent) + (super.getHeight() - (extent))/2);

		g2.drawString(text, (int) shiftX, (int) shiftY);
	}
}