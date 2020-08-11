/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebag1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Asus-ROG
 */
public class FXMLDocument2Controller implements Initializable {
    @FXML
    AnchorPane ap;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    


    @FXML
    private void cerrar() throws IOException{
                FXMLLoader loader = new FXMLLoader();
                URL location = FXMLDocumentController.class.getResource("FXMLDocument.fxml");
                loader.setLocation(location);
                Stage stage = new Stage();
                stage.setTitle(" Busca Covit | Home");
                stage.show();

    }
    
}
