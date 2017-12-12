package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Persona;
import vista.VentanaPersona;

public class EventoPersona implements ActionListener {

    private VentanaPersona ventana;

    public EventoPersona(VentanaPersona ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(this.ventana.getBotonList().get(0))) {
                //Guardar
                for(int i = 0 ; i<this.ventana.getTextoList().size() ; i++) {
                    if(this.ventana.getTextoList().get(i).getText().equals("")){
                        throw new ExcepcionCamposVacios("");
                    }
                }
                String cedula = this.ventana.getTextoList().get(0).getText();
                String nombre = this.ventana.getTextoList().get(1).getText();
                String apellido = this.ventana.getTextoList().get(2).getText();
                String fechaNac = this.ventana.getTextoList().get(3).getText();
                String direccion = this.ventana.getTextoList().get(4).getText();
                String telefono = this.ventana.getTextoList().get(5).getText();
               
                Persona p = new Persona(cedula, nombre, apellido, fechaNac, direccion, telefono);
                for(Persona pe: this.ventana.getgD().getPersonaList()) {
                    if(p.getCedula().equals(pe.getCedula())) {
                        throw new ExcepcionRepetidos("");
                    }
                }
                this.ventana.getgD().addPersona(p);
            }
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Este dueño ya ha sido ingresado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                this.ventana.getTextoList().get(i).setText(null);
            }
        }

        //Cargar la tabla
        Object[][] datosPersona = this.ventana.cargarDatos(this.ventana.getgD().getPersonaList().size(), 6);
        this.ventana.setDatos(datosPersona);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }
}
