package View;

import Application.Main;
import Objects.Book;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ClientOverview {



    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 300, h = 300;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(14);

        Button BackButton = new Button("Back");
        GridPane.setConstraints(BackButton,7,13);

        BackButton.setOnAction(e ->{
            Main.window.setScene(LoginClient.draw());
            Main.window.setTitle("Client Login");
        });

        grid.getChildren().addAll(BackButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

}