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
public class Lote implements java.io.Serializable{
    
    private String tipoLote;
    private double largo;
    private double ancho;
    private double mtsCuadrado;
    private Casa casa;

    public Lote() {
    }

    public Lote(String tipoLote, double largo, double ancho, double mtsCuadrado, Casa casa) {
        this.tipoLote = tipoLote;
        this.largo = largo;
        this.ancho = ancho;
        this.mtsCuadrado = mtsCuadrado;
        this.casa = casa;
    }

    public String getTipoLote() {
        return tipoLote;
    }

    public void setTipoLote(String tipoLote) {
        this.tipoLote = tipoLote;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getMtsCuadrado() {
        return mtsCuadrado;
    }

    public void setMtsCuadrado(double mtsCuadrado) {
        this.mtsCuadrado = mtsCuadrado;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    
}
