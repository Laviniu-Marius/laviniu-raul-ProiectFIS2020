package View;

import Application.Main;
import Objects.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;

public class LoginLibraryManager {
    private static int ok=0;
    static Users[]  Admin=null;
    public static Scene draw()
    {
        int w = 350, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput,1,0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);


        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,1,2);
        Button SelectScreenButton = new Button("Back");
        GridPane.setConstraints(SelectScreenButton,1,3);
        SelectScreenButton.setOnAction(e -> {
            Main.window.setScene(SelectionScreen.draw());
            Main.window.setTitle("Selection Screen");
        });

        File file = new File("Accounts.JSON");
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            Admin = objectMapper.readValue(file, Users[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginButton.setOnAction(e -> {
            for (Users x : Admin) {
                if ((x.getUser().equals(nameInput.getText())) && (x.getPw().equals(Integer.toString(passInput.getText().hashCode())))) {
                    ok = 1;
                }

            }
            if (ok == 1 && (nameInput.getText().equals("admin"))) {

                Main.window.setScene(LibraryManagerOverview.draw());
                Main.window.setTitle("Admin Overview");
                ok=0;
            }

            else {
                Alert.display("Error","The username, the password or both are wrong.");

            }
        });


        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,SelectScreenButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }
}