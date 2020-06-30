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
        int w = 250, h = 50;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(14);

        Button BookListButton = new Button("Book list");
        GridPane.setConstraints(BookListButton,1,1);

        Button BackButton = new Button("Back");
        GridPane.setConstraints(BackButton,2,1);

        BackButton.setOnAction(e ->{
            Main.window.setScene(LoginClient.draw());
            Main.window.setTitle("Client login");
        });

        BookListButton.setOnAction(e -> {
            Main.window.setScene(ClientBookListOverview.draw());
            Main.window.setTitle("Book list");
        });

        grid.getChildren().addAll(BookListButton,BackButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

}