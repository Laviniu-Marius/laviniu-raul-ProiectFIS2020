package View;

import Controllers.BookController;
import Objects.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class BookContentOverview
{
    public static void display(String titleBook)
    {
        Book bk = BookController.getBook(titleBook);
        String title, author, content;
        title = bk.getTitle();
        author = bk.getAuthor();
        content = bk.getContent();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);

        Label titleLabel = new Label();
        titleLabel.setText("Title: " + title);
        Label authorLabel = new Label();
        authorLabel.setText("Author: " + author);
        Label contentLabel = new Label();
        contentLabel.setWrapText(true);
        contentLabel.setText(content);


        HBox trick=new HBox();

        Button okButton = new Button("Ok");
        trick.setAlignment(Pos.CENTER);
        trick.getChildren().addAll(okButton);
        okButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(titleLabel,authorLabel, contentLabel,trick);
        layout.setAlignment(Pos.CENTER_LEFT);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }



}