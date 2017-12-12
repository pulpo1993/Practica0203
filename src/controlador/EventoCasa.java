package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Casa;
import vista.VentanaCasa;

public class EventoCasa implements ActionListener {

    private VentanaCasa ventana;

    public EventoCasa(VentanaCasa ventana) {
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
                int pisos = Integer.parseInt(this.ventana.getTextoList().get(0).getText());
                String color = this.ventana.getTextoList().get(1).getText();
                String tipo = this.ventana.getTextoList().get(2).getText();
                for (int j = 0; j < this.ventana.getgD().getPersonaList().size(); j++) {
                    if (cedula.equals(this.ventana.getgD().getPersonaList().get(j).getCedula())) {
                        Casa c = new Casa(pisos, color, tipo, this.ventana.getgD().getPersonaList().get(j));
                        for (Casa ca : this.ventana.getgD().getCasaList()) {
                            if (c.getDuenio().getCedula().equals(ca.getDuenio().getCedula())) {
                                throw new ExcepcionRepetidos("Dato Repetido");
                            }
                        }
                        this.ventana.getgD().addCasa(c);
                    }
                }

                //Limpiar
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
        } catch(NullPointerException ne) {
            JOptionPane.showMessageDialog(ventana, "Cargar bien el Combo", "Error", JOptionPane.ERROR_MESSAGE);
        } catch(NumberFormatException ne) {
            JOptionPane.showMessageDialog(ventana, "Ingresar numeros en donde se debe", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Casa ya registrada", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            this.ventana.cargarCombo();
        }

        //Cargar la tabla
        Object[][] datosCasa = this.ventana.cargarDatos(this.ventana.getgD().getCasaList().size(), 4);
        this.ventana.setDatos(datosCasa);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

    private String codigoDueño() {
        String datos = this.ventana.getCombo().getSelectedItem().toString();
        System.out.println(datos);
        String cedula = "";
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                cedula = datos.substring(0, i - 1);
            }
        }
        return cedula;
    }
}
