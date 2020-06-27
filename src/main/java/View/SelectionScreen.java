package View;

import Application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;


public class SelectionScreen {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 400, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Button ClientButton = new Button("Client");
        GridPane.setConstraints(ClientButton,7,7);

        Button LibraryManagerButton = new Button("Library manager");
        GridPane.setConstraints(LibraryManagerButton,10,7);

        ClientButton.setOnAction(e -> {
            Main.window.setScene(LoginClient.draw());
            Main.window.setTitle("Client Login");
        });
        LibraryManagerButton.setOnAction(e -> {
            Main.window.setScene(LoginLibraryManager.draw());
            Main.window.setTitle("Manager Login");
        });

        grid.getChildren().addAll(ClientButton,LibraryManagerButton);
        Scene scene = new Scene(grid,w,h);
        return scene;

    }


}