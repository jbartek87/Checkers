package com.kodilla.gui;

import com.kodilla.Game;
import com.kodilla.logic.Board;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Graphics extends Application {
    private Image imageback = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\board2.jpg");

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
