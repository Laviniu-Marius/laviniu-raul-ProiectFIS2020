package View;

import Application.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientOverview {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 300, h = 300;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(14);

        Button BookListButton = new Button("Book list");
        GridPane.setConstraints(BookListButton,7,7);

        Button BackButton = new Button("Back");
        GridPane.setConstraints(BackButton,7,10);

        BackButton.setOnAction(e ->{
            Main.window.setScene(LoginClient.draw());
            Main.window.setTitle("Client Login");
        });

      /*  BookListButton.setOnAction(e -> {
            Main.window.setScene(BookListOverview.draw());
            Main.window.setTitle("Book list");
        }); */

        grid.getChildren().addAll(BookListButton,BackButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

}