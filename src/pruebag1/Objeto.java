/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebag1;

import javafx.scene.image.Image;

/**
 *
 * @author vroja
 */
public class Objeto {
    private Image imagen;
    private String accion;
    private Punto coordenada;

    public Objeto(Image imagen, String accion, Punto coordenada) {
        this.imagen = imagen;
        this.accion = accion;
        this.coordenada = coordenada;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Punto getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Punto coordenada) {
        this.coordenada = coordenada;
    }
    
    
    
}
