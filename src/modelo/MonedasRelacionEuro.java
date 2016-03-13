package modelo;

import java.util.Currency;
import java.util.Locale;
import java.util.TreeMap;

/**
 * <h1>MonedasRelacionEuro</h1>
 * MonedasRelacionEuro es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 *  MonedasRelacionEuro es la clase que forma parte del modelo de la aplicación. Contiene 
 *  las relaciones entre las distintas monedas y el euro. Se utiliza para después hacer
 *  cambios de moneda y acceder al nombre de la moneda o a su símbolo.
 * <br/>
 * @see Currency
 * @see Locale
 * @see TreeMap
 * @author  Carlos Troyano Carmona
 * @version 1.0  
 * @since  13 de mar. de 2016 
 */

public class MonedasRelacionEuro {
    /**
     * Constante que contiene el nombre de la moneda de origen.
     */
    final public String NOMBRE_ORIGEN = "euro";

    /**
     * Constante del símbolo de la moneda de origen.  
     */
    final public String SIMBOLO_ORIGEN = "€";

    /**
     * Constante que contiene el número de monedas en esta relación con el euro. 
     */
    final public int NUMERO_TIPO_MONEDAS = 6;

    //static final private TreeMap< String, String> EURO = new TreeMap<String, String>();
    //static String EURO_CONVERSION = "1";

    /**
     * Mapa que contiene toda la información sobre el dollar.
     */
    static final private TreeMap< String, String> DOLLAR = new TreeMap<String, String>();

    /**
     * Factor de conversión sobre el dollar
     */
    static String DOLLAR_CONVERSION = "1.11498";

    /**
     * Mapa que contiene toda la información sobre el la libra esterlina.
     */
    static final private TreeMap< String, String> GBP = new TreeMap<String, String>();

    /**
     * Factor de conversión sobre la libra esterlina.
     */
    static String GBP_CONVERSION = "0.775070";

    /**
     * Mapa que contiene toda la información sobre el sobre el Yen japonés.
     */
    static final private TreeMap< String, String> JPY = new TreeMap<String, String>();

    /**
     * Factor de conversión sobre el Yen japonés.
     */
    static String JPY_CONVERSION = "126.884";

    /**
     * Mapa que contiene toda la información sobre el Yuan chino.
     */
    static final private TreeMap< String, String> CNY = new TreeMap<String, String>();

    /**
     * Factor de conversión sobre el Yuan chino.
     */
    static String CNY_CONVERSION = "7.24294";

    /**
     * Mapa que contiene toda la información sobre el Nuevo Dollar taiwanes.
     */
    static final private TreeMap< String, String> TWD = new TreeMap<String, String>();

    /**
     * Factor de conversión sobre el Nuevo Dollar taiwanes.
     */
    static String TWD_CONVERSION = "36.3828";

    /**
     * Mapa que contiene toda la información sobre el Won Surkoreano.
     */
    static final private TreeMap< String, String> KRW = new TreeMap<String, String>();

    /**
     * Factor de conversión sobre el Won Surkoreano..
     */
    static String KRW_CONVERSION = "1318.94";

    /**
     * Mapa que contiene todos los mapas con todas las relaciones indexadas por su nombre de moneda.
     */
    final public TreeMap<String, TreeMap<String, String>> MAPA_MONEDAS =  new TreeMap<String, TreeMap< String, String>>();


    /**
     * Método constructor. Construye los maps constantes a través de la función {@link MonedasRelacionEuro#RellenarConstantes(Locale, TreeMap, String) }
     */
    public MonedasRelacionEuro() {

        RellenarConstantes(Locale.TAIWAN, TWD, TWD_CONVERSION);
        RellenarConstantes(Locale.US, DOLLAR, DOLLAR_CONVERSION);
        RellenarConstantes(Locale.UK, GBP, GBP_CONVERSION);
        RellenarConstantes(Locale.JAPAN, JPY, JPY_CONVERSION);
        RellenarConstantes(Locale.CHINA, CNY, CNY_CONVERSION);
        RellenarConstantes(Locale.KOREA, KRW, KRW_CONVERSION);
    }
    /**
     * Método que construye los maps individuales de cada moneda en relación al euro y los
     * inserta en el mapa que contiene a todos estos a través del método
     * {@link MonedasRelacionEuro#rellenarMapaMonedas(TreeMap, String)}.
     * @param loc Elemento local para construir el elemento Currency
     * @param tree Árbol para guardar la información.
     * @param conversion Factor de conversión respecto al euro.
     */
    private void RellenarConstantes(Locale loc, TreeMap<String, String> tree, String conversion) {
        Currency currency = Currency.getInstance(loc);
        tree.put("nombre", currency.getDisplayName());
        tree.put("simbolo", currency.getSymbol());
        tree.put("conversion", conversion);
        rellenarMapaMonedas(tree, currency.getDisplayName());
    }

    /**
     * Método que inserta un árbol en un árbol padre con una clave asociada.
     * @param tree Árbol a insertar
     * @param nombre Clave para este árbol en el árbol padre.
     *	void
     */
    private void rellenarMapaMonedas(TreeMap<String, String> tree, String nombre) {
        MAPA_MONEDAS.put(nombre, tree);
    }

}