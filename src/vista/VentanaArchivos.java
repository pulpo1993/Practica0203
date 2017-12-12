package vista;

import controlador.EventoArchivos;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaArchivos extends JInternalFrame {

    private JPanel panelInicial;
    private List<JLabel> labelList;
    private List<JButton> botonList;
    private GestionDato gD;
    private JFileChooser fileChooser;
    private String ruta;
    private ResourceBundle rB;

    public VentanaArchivos(String title, GestionDato gD) {
        super(title, true, true, true, true);
        this.setSize(250, 170);
        this.setLocation(10, 400);
        this.gD = gD;
        this.iniciaComponente();
    }

    public void iniciaComponente() {

        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Ingreso de datos
        this.panelInicial = new JPanel(new FlowLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());
        JPanel hola = new JPanel(new FlowLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Gestion de Archivos"));

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Seleccionar"));
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Informacion"));
        for (int i = 0; i < this.botonList.size(); i++) {
            this.botonList.get(i).addActionListener(new EventoArchivos(this));
        }

        JPanel panelTitulo = new JPanel(new FlowLayout());
        JPanel panelSeleccion = new JPanel(new FlowLayout());
        JPanel panelIngreso = new JPanel(new GridLayout(1, 3));

        panelTitulo.add(this.labelList.get(0));
        panelSeleccion.add(this.botonList.get(0));
        hola.add(this.botonList.get(1));
        panelIngreso.add(hola);
        hola.add(this.botonList.get(2));
        panelIngreso.add(hola);

        panelNorte.add(panelTitulo, BorderLayout.NORTH);
        panelNorte.add(panelSeleccion, BorderLayout.CENTER);
        panelNorte.add(panelIngreso, BorderLayout.SOUTH);

        //Tabla 
        this.panelInicial.add(panelNorte);

        this.add(this.panelInicial);

    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public ResourceBundle getrB() {
        return rB;
    }

    public void setrB(ResourceBundle rB) {
        this.rB = rB;
    }

    public String selecionarRuta() {

        String aux = "";
        String texto = "";

        //try {
        this.fileChooser.showOpenDialog(this);
        if (this.fileChooser.getSelectedFile() != null) {
            File abre = this.fileChooser.getSelectedFile();
            texto = abre.getPath();
        }
        /*if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    //texto += aux + "\n";
                }

                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }*/
        return texto;
    }

    public void elimina(File a) {
        if (a.isFile()) {
            a.delete();
        }
        if (a.isDirectory()) {
            File[] directorio = a.listFiles();
            for (File b : directorio) {
                b.delete();
                if (b.isDirectory()) {
                    elimina(b);
                    b.delete();
                }
            }
        }
    }

}
