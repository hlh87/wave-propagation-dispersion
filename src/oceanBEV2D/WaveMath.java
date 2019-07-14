/** Author: Helen Lily Hu */
package oceanBEV2D;

/** An instance handles math for calculating wave surface elevation <br>
 * (for a tetrachromatic wave group of full modulation) */
public class WaveMath {

	/** Wave amplitude of all wave components */
	private double amplitude;

	/** Wave number (waves/distance) for first wave component */
	private double k1;

	/** Wave number (waves/distance) for second wave component */
	private double k2;

	/** Constructor: initializes WaveMath with two customizable waves of amplitude a<br>
	 * and wave numbers k1 and k2 <br>
	 * Two default waves are preprogrammed in for overall aesthetic */
	public WaveMath(double a, double k1, double k2) {
		amplitude= a;
		this.k1= k1;
		this.k2= k2;
	}

	/** Return wave amplitude of all wave components */
	public double getAmplitude() {
		return amplitude;
	}

	/** Calculates the surface elevation of a wave based on position (xPos, yPos) <br>
	 * and time t */
	public double calcElevation(double xPos, double yPos, double time) {
		return calcElevationComponent(k1, xPos, yPos, time) +
			calcElevationComponent(k2, xPos, yPos, time) +
			elevationTexture(xPos, yPos, time);
	}

	/** Calculates the surface elevation contributed by a wave component with <br>
	 * wave number k <br>
	 * Satisfies dispersion relation for deep water based on linear wave theory */
	private double calcElevationComponent(double k, double xPos, double yPos, double time) {
		// phase function only dependent on y-coordinate
		double phaseFunction= k * yPos - Math.sqrt(9.8 * k) * time;
		// x-coord-dependent texture element for better row-level "wave" shape
		double texture= Math.sin(0.030 * xPos) + 3 * Math.sin(0.015 * xPos);
		return amplitude * Math.sin(phaseFunction - texture);
	}

	/** Adds two more default wave component surface elevations to increase variation <br>
	 * in the overall wave appearance. Both components have wave number 0.01. */
	private double elevationTexture(double x, double y, double time) {
		double phaseFunction1= 0.01 * (2 * x + y) - Math.sqrt(9.8 * 0.01) * time;
		double phaseFunction2= 0.01 * x - Math.sqrt(9.8 * 0.01) * time;
		return amplitude * (Math.sin(phaseFunction1) + Math.sin(phaseFunction2));
	}
}
