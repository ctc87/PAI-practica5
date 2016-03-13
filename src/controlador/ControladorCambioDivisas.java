package controlador;

import java.util.Scanner;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelo.Conversor;
import vista.VistaCambioDivisas;

/**
 * <h1>ControladorCambioDivisas</h1>
 * ControladorCambioDivisas es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 *  ControladorCambioDivisas es la clase que hace de controlador entre la vista {@link VistaCambioDivisas}
 *  y el modelo {@link Conversor}. Este comunica a la vista los datos recibidos por el modelo
 *  Genera un mapa con los datos del modelo que son cargados en la vista que acepta este tipo 
 *  de objetos para generarse.

 * @author  Carlos Troyano Carmona
 * @version 1.0  
 * @since  13 de mar. de 2016 
 */
public class ControladorCambioDivisas {

    /**
     * Atributo que contiene el modelo.
     */
    private Conversor conversor = new Conversor(0);
    
    /**
     * Numero de sub paneles a crear por la vista extraído del modelo
     */
    int numeroVentanas = conversor.NUMERO_TIPO_MONEDAS;
    
    /**
     * Atributo que contiene la vista. Se inicializa con un título.
     */
    private VistaCambioDivisas vista = new VistaCambioDivisas("Controlador Cambio Divisas", numeroVentanas);
    
    /**
     * Atributos que guardaran los valores y harán de intermediarios entre modelo y vista.
     */
    String titulo, cantidadOrigen, cantidadDestino, nombreOrigen, nombreDestino, simboloOrigen, simboloDestino;
    
    /**
     * @param convertir Número a de la moneda de origen a calcular.
     */
    public ControladorCambioDivisas(int convertir) {
        conversor = new Conversor(convertir);
        extraerDatosModeloEInsertarlosVista();
    }
    
    /**
     * Método que rellena los atributos intermedios extrayendo la información desde
     * el modelo y clasificándola. Después genera la estructura de datos necesaria por 
     * la vista para poder generarse. Con esto genera la vista y la hace visible.
     */
    private void extraerDatosModeloEInsertarlosVista() {
        setNombreOrigen(conversor.NOMBRE_ORIGEN);
        setSimboloOrigen(conversor.SIMBOLO_ORIGEN);
        setCantidadOrigen(conversor.getCantidadEntrada());
        for(Entry<String, TreeMap<String, String>> entry : conversor.getRelEuro().entrySet()) {
            TreeMap<String, String> mapaActual = entry.getValue();
            setCantidadDestino(conversor.getMapConversiones().get(mapaActual.get("nombre")).toString());
            setNombreDestino(mapaActual.get("nombre"));
            setTitulo(mapaActual.get("nombre"));
            setSimboloDestino(mapaActual.get("simbolo"));
            vista.addPanel(construirMapVistas());
          }
        vista.hacerVisible();
    }
    
    /**
     * Método que genera el objeto que es necesario para crear la vista.
     * Un {@link TreeMap}. Que contiene los atributos indexados con las palabras
     * clave conocidas también por la vista.
     * @return TreeMap<String,String> Objeto para genrar vistas.
     */
    private TreeMap<String, String> construirMapVistas() {
        TreeMap<String, String> mapaParaConstruirVista = new TreeMap<String, String>();
        mapaParaConstruirVista.put("titulo", getTitulo().substring(0, 1).toUpperCase() + getTitulo().substring(1));
        mapaParaConstruirVista.put("cantidad origen", getCantidadOrigen());
        mapaParaConstruirVista.put("nombre origen", getNombreOrigen());
        mapaParaConstruirVista.put("cantidad convertida", getCantidadDestino());
        mapaParaConstruirVista.put("simbolo origen", getSimboloOrigen());
        mapaParaConstruirVista.put("nombre destino", getNombreDestino());
        mapaParaConstruirVista.put("simbolo destino", getSimboloDestino());
        mapaParaConstruirVista.put("cantidad destino", getCantidadDestino());
        return mapaParaConstruirVista;

    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
            System.out.println(" Cantidad de euros a transformar ");
            int numero = sc.nextInt();
            sc.close();
            new ControladorCambioDivisas(numero);
    }
    
    /**
     * Getter.  {@link ControladorCambioDivisas#titulo}
     * @return Retorna titulo 
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Setter. {@link ControladorCambioDivisas#titulo}
     * @param titulo en titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Getter.  {@link ControladorCambioDivisas#cantidadOrigen}
     * @return Retorna cantidadOrigen 
     */
    public String getCantidadOrigen() {
        return cantidadOrigen;
    }
    
    /**
     * Setter. {@link ControladorCambioDivisas#cantidadOrigen}
     * @param cantidadOrigen en cantidadOrigen 
     */
    public void setCantidadOrigen(String cantidadOrigen) {
        this.cantidadOrigen = cantidadOrigen;
    }
    
    /**
     * Getter.  {@link ControladorCambioDivisas#cantidadDestino}
     * @return Retorna cantidadDestino 
     */
    public String getCantidadDestino() {
        return cantidadDestino;
    }

    /**
     * Setter. {@link ControladorCambioDivisas#cantidadDestino}
     * @param cantidadDestino en cantidadDestino 
     */
    public void setCantidadDestino(String cantidadDestino) {
        this.cantidadDestino = cantidadDestino;
    }
    
    /**
     * Getter.  {@link ControladorCambioDivisas#nombreOrigen}
     * @return Retorna nombreOrigen 
     */
    public String getNombreOrigen() {
        return nombreOrigen;
    }
    
    /**
     * Setter. {@link ControladorCambioDivisas#nombreOrigen}
     * @param nombreOrigen en nombreOrigen 
     */
    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    /**
     * Getter.  {@link ControladorCambioDivisas#nombreDestino}
     * @return Retorna nombreDestino 
     */
    public String getNombreDestino() {
        return nombreDestino;
    }
    
    /**
     * Setter. {@link ControladorCambioDivisas#nombreDestino}
     * @param nombreDestino en nombreDestino 
     */
    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    /**
     * Getter.  {@link ControladorCambioDivisas#simboloOrigen}
     * @return Retorna simboloOrigen 
     */
    public String getSimboloOrigen() {
        return simboloOrigen;
    }
    
    /**
     * Setter. {@link ControladorCambioDivisas#simboloOrigen}
     * @param simboloOrigen en simboloOrigen 
     */
    public void setSimboloOrigen(String simboloOrigen) {
        this.simboloOrigen = simboloOrigen;
    }
    
    /**
     * Getter.  {@link ControladorCambioDivisas#simboloDestino}
     * @return Retorna simboloDestino 
     */
    public String getSimboloDestino() {
        return simboloDestino;
    }
    
    /**
     * Setter. {@link ControladorCambioDivisas#simboloDestino}
     * @param simboloDestino en simboloDestino 
     */
    public void setSimboloDestino(String simboloDestino) {
        this.simboloDestino = simboloDestino;
    }
}

