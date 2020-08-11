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
import javafx.scene.control.Button;
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
    Button button;
    @FXML
    GridPane tableroFacil;
    @FXML
    GridPane tableroNormal;
    @FXML
    GridPane tableroDificil;
    @FXML
    Text seleccionDificultad;
    
    boolean sino = true;
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
    
    @FXML
    private void menuJuego() throws IOException{
        this.sino = false;
        FXMLLoader loader = new FXMLLoader();
        URL location = FXMLDocument2Controller.class.getResource("FXMLDocument2.fxml");
        loader.setLocation(location);
        Stage stage = new Stage();
        stage.setTitle(" Busca Covit | Panel de Control");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png"))); 
        stage.setOpacity(1);
        AnchorPane panelControl = loader.load();
        Scene scene = new Scene(panelControl); 
        stage.setScene(scene);
        //stage.setOpacity(0.95);
        stage.initOwner(this.fondo.getScene().getWindow());
        stage.setResizable(false);
        ((Stage)this.fondo.getScene().getWindow()).close();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.show();                        
    }
    
    public void actualizar(){
        this.button.setDisable(sino);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {           
        this.actualizar();
        this.tableroFacil.setVisible(true);
        this.tableroDificil.setVisible(false);
        this.tableroNormal.setVisible(false);              
    }    
    
}
