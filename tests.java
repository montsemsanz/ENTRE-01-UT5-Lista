
/**
 * Write a description of class tests here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tests
{
    // instance variables - replace the example below with your own
    private ListaNumeros lista;

    /**
     * Constructor for objects of class tests
     */
    public tests()
    {
        lista = new ListaNumeros(10);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod()
    {
        lista.addElemento(19);
        lista.addElemento(19);
        lista.addElemento(19);
    }
    
    public int segundo(){
        return lista.segundoMaximo();
    }
    
    public boolean segundosprin(){
        return lista.segundosMaximosAlPrincipio();
    }
}
