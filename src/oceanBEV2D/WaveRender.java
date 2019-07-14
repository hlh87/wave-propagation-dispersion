/** Author: Helen Lily Hu */
package oceanBEV2D;

import java.util.Iterator;
import java.util.LinkedList;

import graphics.Albatross;
import graphics.PixelImage;
import graphics.Whale;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** An instance handles rendering waves in 2D to a graphics context <br>
 * Also renders other wave-adjacent accessories as needed */
public class WaveRender {

	/** Updates pixels every frame */
	private AnimationTimer animation;

	/** Changes and records time value for wave math */
	private double timer;

	/** Calculates wave color for each pixel */
	private WaveMath wm;

	/** Side length of square pixel */
	private double pixelSize;

	/** Contains whales currently being rendered on screen */
	private LinkedList<Whale> fish;

	/** Contains birds currently being rendered on screen */
	private LinkedList<Albatross> birds;

	/** Constructor: initializes WaveRender that draws to square canvas <br>
	 * associated with GraphicsContext gc and with side length screenSize <br>
	 * Draws pixelPerSide^2 "pixels" total */
	public WaveRender(GraphicsContext gc, double screenSize, int pixelsPerSide) {
		// initialize WaveMath to calculate wave color in animation
		wm= new WaveMath(10, 1, 0.9);
		// make pixelsPerSide x pixelsPerSide pixels
		pixelSize= screenSize / pixelsPerSide;
		// initialize graphics
		fish= new LinkedList<>();
		fish.add(new Whale(pixelSize, pixelSize * (int) (Math.random() * 100), pixelSize * 100));
		birds= new LinkedList<>();
		birds.add(new Albatross(pixelSize, pixelSize * -15, pixelSize * (int) (Math.random() * 100)));
		// animate waves and animals
		animation= new AnimationTimer() {

			@Override
			public void handle(long now) {
				// draw waves
				for (int x= 0; x < pixelsPerSide; x++ ) {
					// get x coordinate of pixel's top left corner
					double xLeft= x * pixelSize;
					for (int y= 0; y < pixelsPerSide; y++ ) {
						// get y coordinate of pixel's top left corner
						double yLeft= y * pixelSize;

						// get pixel color
						double elevation= wm.calcElevation(xLeft, yLeft, timer);
						Color pixelColor= detColor(elevation);
						gc.setFill(pixelColor);

						// fill pixel
						gc.fillRect(xLeft, yLeft, pixelSize, pixelSize);
					}
				}

				// increment wave time -> consider possibility of reaching Double.MAX_VALUE and needing to loop
				timer+= 0.01;

				handleGraphics(gc);
			}
		};
	}

	/** Starts animating waves */
	public void startAnimation() {
		animation.start();
	}

	/** Determine pixel color (in a blue range) depending on wave elevation */
	private Color detColor(double elevation) {
		double normalization= elevation / (wm.getAmplitude() * 4); // tetrachromatic wave
		// calc rgb color components
		double b= Math.pow(0.1 * normalization + 0.9, 4);
		double g= Math.pow(0.25 * normalization + 0.75, 4);
		double r= Math.pow(0.5 * normalization + 0.5, 4);

		return new Color(r, g, b, 1.0);
	}

	/** Initialize, move and draw non-water graphics */
	private void handleGraphics(GraphicsContext gc) {
		// possibly initialize new animals
		double rf= Math.random();
		if (rf < 0.002) {
			fish.add(new Whale(pixelSize, pixelSize * (int) (Math.random() * 100), pixelSize * 100));
		} else if (rf > 0.997) {
			birds.add(new Albatross(pixelSize, pixelSize * -15, pixelSize * (int) (Math.random() * 100)));
		}

		// handle whales first so they're drawn under birds
		for (Iterator<Whale> i= fish.iterator(); i.hasNext();) {
			// using iterator so animals list can be modified while iterating
			PixelImage w= i.next();

			// if animal has exited screen, remove animal from animals list
			if (w.getY() + w.getLength() < 0) {
				i.remove();
			}

			// move graphics
			w.move();

			// draw graphics
			w.draw(gc);
		}

		// handle birds
		for (Iterator<Albatross> i= birds.iterator(); i.hasNext();) {
			// using iterator so animals list can be modified while iterating
			PixelImage a= i.next();

			// if animal has exited screen, remove animal from animals list
			if (a.getY() + a.getLength() < 0) {
				i.remove();
			}

			// move graphics
			a.move();

			// draw graphics
			a.draw(gc);
		}
	}

}
