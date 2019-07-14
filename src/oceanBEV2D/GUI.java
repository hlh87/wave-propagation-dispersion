/** Author: Helen Lily Hu
 * Date: 7/9/19 - 7/13/19*/
package oceanBEV2D;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI extends Application {

	/** Launches the application */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// get screen dimensions to create scene
		Rectangle2D screenSize= Screen.getPrimary().getVisualBounds();
		double smolDim= Math.min(screenSize.getHeight(), screenSize.getWidth());

		// initialize assets
		Canvas canvas= new Canvas(smolDim, smolDim);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		// 100 pixels per side are best for ocean aesthetic -> other numbers are interesting but different
		WaveRender wr= new WaveRender(gc, smolDim, 100);

		// create layout manager
		Pane root= new Pane();
		root.getChildren().add(canvas);

		Scene scene= new Scene(root, smolDim, smolDim, Color.CORNFLOWERBLUE);
		primaryStage.setTitle("Experimental Bird's Eye View of an Ocean (2D)");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		// start animating
		wr.startAnimation();
	}

}
