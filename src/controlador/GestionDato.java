/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import modelo.Casa;
import modelo.Lote;
import modelo.Persona;
import modelo.Urbanizacion;

/**
 *
 * @author Jorge Pizarro
 */
public class GestionDato {

    List<Casa> casaList;
    List<Lote> loteList;
    List<Persona> personaList;
    List<Urbanizacion> urbanizacionList;

    public GestionDato(List<Casa> casaList, List<Lote> loteList, List<Persona> personaList, List<Urbanizacion> urbanizacionList) {
        this.casaList = casaList;
        this.loteList = loteList;
        this.personaList = personaList;
        this.urbanizacionList = urbanizacionList;
    }

    public List<Casa> getCasaList() {
        return casaList;
    }

    public void setCasaList(List<Casa> casaList) {
        this.casaList = casaList;
    }

    public List<Lote> getLoteList() {
        return loteList;
    }

    public void setLoteList(List<Lote> loteList) {
        this.loteList = loteList;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<Urbanizacion> getUrbanizacionList() {
        return urbanizacionList;
    }

    public void setUrbanizacionList(List<Urbanizacion> urbanizacionList) {
        this.urbanizacionList = urbanizacionList;
    }

    public boolean addPersona(Persona p) {
        return this.personaList.add(p);
    }

    public boolean addCasa(Casa c) {
        return this.casaList.add(c);
    }

    public boolean addLote(Lote l) {
        return this.loteList.add(l);
    }

    public boolean addUrbanizacion(Urbanizacion u) {
        return this.urbanizacionList.add(u);
    }

    public boolean guardarArchivoDueño(String ruta) {
        try {
            FileOutputStream outFile = new FileOutputStream(ruta+"\\ArchivoDueño", true);
            ObjectOutputStream escritura = new ObjectOutputStream(outFile);
            escritura.writeObject(this.personaList);
            escritura.close();
            return true;
        } catch (IOException e1) {
            return false;
        }
    }

    public boolean guardarArchivoCasa(String ruta) {
        try {
            FileOutputStream outFile = new FileOutputStream(ruta+"\\ArchivoCasa", true);
            ObjectOutputStream escritura = new ObjectOutputStream(outFile);
            escritura.writeObject(this.casaList);
            escritura.close();
            return true;
        } catch (IOException e1) {
            return false;
        }
    }

    public boolean guardarArchivoLote(String ruta) {
        try {
            FileOutputStream outFile = new FileOutputStream(ruta+"\\ArchivoLote", true);
            ObjectOutputStream escritura = new ObjectOutputStream(outFile);
            escritura.writeObject(this.loteList);
            escritura.close();
            return true;
        } catch (IOException e1) {
            return false;
        }
    }

    public boolean guardarArchivoUrbanizacion(String ruta) {
        try {
            FileOutputStream outFile = new FileOutputStream(ruta+"\\ArchivoUrbanizacion", true);
            ObjectOutputStream escritura = new ObjectOutputStream(outFile);
            escritura.writeObject(this.urbanizacionList);
            escritura.close();
            return true;
        } catch (IOException e1) {
            return false;
        }
    }

}
