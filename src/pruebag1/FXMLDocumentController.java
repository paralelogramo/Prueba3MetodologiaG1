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
    int numero = 0;
    Objeto[][] matriz;
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
    
    public void despejarCampo(){
        Text t = new Text("");
        String[] dif = t.getText().split(" ");
        switch (dif[2]) {
            case "Facil":
                this.matriz = new Objeto[9][9];
                for (int i = 0; i < 81; i++) {
                    if (tableroFacil.getChildren().get(i).isPressed()) {
                        // revisar que es
                    }
                }
                break;
            case "Normal":
                this.matriz = new Objeto[16][16];
                for (int i = 0; i < 256; i++) {
                    if (tableroFacil.getChildren().get(i).isPressed()) {
                        // revisar que es
                    }
                }
                break;
            case "Dificil":
                this.matriz = new Objeto[32][32];
                for (int i = 0; i < 1024; i++) {
                    if (tableroFacil.getChildren().get(i).isPressed()) {
                        // revisar que es
                    }
                }
                break;
        }
    }
    
    public void descubrirCasillaSN(){
        
    }
    
    public void descubrirCasillaCN(){
        
    }
    
    public void verificarVirus(){ //colocar bandera o quitar bandera
        Text t = new Text("");
        String[] dif = t.getText().split(" ");
        switch (dif[2]) {
            case "Facil":
                for (int i = 0; i < 81; i++) {
                    if (tableroFacil.getChildren().get(i).isPressed()) {
                        int x = i/9-1;
                        int y = i-9*x-1;
                        if (matriz[x][y].getBandera()) {
                            matriz[x][y].setBandera();
                            // cambiar imagen en gridpane
                        }
                    }
                }
                break;
            case "Normal":
                for (int i = 0; i < 256; i++) {
                    if (tableroFacil.getChildren().get(i).isPressed()) {
                        int x = i/9-1;
                        int y = i-9*x-1;
                        if (matriz[x][y].getBandera()) {
                            matriz[x][y].setBandera();
                            // cambiar imagen en gridpane
                        }
                    }
                }
                break;
            case "Dificil":
                for (int i = 0; i < 1024; i++) {
                    if (tableroFacil.getChildren().get(i).isPressed()) {
                        int x = i/9-1;
                        int y = i-9*x-1;
                        if (matriz[x][y].getBandera()) {
                            matriz[x][y].setBandera();
                            // cambiar imagen en gridpane
                        }
                    }
                }
                break;
        }
    }
    
    public void verificarContinuidad(){
        
    }
    
    public void contarPuntaje(){
        Text t = new Text("");
        int cantBanderas = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j].getBandera()) {
                    cantBanderas++;
                }
            }
        }
        t.setText("Quedan: "+cantBanderas+" Virus");
    }
    
    public void calcularTiempo(){
        long tiempo = System.currentTimeMillis()/1000;
        
    }
    
    public void colocarVirusAzar(){
        //VERSION 1.0
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]=null;
            }
        }
        tableroFacil = new GridPane();
        Text t = new Text("");
        Image imagen = null;
        
        String[] dif = t.getText().split(" ");
        
        switch (dif[2]) {
            case "Facil":
                this.matriz = new Objeto[9][9];
                for (int i = 0; i < 25; i++) {
                    int x = (int)(Math.random() *((8-0) +1))+0;
                    int y = (int)(Math.random() *((8-0) +1))+0;
                    if (matriz[x][y]==null) {
                        i--;
                    }
                    else{
                        matriz[x][y] = new Objeto(imagen, "Virus", (new Punto(x, y)));
                        //GUARDAR EN EL GRIDPANE;
                    }
                }
                break;
            case "Normal":
                this.matriz = new Objeto[16][16];
                for (int i = 0; i < 100; i++) {
                    int x = (int)(Math.random() *((8-0) +1))+0;
                    int y = (int)(Math.random() *((8-0) +1))+0;
                    if (matriz[x][y]==null) {
                        i--;
                    }
                    else{
                        matriz[x][y] = new Objeto(imagen, "Virus", (new Punto(x, y)));
                        //GUARDAR EN EL GRIDPANE;
                    }
                }
                break;
            case "Dificil":
                this.matriz = new Objeto[32][32];
                for (int i = 0; i < 400; i++) {
                    int x = (int)(Math.random() *((8-0) +1))+0;
                    int y = (int)(Math.random() *((8-0) +1))+0;
                    if (matriz[x][y]==null) {
                        i--;
                    }
                    else{
                        matriz[x][y] = new Objeto(imagen, "Virus", (new Punto(x, y)));
                        //GUARDAR EN EL GRIDPANE;
                    }
                }
                break;
        }
    }
}
