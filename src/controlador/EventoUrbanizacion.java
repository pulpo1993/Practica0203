package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Urbanizacion;
import vista.VentanaUrbanizacion;

public class EventoUrbanizacion implements ActionListener {

    private VentanaUrbanizacion ventana;

    public EventoUrbanizacion(VentanaUrbanizacion ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(this.ventana.getBotonList().get(0))) {
                //Guardar
                String cedula = codigoDueño();
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    if (this.ventana.getTextoList().get(i).getText().equals("")) {
                        throw new ExcepcionCamposVacios("");
                    }
                }
                String nombre = this.ventana.getTextoList().get(0).getText();
                for (int j = 0; j < this.ventana.getgD().getLoteList().size(); j++) {
                    if (cedula.equals(this.ventana.getgD().getLoteList().get(j).getCasa().getDuenio().getCedula())) {
                        Urbanizacion u = new Urbanizacion(nombre, this.ventana.getgD().getLoteList().get(j));
                        for (Urbanizacion ur : this.ventana.getgD().getUrbanizacionList()) {
                            if (ur.getNombre().equals(u.getNombre()) && ur.getLote().getCasa().getDuenio().getCedula().equals(u.getLote().getCasa().getDuenio().getCedula())) {
                                throw new ExcepcionRepetidos("Dato Repetido");
                            }
                        }
                        this.ventana.getgD().addUrbanizacion(u);
                    }
                }
                //Limpiar
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
        } catch(NullPointerException ne) {
            JOptionPane.showMessageDialog(ventana, "Cargar bien el Combo", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Ürbanizacion ya registrada ", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
            this.ventana.cargarCombo();
        }

        //Cargar la tabla
        Object[][] datosUrbanizacion = this.ventana.cargarDatos(this.ventana.getgD().getUrbanizacionList().size(), 2);
        this.ventana.setDatos(datosUrbanizacion);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

    private String codigoDueño() {
        String datos = this.ventana.getCombo().getSelectedItem().toString();
        String cedula = null;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                cedula = datos.substring(0, i - 1);
            }
        }
        return cedula;
    }
}
