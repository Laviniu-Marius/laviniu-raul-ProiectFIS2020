package Application;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import View.SelectionScreen;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application  {

    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;

        primaryStage.setTitle("Selection Screen");
        primaryStage.setScene(SelectionScreen.draw());
        primaryStage.show();

       /* String s=new String("admin");
        System.out.println(s.hashCode()); */
    }

}