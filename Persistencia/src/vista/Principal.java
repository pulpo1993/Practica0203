/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import modelo.Persona;

/**
 *
 * @author saito
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestionDato gD = new GestionDato();
        try {
            Persona p = new Persona();
            p.setId(Long.parseLong("500"));
            p.setNombre("Jose");
            p.setEdad(34);
            gD.insertarPersona(p);
        } catch (RollbackException e) {
            JOptionPane.showMessageDialog(null, "Identificacion ya registrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(Persona p : gD.leerPersona()) {
            System.out.println(p.toString());
        }
    }

}
