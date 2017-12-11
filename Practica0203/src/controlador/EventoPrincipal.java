package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import vista.VentanaCasa;
import vista.VentanaDuenio;
import vista.VentanaLote;
//import vista.VentanaArchivos;
//import vista.VentanaConsulta;
//import vista.VentanaMedico;
//import vista.VentanaPaciente;
import vista.VentanaPrincipal;
import vista.VentanaUrbanizacion;

/**
 *
 * @author Jorge Pizarro
 */
public class EventoPrincipal implements ActionListener {

    VentanaPrincipal vPrincipal;

    public EventoPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
        //this.vPrincipal.setIdioma("internacionalizacion.etiquetas_ES");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(0))) {
            VentanaDuenio ventana = new VentanaDuenio("Ventana Duenio", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(1))) {
            VentanaCasa ventana = new VentanaCasa("Ventana Casa", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(2))) {

            VentanaLote ventana = new VentanaLote("Ventana Lote", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(3))) {
            VentanaUrbanizacion ventana = new VentanaUrbanizacion("Ventana Urbanizacion", this.vPrincipal.getgD());
            ventana.setVisible(true);
            this.vPrincipal.getEscritorio().add(ventana);
        }
    }

}
