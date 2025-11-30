/**
 * Daniel Graham
 * Module: 7 - JavaFX CSS and Shapes
 * 11/30/2025
 */
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Module7Circles extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create four circles
        Circle c1 = new Circle(50);
        Circle c2 = new Circle(50);
        Circle c3 = new Circle(50);
        Circle c4 = new Circle(50);

        // Apply style class to all circles
        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        c3.getStyleClass().add("plaincircle");
        c4.getStyleClass().add("plaincircle");

        // Assign IDs for color
        c2.setId("redcircle");
        c3.setId("greencircle");

        // Optional: extra style class
        c4.getStyleClass().add("circleborder");

        // Layout container
        HBox root = new HBox(20);
        root.getChildren().addAll(c1, c2, c3, c4);
        root.getStyleClass().add("border");

        // Create scene and apply external CSS
        Scene scene = new Scene(root, 400, 200);
        scene.getStylesheets().add("mystyle.css");

        // Stage setup
        primaryStage.setTitle("Module 7 Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Simple test code to confirm style assignments */
    private void runTests(Circle c1, Circle c2, Circle c3) {
        System.out.println("TESTING STYLE ASSIGNMENTS...");
        System.out.println("Circle 1 classes: " + c1.getStyleClass());
        System.out.println("Circle 2 ID: " + c2.getId());
        System.out.println("Circle 3 ID: " + c3.getId());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
