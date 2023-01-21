/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package View;

import static View.mainWindow.stage1;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dataBaseHandeler.dataBaseConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




/**
 * FXML Controller class
 *
 * @author Abdelkarem Homidi
 */
public class LoginInterfaceController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label part1;
    @FXML
    private Label part2;
    @FXML
    private Label part21;
    Connection conn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAccount(ActionEvent event)throws IOException,Exception {
        String inputUser=username.getText();
        String inputPassword=password.getText();
        String userdata=null;
        String passworddata=null;
        if(username.getText().equals("")||password.getText().equals("")){
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(2), e -> part1.setVisible(false)));
         part1.setVisible(true);
         timeline1.play();
         Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(2), e -> part2.setVisible(false)));
         part2.setVisible(true);
         timeline2.play();
            return;
        }
        conn = dataBaseConnection.ConnectDb();
        String query="SELECT * FROM users WHERE username = ? AND password = ?;";
       try {
            pst =(PreparedStatement)conn.prepareStatement(query);
            pst.setString(1, inputUser);
            pst.setString(2, inputPassword);
            rs=pst.executeQuery();
             while(rs.next()){
                     userdata=rs.getString("username");
                     passworddata=rs.getString("password");
                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        if(inputUser.equals(userdata)&& inputPassword.equals(passworddata)){
             try{
             Parent parent =FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
             Stage stage=new Stage(StageStyle.DECORATED);
             stage.setTitle("mainDashborad");
             stage.setScene(new Scene(parent));
             stage.show();
                stage1.close();
             
        } catch (IOException ex) {
              Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
          }
       }else{
         Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(2), e -> part1.setVisible(false)));
         part1.setVisible(true);
         timeline1.play();
         Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(2), e -> part2.setVisible(false)));
         part2.setVisible(true);
         timeline2.play(); 
       }
    } 
    

}
