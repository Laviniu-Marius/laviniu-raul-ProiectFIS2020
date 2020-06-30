package View;

import Application.Main;
import Controllers.BookController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientBookListOverview {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 400, h = 400;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(14);

        ListView<String> listView=new ListView<String>();
        ObservableList list = FXCollections.observableArrayList();
        list.clear();
        BookController.readBooks();
        for(Book b:BookController.bookList)
        {
            list.add(b.getTitle());
        }

        listView.getItems().clear();
        listView.getItems().addAll(list);
        GridPane.setConstraints(listView,1,1);

        Button BackButton = new Button("Back");
        GridPane.setConstraints(BackButton,1,3);

        Button ViewButton = new Button("View");
        GridPane.setConstraints(ViewButton,2,3);

        BackButton.setOnAction(e ->{
            Main.window.setScene(ClientOverview.draw());
            Main.window.setTitle("Client overview");
        });

        grid.getChildren().addAll(listView,BackButton,ViewButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

}