import java.util.Random;
import java.util.Arrays;
/**
 * Un objeto de esta clase
 * guarda una lista de números enteros
 * 
 * La clase incluye una serie de métodos de instancia
 * para hacer operaciones sobre la lista
 * y dos  métodos estáticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author - David Sena
 *
 */

public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    private int[] lista;
    private int pos;

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor al final de la lista 
     * siempre que no esté completa
     *
     * @param numero el valor que se añade.  
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        boolean elmAñadido = false;
        if(!estaCompleta()){
            lista[pos] = numero;
            pos++;
            elmAñadido = true;
        }
        return elmAñadido;
    }

    /**
     * @return true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return pos == lista.length;

    }

    /**
     * @return true si la lista está vacía, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;

    }

    /**
     * @return el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        pos = 0;
    }

    /**
     * @return una cadena con representación textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
        String texto = "";
        String cabecera = "";
        if(!estaVacia()){
            for(int i = 0; i < pos; i++){
                for(int j = 0; j < 6; j++){
                    cabecera += CAR_CABECERA;
                }

            }
            texto +=cabecera + "\n";
            for(int i = 0; i < pos; i++){
                texto += Utilidades.centrarNumero(lista[i], ANCHO_FORMATO);               
            }
            texto +="\n" + cabecera;
        }
        else{
            return "";
        }
        return texto;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor máximo en la lista
     * Cuando no haya un segundo máximo el método 
     * devolverá el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {       
        int primerMax = Integer.MIN_VALUE;
        for(int i = 0; i< pos; i++){
            if(lista[i] > primerMax){
                primerMax = lista[i];
            }
        }
        int segundoMax = Integer.MIN_VALUE;
        for(int j = 0; j< pos; j++){
            if(lista[j] > segundoMax && lista[j] < primerMax){
                segundoMax = lista[j];
            }
        }
        return segundoMax;
    }

    /**
     * El método coloca los valores que son segundos máximos al principio de
     * la lista respetando el orden de aparición del resto de elementos
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
    i     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos máximos
     *          false si no se han colocado los segundos máximos porque no había ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        return false;

    }

    /**
     * @param numero búsqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posición en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente métodos de la clase Arrays
     */
    public int buscarBinario(int numero) {
        int[] copia = new int[lista.length];
        System.arraycopy(lista, 0,copia, 0, pos);
        Arrays.sort(copia);
        int busqueda = Arrays.binarySearch(copia, numero);
        if(busqueda < 0){
            return -1;
        }   
        return busqueda;
    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tamaño DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
        int[][] brillo = new int[DIMENSION][DIMENSION];
        for(int i = 0; i < DIMENSION; i++){
            for(int j = 0; j<brillo[i].length;j++){
                brillo[i][j] = generador.nextInt(11);    
            } 
        }

        return brillo;
    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posición f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int[][] brillos) {
        int suma = 0;
        boolean[][] estrella =  new boolean[brillos.length][brillos[0].length];
        for(int f = 1; f < brillos.length-1; f++){
            for(int c = 1; c<brillos[f].length-1;c++){
                brillos[f][c] = generador.nextInt(11);

                if ((brillos[f+1][c] + brillos[f-1][c] + brillos[f][c+1] + brillos[f][c-1]) > 30){
                    estrella[f][c] = true;
                }
                else{
                    estrella[f][c] = false;
                }
            }
        }

        return estrella;  
    }
}
