package View;

import Application.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LibraryManagerOverview {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 303, h = 50;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(14);

        Button BookListButton = new Button("Book list");
        GridPane.setConstraints(BookListButton,1,1);

        Button BackButton = new Button("Back");
        GridPane.setConstraints(BackButton,2,1);

        BackButton.setOnAction(e ->{
            Main.window.setScene(LoginLibraryManager.draw());
            Main.window.setTitle("Manager login");
        });

        BookListButton.setOnAction(e -> {
            Main.window.setScene(BookListOverview.draw());
            Main.window.setTitle("Book list");
        });

        grid.getChildren().addAll(BookListButton,BackButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

}