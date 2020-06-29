package View;

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
    static String ret;
    static String[] retS = new String[4];

    public static String[] display(String title, String message)
{
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    Label label = new Label();
    label.setText(message);

    HBox fields = new HBox(10);
    TextField titleField = new TextField();
    TextField authorField = new TextField();
    TextArea contentField = new TextArea();
    fields.getChildren().addAll(titleField,authorField);


    Button okButton = new Button("Ok");

    okButton.setOnAction(e -> {
        //ret = textField.getText();
        if(titleField.getText()!=null && authorField.getText()!=null && contentField.getText()!=null
                && !titleField.getText().equals("")   && !authorField.getText().equals("")  && !contentField.getText().equals("") ) {
            retS[0] = titleField.getText();
            retS[1] = authorField.getText();
            retS[2] = contentField.getText();
            window.close();
        }
        else
        {
            Alert.display("Error","You cannot leave a field empty.");
        }
    });

    window.setOnCloseRequest(e -> {
        retS=null;
    });

    VBox layout = new VBox(10);
    layout.getChildren().addAll(label,fields, contentField,okButton);
    layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    return retS;


}



}