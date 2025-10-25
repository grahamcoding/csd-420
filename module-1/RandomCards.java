/**
 * Daniel Graham
 * Module 1 JavaFX Card Shuffling
 * 10/25/2025
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class RandomCards extends Application {

    private final ArrayList<Integer> deck = new ArrayList<>();
    private final HBox cardBox = new HBox(10);

    @Override
    public void start(Stage primaryStage) {
        // Fill the deck with values 1–52
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        // Set card display area
        cardBox.setAlignment(Pos.CENTER);
        cardBox.setPadding(new Insets(20));

        // Display initial set of random cards
        drawCards();

        // Create Refresh button using Lambda Expression
        Button refreshBtn = new Button("Refresh");
        refreshBtn.setOnAction(e -> drawCards());

        // Layout
        VBox root = new VBox(20, cardBox, refreshBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Random Card Drawer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Randomly selects and displays 4 cards
    private void drawCards() {
        Collections.shuffle(deck); // Randomize

        cardBox.getChildren().clear(); // Remove old cards

        for (int i = 0; i < 4; i++) {
            String cardPath = "cards/" + deck.get(i) + ".png";
            Image cardImage = new Image(cardPath);
            ImageView cardView = new ImageView(cardImage);
            cardView.setFitWidth(100);
            cardView.setPreserveRatio(true);
            cardBox.getChildren().add(cardView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}