/** Author: Helen Lily Hu */
package graphics;

import javafx.scene.canvas.GraphicsContext;

/** An instance represents a pixelated image */
public abstract class PixelImage {

	/** Side length of square pixel */
	double pixelSize;

	/** x coordinate of top left corner */
	double xPos;

	/** y coordinate of top left corner */
	double yPos;

	/** Internal timer for pacing movement */
	int timer;

	/** Constructor: initializes image with pixel side length pixelSize <br>
	 * and with its top left corner at point (x,y) */
	public PixelImage(double pixelSize, double x, double y) {
		this.pixelSize= pixelSize;
		xPos= x;
		yPos= y;
	}

	/** Get x-coordinate of image's top left corner */
	public double getX() {
		return xPos;
	}

	/** Set x-coordinate of image's top left corner to x */
	public void setX(double x) {
		xPos= x;
	}

	/** Get y-coordinate of image's top left corner */
	public double getY() {
		return yPos;
	}

	/** Set y-coordinate of image's top left corner to y */
	public void setY(double y) {
		yPos= y;
	}

	/** Moves image by one pixelSize */
	public abstract void move();

	/** Draws image to graphics context gc */
	public abstract void draw(GraphicsContext gc);

	/** Returns length of image */
	public abstract double getLength();

}
