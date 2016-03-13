package vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 * <h1>VistaCambioDivisas</h1>
 * VistaCambioDivisas es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * VistaCambioDivisas es la clase que genera las vistas de la aplicación
 * Cambio de divisas. Esta extiende Jframe, por lo que es una ventana personalizada.<br/>
 * Utiliza la clase PanelMoneda Para generar paneles a través de un {@link TreeMap}. Así
 * el controlador le facilita esta estructura las veces necesarias para 
 * generar las vistas de cambios a distintas divisas, siendo está independiente 
 * de el modelo y únicamente gestionada por el controlador.
 
 * @author  Carlos Troyano Carmona
 * @version 1.0  
 * @since  13 de mar. de 2016 
 */
public class VistaCambioDivisas  extends JFrame {
   
    /**
     * Número constante para cumplir la interfaz Serializable.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Contenedor para los distintos Paneles que contendría un scroll.
     */
    private JPanel contenedor = new JPanel();
    
    /**
     * Constructor que recibe un título para la ventana y número de sub paneles
     * a crear para la vista.
     * @param tituloVentana Titulo de la ventana
     * @param numeroVentanas Número de sub paneles para la vista.
     */
    public VistaCambioDivisas(String tituloVentana, int numeroVentanas){
       super(tituloVentana);
       contenedor.setLayout(new GridLayout(numeroVentanas,1,5,5));
       this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
    }

    /**
     *  Método público que hace visible la ventana una vez construida. 
     *  Es utilizado por el controlador.
     */
    public void hacerVisible() {
        this.add(contenedor);
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setPreferredSize(new Dimension(500, ((int) height - 15)));
        this.pack();
        this.add(new JScrollPane());
        JScrollPane scrPane = new JScrollPane(contenedor);
        add(scrPane);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    /**
     * Método que utiliza un objeto de la clase {@link PanelMoneda}. Le añade los atributos
     * descritos en el árbol recibido como parámetro y lo añade a la ventana.
     * @param arbol Árbol generado por el controlador para rellenar los distintos
     * datos del panel. 
     */
    public void addPanel(TreeMap<String, String> arbol) {
        PanelMoneda panelMoneda = new PanelMoneda();
        panelMoneda.setTiltulo(arbol.get("titulo"));
        panelMoneda.setEtiquetaMonedaOrigen(arbol.get("cantidad origen"), arbol.get("nombre origen"));
        panelMoneda.setPanelTextoCantidadConvertida(arbol.get("cantidad convertida"));
        panelMoneda.setEtiquetaSimboloMonedaConvertida(arbol.get("simbolo destino"));
        panelMoneda.setEtiquetaNombreMonedaOrigen(arbol.get("nombre origen"));
        panelMoneda.setEtiquetaNombreMonedaDestino(arbol.get("nombre destino"));
        panelMoneda.setPanelTextoCantidadOrigen(arbol.get("cantidad origen"));
        panelMoneda.setPanelTextoCantidadDestino(arbol.get("cantidad destino"));
        contenedor.add(panelMoneda);
    }
    
    /**
     * Getter.  {@link VistaCambioDivisas#contenedor}
     * @return Retorna contenedor 
     */
    public JPanel getContenedor() {
        return contenedor;
    }

    /**
     * Setter. {@link VistaCambioDivisas#contenedor}
     * @param contenedor en contenedor 
     */
    
    public void setContenedor(JPanel contenedor) {
        this.contenedor = contenedor;
    }

}
