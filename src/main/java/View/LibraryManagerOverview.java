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
        int w = 300, h = 300;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(14);

        Button BackButton = new Button("Back");
        GridPane.setConstraints(BackButton,7,16);

        BackButton.setOnAction(e ->{
            Main.window.setScene(LoginLibraryManager.draw());
            Main.window.setTitle("Manager Login");
        });

        grid.getChildren().addAll(BackButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

}