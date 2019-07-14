/** Author: Helen Lily Hu */
package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** An instance represents an underwater pixel whale */
public class Whale extends PixelImage {

	/** Number of the frame currently being drawn */
	private int frame;

	public Whale(double pixelSize, double x, double y) {
		super(pixelSize, x, y);
	}

	/** Moves image up the screen by one pixelSize every 20 calls <br>
	 * Also increment frame every 20 calls */
	@Override
	public void move() {
		if (timer == 19) {
			// move image
			yPos-= pixelSize;
			timer= 0;

			// increment frame
			if (frame == 3) {
				frame= 1;
			} else {
				frame+= 1;
			}
		}
		timer+= 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// set color attributes
		gc.setFill(Color.BLACK);
		gc.setGlobalAlpha(0.5);

		// draw whale
		// body
		gc.fillRect(xPos + pixelSize * 8, yPos, pixelSize * 2, pixelSize);
		gc.fillRect(xPos + pixelSize * 7, yPos + pixelSize, pixelSize * 4, pixelSize * 3);
		gc.fillRect(xPos + pixelSize * 6, yPos + pixelSize * 4, pixelSize * 6, pixelSize * 14);
		gc.fillRect(xPos + pixelSize * 7, yPos + pixelSize * 18, pixelSize * 4, pixelSize * 2);
		gc.fillRect(xPos + pixelSize * 8, yPos + pixelSize * 20, pixelSize * 2, pixelSize * 2);
		// animate fins and tail
		if (frame == 1) {
			// left fin
			gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 9, pixelSize * 2, pixelSize);
			gc.fillRect(xPos + pixelSize * 2, yPos + pixelSize * 10, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize, yPos + pixelSize * 11, pixelSize * 4, pixelSize);
			gc.fillRect(xPos, yPos + pixelSize * 12, pixelSize * 3, pixelSize);
			gc.fillRect(xPos, yPos + pixelSize * 13, pixelSize * 2, pixelSize);
			// right fin
			gc.fillRect(xPos + pixelSize * 12, yPos + pixelSize * 9, pixelSize * 2, pixelSize);
			gc.fillRect(xPos + pixelSize * 12, yPos + pixelSize * 10, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 13, yPos + pixelSize * 11, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 15, yPos + pixelSize * 12, pixelSize * 3, pixelSize);
			gc.fillRect(xPos + pixelSize * 16, yPos + pixelSize * 13, pixelSize * 2, pixelSize);

			// tail
			gc.fillRect(xPos + pixelSize * 6, yPos + pixelSize * 22, pixelSize * 6, pixelSize);
			gc.fillRect(xPos + pixelSize * 5, yPos + pixelSize * 23, pixelSize * 8, pixelSize);
			gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 24, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 10, yPos + pixelSize * 24, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 3, yPos + pixelSize * 25, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 11, yPos + pixelSize * 25, pixelSize * 4, pixelSize);
		} else if (frame == 2) {
			// left fin
			gc.fillRect(xPos + pixelSize * 2, yPos + pixelSize * 9, pixelSize * 4, pixelSize);
			gc.fillRect(xPos, yPos + pixelSize * 10, pixelSize * 6, pixelSize);
			gc.fillRect(xPos, yPos + pixelSize * 11, pixelSize * 3, pixelSize);
			gc.fillRect(xPos, yPos + pixelSize * 12, pixelSize * 2, pixelSize);

			// right fin
			gc.fillRect(xPos + pixelSize * 12, yPos + pixelSize * 9, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 12, yPos + pixelSize * 10, pixelSize * 6, pixelSize);
			gc.fillRect(xPos + pixelSize * 15, yPos + pixelSize * 11, pixelSize * 3, pixelSize);
			gc.fillRect(xPos + pixelSize * 16, yPos + pixelSize * 12, pixelSize * 2, pixelSize);

			// tail
			gc.fillRect(xPos + pixelSize * 5, yPos + pixelSize * 22, pixelSize * 8, pixelSize);
			gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 23, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 10, yPos + pixelSize * 23, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 3, yPos + pixelSize * 24, pixelSize * 4, pixelSize);
			gc.fillRect(xPos + pixelSize * 11, yPos + pixelSize * 24, pixelSize * 4, pixelSize);
		} else {
			// frame == 3
			// left fin
			gc.fillRect(xPos + pixelSize * 5, yPos + pixelSize * 9, pixelSize, pixelSize);
			gc.fillRect(xPos + pixelSize * 3, yPos + pixelSize * 10, pixelSize * 3, pixelSize * 2);
			gc.fillRect(xPos + pixelSize * 2, yPos + pixelSize * 12, pixelSize * 3, pixelSize * 3);
			gc.fillRect(xPos + pixelSize * 3, yPos + pixelSize * 15, pixelSize * 2, pixelSize);
			gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 16, pixelSize, pixelSize);

			// right fin
			gc.fillRect(xPos + pixelSize * 12, yPos + pixelSize * 9, pixelSize, pixelSize);
			gc.fillRect(xPos + pixelSize * 12, yPos + pixelSize * 10, pixelSize * 3, pixelSize * 2);
			gc.fillRect(xPos + pixelSize * 13, yPos + pixelSize * 12, pixelSize * 3, pixelSize * 3);
			gc.fillRect(xPos + pixelSize * 13, yPos + pixelSize * 15, pixelSize * 2, pixelSize);
			gc.fillRect(xPos + pixelSize * 13, yPos + pixelSize * 16, pixelSize, pixelSize);

			// tail
			gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 22, pixelSize * 10, pixelSize);
			gc.fillRect(xPos + pixelSize * 3, yPos + pixelSize * 23, pixelSize * 12, pixelSize);
		}

		// restore global opacity
		gc.setGlobalAlpha(1.0);
	}

	/** Returns (y-axis) length of whale */
	@Override
	public double getLength() {
		return pixelSize * 26;
	}

}
