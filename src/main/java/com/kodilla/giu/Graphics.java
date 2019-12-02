package com.kodilla.giu;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Graphics extends Application {
    private Image imageback = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\board.png");
    Image image = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawn.png");
    private FlowPane images = new FlowPane(Orientation.HORIZONTAL);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);
        grid.setBackground(background);

        ImageView img = new ImageView(image);
        ImageView img2 = new ImageView(image);

        img.setPreserveRatio(true);



        images.getChildren().add(img);
        images.getChildren().add(img2);

        grid.add(images, 0,0,3,1);
        Scene scene = new Scene(grid, 1600, 900, Color.CADETBLUE);


        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
