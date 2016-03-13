package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * <h1>PanelMoneda</h1>
 * PanelMoneda es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * PanelMoneda es una clase que hereda de Jpanel. Por lo tanto es un panel
 * personalizado. Crea un panel personalizado con métodos que permiten insertar los
 * textos necesarios para mostrar en GUI.
 * <br/>Esta clase pertenece a la vista. Es utilizada por la clase vista para generar
 * distintas instancias de paneles personalizados.
 * @see JPanel
 * @author  Carlos Troyano Carmona
 * @version 1.0  
 * @since  13 de mar. de 2016 
 */
public class PanelMoneda extends JPanel {
   
    /**
     * Número constante para cumplir la interfaz Serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la case. Invoca al constructor del padre
     * e inserta la estructura {@link GridLayout} para ir insertando
     * los elementos necesarios. Estos se inicializan mediante los setters de
     * la clase.
     */
    public PanelMoneda() {
        super();
        this.setLayout(new GridLayout(4,2,5,5));
    }
    
    /**
     * Inserta el título en el panel.
     * @param titulo Titulo a insertar en el panel.
     */
    public void setTiltulo(String titulo) {  //nombre moneda destino
        this.setBorder(new EmptyBorder(10, 10, 50, 50));
        TitledBorder titl = new TitledBorder(titulo);
        titl.setTitleColor(Color.BLUE);
        Border border = this.getBorder();
        this.setBorder(new CompoundBorder(border, titl));
    }
    
    /**
     * Inserta la etiqueta de la moneda de origen con el nombre de la moneda y 
     * la cantidad.
     * @param numero Cantidad.
     * @param moneda Nombre de la moneda.
     */
    public void setEtiquetaMonedaOrigen(String numero, String moneda) { 
        JLabel etiqueta = new JLabel();
        etiqueta.setText(numero + " " + moneda + " es:");
        this.add(etiqueta);
        this.add(new JLabel());
    }
    
    /**
     * Inserta el panel de texto con la cantidad convertida de la moneda de destino.
     * @param numero Cantidad.
     */
    public void setPanelTextoCantidadConvertida(String numero) { 
        JTextField panelTexto = new JTextField(20);
        panelTexto.setText(numero);
        this.add(panelTexto);
    }
    
    /**
     * Inserta la etiqueta con el símbolo de la moneda de destino.
     * @param simbolo 
     *	void
     */
    public void setEtiquetaSimboloMonedaConvertida(String simbolo) {
        JLabel etiqueta = new JLabel();
        etiqueta.setText(simbolo);
        this.add(etiqueta);
    }
    
    /**
     * Inserta la etiqueta con el nombre de la moneda de destino.
     * @param nombre Nombre.
     */
    public void setEtiquetaNombreMonedaDestino(String nombre) {
        JLabel etiqueta = new JLabel();
        etiqueta.setText(nombre);
        this.add(etiqueta);       
    }
    
    /**
     * Inserta la etiqueta con el nombre de la moneda de origen.
     * @param nombre Nombre.
     *	void
     */
    public void setEtiquetaNombreMonedaOrigen(String nombre) {
        JLabel etiqueta = new JLabel();
        etiqueta.setText(nombre);
        this.add(etiqueta);        
    }
    
    /**
     * Inserta el panel de texto con la cantidad de la moneda de origen.
     * @param numero Cantidad.
     */
    void setPanelTextoCantidadOrigen(String numero) {
        JTextField panelTexto = new JTextField(20);
        panelTexto.setText(numero);
        this.add(panelTexto);
    }

    /**
     * Inserta el panel de texto con la cantidad de la moneda de Destino.
     * @param numero Cantidad.
     */
    void setPanelTextoCantidadDestino(String numero) { 
        JTextField panelTexto = new JTextField(20);
        panelTexto.setText(numero);
        this.add(panelTexto);
    }
}
