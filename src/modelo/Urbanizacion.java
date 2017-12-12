/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jorge Pizarro
 */
public class Urbanizacion implements java.io.Serializable{
    
    private String nombre;
    private Lote lote;

    public Urbanizacion() {
    }

    public Urbanizacion(String nombre, Lote lote) {
        this.nombre = nombre;
        this.lote = lote;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
}
