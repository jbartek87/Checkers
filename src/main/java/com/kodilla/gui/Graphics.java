package com.kodilla.gui;

import com.kodilla.Game;
import com.kodilla.logic.Board;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Graphics extends Application {
    private Image imageback = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\board.png");
    Image imageWhite = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawnWhite.png");
    Image imageBlack = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawnBlack.png");
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
        for(int col=0; col<8;col++)
            grid.getColumnConstraints().add(new ColumnConstraints(80));
        for(int row=0;row<8;row++)
            grid.getRowConstraints().add(new RowConstraints(80));


        grid.setGridLinesVisible(true);
        grid.setBackground(background);
        grid.setAlignment(Pos.TOP_CENTER);

//        ImageView img = new ImageView(imageWhite);
//        ImageView img2 = new ImageView(image);
//        ImageView img3 = new ImageView(image);
//        ImageView img4 = new ImageView(image);
//        ImageView img5 = new ImageView(image);
//        ImageView img6 = new ImageView(image);
//        ImageView img7 = new ImageView(image);
//        ImageView img8 = new ImageView(image);
//        ImageView img9 = new ImageView(image);
//        ImageView img10 = new ImageView(image);
//        ImageView img11 = new ImageView(image);
//        ImageView img12 = new ImageView(image);


//        grid.add(img, 5,5);
//        grid.add(img2, 2,2,1,1);
//        grid.add(img3, 3,3,1,1);
//        grid.add(img4, 4,4,1,1);


        Scene scene = new Scene(grid, 640, 640, Color.CADETBLUE);

        Board board = new Board();
        board.initBoard();
        Game game = new Game(board, grid);
        game.showBoard();
        grid.setOnMouseClicked(c->{
            System.out.println(c.getX()+" "+ c.getY());
            int x= (int)c.getX()/80;
            int y= (int)c.getY()/80;
            System.out.println(x + " " + y);
            game.doClick(x,y);
        });

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}