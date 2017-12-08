/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    List <Lote> loteList;
    List <Persona> personaList;
    List <Urbanizacion> urbanizacionList;

    public GestionDato(List<Casa> casaList, List<Lote> loteList, List<Persona> personaList, List<Urbanizacion> urbanizacionList) {
        this.casaList = casaList;
        this.loteList = loteList;
        this.personaList = personaList;
        this.urbanizacionList = urbanizacionList;
    }

    

}
