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
public class Casa implements java.io.Serializable{
    
    private int nPisos;
    private String color;
    private String tipo;
    private Persona duenio;

    public Casa() {
    }

    public Casa(int nPisos, String color, String tipo, Persona duenio) {
        this.nPisos = nPisos;
        this.color = color;
        this.tipo = tipo;
        this.duenio = duenio;
    }

    public int getnPisos() {
        return nPisos;
    }

    public void setnPisos(int nPisos) {
        this.nPisos = nPisos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }

}
