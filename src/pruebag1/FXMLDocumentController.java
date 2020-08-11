/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebag1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author vroja
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    AnchorPane panel;
    @FXML
    GridPane gp;
    int numero = 0;
    Objeto[][] matriz;
    @FXML
    private void Start(ActionEvent event) {
        
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Objeto tablero[][] = new Objeto[numero][numero];
    }    
    
    public void despejarCampo(){
        Text t = new Text("");
        String[] dif = t.getText().split(" ");
        switch (dif[2]) {
            case "Facil":
                this.matriz = new Objeto[9][9];
                for (int i = 0; i < 81; i++) {
                    if (gp.getChildren().get(i).isPressed()) {
                        // revisar que es
                    }
                }
                break;
            case "Normal":
                this.matriz = new Objeto[16][16];
                for (int i = 0; i < 256; i++) {
                    if (gp.getChildren().get(i).isPressed()) {
                        // revisar que es
                    }
                }
                break;
            case "Dificil":
                this.matriz = new Objeto[32][32];
                for (int i = 0; i < 1024; i++) {
                    if (gp.getChildren().get(i).isPressed()) {
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
                    if (gp.getChildren().get(i).isPressed()) {
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
                    if (gp.getChildren().get(i).isPressed()) {
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
                    if (gp.getChildren().get(i).isPressed()) {
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
        gp = new GridPane();
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
