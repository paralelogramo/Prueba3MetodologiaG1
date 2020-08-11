/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebag1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus-ROG
 */
public class FXMLDocument2Controller implements Initializable {
    @FXML
    AnchorPane ap;

    @FXML
    private void cerrar() throws IOException{
            FXMLLoader loader = new FXMLLoader();
            URL location = FXMLDocumentController.class.getResource("FXMLDocument.fxml");
            loader.setLocation(location);
            Stage stage = new Stage();
            stage.setTitle(" Busca Covit | Home");
             stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png"))); 
            stage.setOpacity(1);
            AnchorPane panelControl = loader.load();
            Scene scene = new Scene(panelControl); 
            stage.setScene(scene);
            //stage.setOpacity(0.95);
            stage.initOwner(this.ap.getScene().getWindow());
            stage.setResizable(false);
            ((Stage)this.ap.getScene().getWindow()).close();           
            stage.centerOnScreen();
            stage.show(); 
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
}
