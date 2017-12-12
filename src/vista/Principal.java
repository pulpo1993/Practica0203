package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Casa;
import modelo.Lote;
import modelo.Persona;
import modelo.Urbanizacion;

public class Principal {

    public static void main(String[] args) {
        List<Casa> casaList=new ArrayList<Casa>();
        List<Lote> loteList=new ArrayList<Lote>();
        List<Persona> personaList=new ArrayList<Persona>();
        List<Urbanizacion> urbanizacionList=new ArrayList<Urbanizacion>();
        
        GestionDato gD=new GestionDato(casaList, loteList, personaList, urbanizacionList);
        VentanaPrincipal ventana= new VentanaPrincipal(gD, "02-03");

    }
    
}
