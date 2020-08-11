/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebag1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author vroja
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    AnchorPane panel;
    @FXML
    AnchorPane fondo;
    @FXML
    GridPane tableroFacil;
    @FXML
    GridPane tableroNormal;
    @FXML
    GridPane tableroDificil;
    @FXML
    Text seleccionDificultad;
    
    int dificultad = 1;
    
    @FXML
    private void start(ActionEvent event) {
        
      
    }
    
    @FXML
    private void cambiarDificultad(ActionEvent event) {
        this.dificultad++;
        if(this.dificultad == 4)
            this.dificultad = 1;
        switch(this.dificultad){
            case 1:{
                this.seleccionDificultad.setText("Dificultad : Facil");
                this.tableroFacil.setVisible(true);                
                this.tableroNormal.setVisible(false); 
                this.tableroDificil.setVisible(false);
                break;
            }
            case 2:{
                this.seleccionDificultad.setText("Dificultad : Normal");
                this.tableroFacil.setVisible(false);
                 this.tableroNormal.setVisible(true);
                this.tableroDificil.setVisible(false);                
                break;                        
            }
            case 3:{
                this.seleccionDificultad.setText("Dificultad : Dificil"); 
                this.tableroFacil.setVisible(false);                
                this.tableroNormal.setVisible(false);
                this.tableroDificil.setVisible(true);                
                break;
            }                   
        }       
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        this.tableroFacil.setVisible(true);
        this.tableroDificil.setVisible(false);
        this.tableroNormal.setVisible(false);              
    }    
    
}
