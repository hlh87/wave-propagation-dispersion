/** Author: Helen Lily Hu */
package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** An instance represents a pixel albatross */
public class Albatross extends PixelImage {

	public Albatross(double pixelSize, double x, double y) {
		super(pixelSize, x, y);
	}

	/** Moves image across the screen by one pixelSize every 3 calls */
	@Override
	public void move() {
		if (timer == 2) {
			// move image
			xPos+= pixelSize;
			timer= 0;

		}
		timer+= 1;

	}

	@Override
	public void draw(GraphicsContext gc) {
		// grey in tail, body, and head
		gc.setFill(Color.DARKGRAY);
		gc.fillRect(xPos, yPos + pixelSize * 11, pixelSize, pixelSize * 7);
		gc.fillRect(xPos + pixelSize, yPos + pixelSize * 12, pixelSize, pixelSize * 5);
		gc.fillRect(xPos + pixelSize * 2, yPos + pixelSize * 13, pixelSize * 2, pixelSize * 3);
		gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 12, pixelSize * 2, pixelSize * 5);
		gc.fillRect(xPos + pixelSize * 10, yPos + pixelSize * 13, pixelSize * 3, pixelSize * 3);

		// white in body and head
		gc.setFill(Color.WHITE);
		gc.fillRect(xPos + pixelSize * 4, yPos + pixelSize * 13, pixelSize * 2, pixelSize * 3);
		gc.fillRect(xPos + pixelSize * 10, yPos + pixelSize * 14, pixelSize * 3, pixelSize);

		// beak
		gc.setFill(Color.CORAL);
		gc.fillRect(xPos + pixelSize * 13, yPos + pixelSize * 14, pixelSize * 2, pixelSize);

		// black in tail and wings
		gc.setFill(Color.BLACK);
		gc.fillRect(xPos, yPos + pixelSize * 13, pixelSize, pixelSize * 3);
		gc.fillRect(xPos + pixelSize, yPos + pixelSize * 14, pixelSize, pixelSize);
		gc.fillRect(xPos + pixelSize * 6, yPos, pixelSize, pixelSize);
		gc.fillRect(xPos + pixelSize * 6, yPos + pixelSize * 12, pixelSize, pixelSize * 5);
		gc.fillRect(xPos + pixelSize * 6, yPos + pixelSize * 28, pixelSize, pixelSize);
		gc.fillRect(xPos + pixelSize * 7, yPos, pixelSize, pixelSize * 4);
		gc.fillRect(xPos + pixelSize * 7, yPos + pixelSize * 7, pixelSize, pixelSize * 15);
		gc.fillRect(xPos + pixelSize * 7, yPos + pixelSize * 25, pixelSize, pixelSize * 4);
		gc.fillRect(xPos + pixelSize * 8, yPos + pixelSize, pixelSize, pixelSize * 27);
		gc.fillRect(xPos + pixelSize * 9, yPos + pixelSize * 2, pixelSize, pixelSize * 25);
		gc.fillRect(xPos + pixelSize * 10, yPos + pixelSize * 4, pixelSize, pixelSize * 5);
		gc.fillRect(xPos + pixelSize * 10, yPos + pixelSize * 20, pixelSize, pixelSize * 5);
	}

	/** Returns (x-axis) length of albatross */
	@Override
	public double getLength() {
		return pixelSize * 15;
	}

}
