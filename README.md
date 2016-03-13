  <img src="./img/java.png" align="left" width="22%">

# Práctica 4 Modelo vista controlador.

## Repositorio PAI-practica5
Los objetivos de esta práctica son:

* Diseño e implementación de interfaces gráficas de usuario.

* Conocer y ejercitar el patrón de diseño MVC.



* author  Carlos Troyano Carmona
* version 1.1
* since   2016-03-16
* [Página del repositorio](http://ctc87.github.io/PAI-practica5/doc/index.html)

### modelo
Este paquete contiene todo lo relacionado con los datos del problema.

#### MonedasRelacionEuro:

* MonedasRelacionEuro es la clase que forma parte del modelo de la aplicación. Contiene las relaciones entre las distintas monedas y el euro. Se utiliza para después hacer cambios de moneda y acceder al nombre de la moneda o a su símbolo.

* [Cabeceras  documentadas](https://github.com/ctc87/PAI-practica5/blob/gh-pages/src/modelo/MonedasRelacionEuro.java)


#### Conversor:

* Conversor es la clase un objeto de la clase MonedasRelacionEuro y lo utiliza para crear un árbol con los valores de cambio de dicha moneda respecto a una cantidad de euros de entrada. Forma parte del modelo y es utilizado directamente por el controlador para gestionar la vista. Que no es más que la interfaz del programa

* [Cabeceras  documentadas](https://github.com/ctc87/PAI-practica5/blob/gh-pages/src/modelo/Conversor.java)

### vista
* Vista es el paquete que contiene todo lo realcionado con la vista en el probelma. Es decir la interfaz gráfica. Y todos los métodos que la gestionan.

#### PanelMoneda:

* PanelMoneda es una clase que hereda de Jpanel. Por lo tanto es un panel personalizado. Crea un panel personalizado con métodos que permiten insertar los textos necesarios para mostrar en GUI.
Esta clase pertenece a la vista. Es utilizada por la clase vista para generar distintas instancias de paneles personalizados.

* [Cabeceras  documentadas](https://github.com/ctc87/PAI-practica5/blob/gh-pages/src/vista/PanelMoneda.java)


#### VistaCambioDivisas:
* VistaCambioDivisas es la clase que genera las vistas de la aplicación Cambio de divisas. Esta extiende Jframe, por lo que es una ventana personalizada.
Utiliza la clase PanelMoneda Para generar paneles a través de un TreeMap. Así el controlador le facilita esta estructura las veces necesarias para generar las vistas de cambios a distintas divisas, siendo está independiente de el modelo y únicamente gestionada por el controlador.

* [Cabeceras  documentadas](https://github.com/ctc87/PAI-practica5/blob/gh-pages/src/vista/VistaCambioDivisas.java)


### controlador
  Controlador es el paquete que hace de intermediario entre la vsita y el modelo.

#### ControladorCambioDivisas:
* ControladorCambioDivisas es la clase que hace de controlador entre la vista VistaCambioDivisas y el modelo Conversor. Este comunica a la vista los datos recibidos por el modelo Genera un mapa con los datos del modelo que son cargados en la vista que acepta este tipo de objetos para generarse.

* [Cabeceras  documentadas](https://github.com/ctc87/PAI-practica5/tree/gh-pages/src/controlador)
