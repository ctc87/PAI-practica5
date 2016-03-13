package modelo;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * <h1>Conversor</h1>
 * Conversor es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * Conversor es la clase un objeto de la clase {@link MonedasRelacionEuro} y lo utiliza
 * para crear un árbol con los valores de cambio de dicha moneda respecto a una cantidad
 * de euros de entrada.<be/>
 *  
 * Forma parte del modelo y es utilizado directamente por el controlador para 
 * gestionar la vista. Que no es más que la interfaz del programa
 * @see MonedasRelacionEuro
 * @author  Carlos Troyano Carmona
 * @version 1.0  
 * @since  13 de mar. de 2016 
 */
public class Conversor {
    /**
     * Objeto de la clase {@link MonedasRelacionEuro}.
     */
    final static private MonedasRelacionEuro REL_EURO = new MonedasRelacionEuro();
    
    /**
     * Nombre de la moneda de origen.
     */
    final public String NOMBRE_ORIGEN = REL_EURO.NOMBRE_ORIGEN;
    
    /**
     * Símbolo de la moneda de origen.
     */
    final public String SIMBOLO_ORIGEN = REL_EURO.SIMBOLO_ORIGEN;
    
    /**
     * Cantidad de divisas a las que se va a convertir.
     */
    final public int NUMERO_TIPO_MONEDAS = REL_EURO.NUMERO_TIPO_MONEDAS;
    
    /**
     * Cantidad que se va a convertir para la moneda de entrada.
     */
    private String cantidadEntrada;
    
    /**
     * Getter.  {@link Conversor#cantidadEntrada}
     * @return Retorna cantidadEntrada 
     */
    public String getCantidadEntrada() {
        return cantidadEntrada;
    }

    /**
     * Setter. {@link Conversor#cantidadEntrada}
     * @param cantidadEntrada Fija cantidadEntrada en cantidadEntrada 
     */
    
    public void setCantidadEntrada(String cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    /**
     * Getter.
     * @return Retorna relEuro 
     */
    public TreeMap<String, TreeMap<String, String>> getRelEuro() {
        return REL_EURO.MAPA_MONEDAS;
    }

    /**
     * Getter. 
     * @return Retorna mapConversiones 
     */
    public TreeMap<String, Float> getMapConversiones() {
        return MAP_CONVERSIONES;
    }
    
    /**
     * Mapa de conversiones donde se guardan los valores convertidos de la moneda de entrada
     * a las distintas monedas de salida indexado con el nombre de la moneda como clave.
     */
    final static private TreeMap<String, Float> MAP_CONVERSIONES = new TreeMap<String, Float>();
    
    /**
     * Constructor que recibe una cantidad de entrada a convertir en las distintas monedas.
     * @param CantidadEntrada
     */
    public Conversor(int CantidadEntrada) {
        Integer cantidad = CantidadEntrada;
        setCantidadEntrada(cantidad.toString());
        crearTreeMapConvertir(CantidadEntrada);
    }
    
    /**
     * Método que el mapa con las conversiones y sus claves asociadas.
     * @param CantidadEntrada 
     */
    private void crearTreeMapConvertir(int CantidadEntrada) {
        Iterator<String> it = REL_EURO.MAPA_MONEDAS.keySet().iterator();
        while(it.hasNext()){
          Object key = it.next();
          Float conversor = Float.valueOf(REL_EURO.MAPA_MONEDAS.get(key).get("conversion"));
          MAP_CONVERSIONES.put(key.toString(), (CantidadEntrada * (Float)conversor )); 
        }
    }
}
