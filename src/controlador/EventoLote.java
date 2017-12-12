package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Casa;
import modelo.Lote;
import vista.VentanaLote;

public class EventoLote implements ActionListener {

    private VentanaLote ventana;

    public EventoLote(VentanaLote ventana) {
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
                String tipo = this.ventana.getTextoList().get(0).getText();
                double largo = Double.parseDouble(this.ventana.getTextoList().get(1).getText());
                double ancho = Double.parseDouble(this.ventana.getTextoList().get(2).getText());
                double mtsCuadrados = Double.parseDouble(this.ventana.getTextoList().get(3).getText());
                for (int j = 0; j < this.ventana.getgD().getCasaList().size(); j++) {
                    if (cedula.equals(this.ventana.getgD().getCasaList().get(j).getDuenio().getCedula())) {
                        Lote l = new Lote(tipo, largo, ancho, mtsCuadrados, this.ventana.getgD().getCasaList().get(j));
                        for (Lote lo : this.ventana.getgD().getLoteList()) {
                            if (l.getCasa().getDuenio().getCedula().equals(lo.getCasa().getDuenio().getCedula())) {
                                throw new ExcepcionRepetidos("Dato Repetido");
                            }
                        }
                        this.ventana.getgD().addLote(l);
                    }
                }
                //Limpiar
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
        }  catch(NumberFormatException ne) {
            JOptionPane.showMessageDialog(ventana, "Ingresar numeros en donde se debe", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Lote ya registrada", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
            this.ventana.cargarCombo();
        }

        //Cargar la tabla
        Object[][] datosLote = this.ventana.cargarDatos(this.ventana.getgD().getLoteList().size(), 5);
        this.ventana.setDatos(datosLote);
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
