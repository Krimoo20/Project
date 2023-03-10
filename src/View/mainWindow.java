/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkarem Homidi
 */
public class mainWindow extends Application {
    public static Stage stage1=null;
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        Parent root=FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
         Scene scene = new Scene(root); 
         stage.setScene(scene);
         stage.show();
        */
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginInterface.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);      
        stage.setScene(scene);
        stage1=stage;
        stage.show();
         
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
