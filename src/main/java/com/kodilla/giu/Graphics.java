package com.kodilla.giu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Graphics extends Application {
    private Image imageback = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\board.png");
    Image image = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawn.png");
    ImageView iv1 = new ImageView();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        iv1.setImage(image);
        iv1.setPreserveRatio(false);

        GridPane grid = new GridPane();

        grid.setBackground(background);


        Scene scene = new Scene(grid, 1600, 900, Color.CORAL);
        grid.getChildren().add(iv1);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
