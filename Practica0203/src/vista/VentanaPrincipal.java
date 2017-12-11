package vista;

import controlador.EventoPrincipal;
import controlador.GestionDato;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private List<JMenu> menuList;
    private List<JMenuItem> itemMenuList;
    private GestionDato gD;

    public VentanaPrincipal(GestionDato gD, String title) throws HeadlessException {
        super(title);
        this.gD = gD;
        this.iniciaComponentes();
        this.setSize(600, 500);
        this.setLocation(600, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public void iniciaComponentes() {
        this.escritorio = new JDesktopPane();
        this.barraMenu = new JMenuBar();
        this.menuList = new ArrayList();
        this.itemMenuList = new ArrayList();

        this.setContentPane(this.escritorio);
        this.setJMenuBar(barraMenu);
        this.menuList.add(new JMenu("Dueño"));
        this.menuList.add(new JMenu("Casa"));
        this.menuList.add(new JMenu("Lote"));
        this.menuList.add(new JMenu("Urbanizacion"));
        this.menuList.add(new JMenu("Generar"));

        this.itemMenuList.add(new JMenuItem("Agregar Dueño"));
        this.itemMenuList.add(new JMenuItem("Agregar Casa"));
        this.itemMenuList.add(new JMenuItem("Agregar Lote"));
        this.itemMenuList.add(new JMenuItem("Agregar Urbanizacion"));
        this.itemMenuList.add(new JMenuItem("Generar archivo binario"));

        this.menuList.get(0).add(this.itemMenuList.get(0));
        this.menuList.get(1).add(this.itemMenuList.get(1));
        this.menuList.get(2).add(this.itemMenuList.get(2));
        this.menuList.get(3).add(this.itemMenuList.get(3));
        this.menuList.get(4).add(this.itemMenuList.get(4));
        
        this.barraMenu.add(this.menuList.get(0));
        this.barraMenu.add(this.menuList.get(1));
        this.barraMenu.add(this.menuList.get(2));
        this.barraMenu.add(this.menuList.get(3));
        this.barraMenu.add(this.menuList.get(4));

        for (int i = 0; i < this.itemMenuList.size(); i++) {
            this.itemMenuList.get(i).addActionListener(new EventoPrincipal(this));
        }

        this.getContentPane().setBackground(Color.decode("#67a085"));
        
        this.asignarIdioma();
    }

    public void asignarIdioma() {

    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getItemMenuList() {
        return itemMenuList;
    }

    public void setItemMenuList(List<JMenuItem> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

}
