package vista;

import controlador.EventoLote;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Casa;
import modelo.Lote;

public class VentanaLote extends JInternalFrame{

    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JPanel panelInicial;
    private List<JLabel> labelList;
    private List<JTextField> textoList;
    private List<JButton> botonList;
    private GestionDato gD;
    private JComboBox combo;
    
     public VentanaLote(String title, GestionDato gD) {
        super(title, true, true, true, true);
        this.setSize(430, 295);
        this.setLocation(500, 300);
        this.gD = gD;
        this.iniciaComponente();
    }

    public void iniciaComponente() {
        //Ingreso de datos
        this.panelInicial = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Tipo"));
        this.labelList.add(new JLabel("Largo"));
        this.labelList.add(new JLabel("Ancho"));
        this.labelList.add(new JLabel("Metros Cuadrados"));
        this.labelList.add(new JLabel("Casa"));
        this.labelList.add(new JLabel("Agregar Lote"));

        this.textoList = new ArrayList<JTextField>();
        for (int i = 0; i < this.labelList.size() - 2; i++) {
            this.textoList.add(new JTextField());
        }

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar Lote"));
        this.botonList.add(new JButton("Actualizar"));
        for (int i = 0; i < this.botonList.size(); i++) {
            this.botonList.get(i).addActionListener(new EventoLote(this));
        }
        
        this.combo = new JComboBox();

        JPanel panelTitulo = new JPanel(new FlowLayout());
        JPanel panelIngreso = new JPanel(new GridLayout(6, 2));

        panelIngreso.add(this.labelList.get(0));
        panelIngreso.add(this.textoList.get(0));
        panelIngreso.add(this.labelList.get(1));
        panelIngreso.add(this.textoList.get(1));
        panelIngreso.add(this.labelList.get(2));
        panelIngreso.add(this.textoList.get(2));
        panelIngreso.add(this.labelList.get(3));
        panelIngreso.add(this.textoList.get(3));
        panelIngreso.add(this.labelList.get(4));
        panelIngreso.add(this.combo);

        panelTitulo.add(this.labelList.get(5));
        panelIngreso.add(this.botonList.get(0));
        panelIngreso.add(this.botonList.get(1));

        panelNorte.add(panelTitulo, BorderLayout.NORTH);
        panelNorte.add(panelIngreso, BorderLayout.CENTER);

        //Tabla 
        this.encabezado = new Object[5];
        this.encabezado[0] = "Tipo";
        this.encabezado[1] = "Largo";
        this.encabezado[2] = "Ancho";
        this.encabezado[3] = "Mts Cuadrados";
        this.encabezado[4] = "Casa";

        this.datos = cargarDatos(this.gD.getLoteList().size(), this.encabezado.length);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        this.panelInicial.add(panelNorte, BorderLayout.NORTH);
        this.panelInicial.add(this.scroll, BorderLayout.CENTER);

        this.add(this.panelInicial);

    }
    
        public Object[][] cargarDatos(int f, int k) {

        Object[][] retorno = new Object[f][k];
        int i = 0;
        for (Lote l : this.gD.getLoteList()) {
            retorno[i][0] = l.getTipoLote();
            retorno[i][1] = l.getLargo();
            retorno[i][2] = l.getAncho();
            retorno[i][3] = l.getMtsCuadrado();
            retorno[i][4] = l.getCasa().getDuenio().getApellido();
            i++;
        }
        return retorno;
    }

    public void cargarCombo() {
        this.combo.removeAllItems();
        for (Casa c : this.gD.getCasaList()) {
            this.combo.addItem(c.getDuenio().getCedula() + " | " + c.getDuenio().getApellido());
        }
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
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

    public List<JTextField> getTextoList() {
        return textoList;
    }

    public void setTextoList(List<JTextField> textoList) {
        this.textoList = textoList;
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

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    } 

}
