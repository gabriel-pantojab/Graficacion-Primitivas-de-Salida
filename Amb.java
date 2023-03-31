
/**
 * Write a description of class Amb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Amb
{
    int x = 1;
    public void uno () {
        int x = 5;
        System.out.println("La variable local en uno es: "+x);
        a();
        b();
        System.out.println("La variable local en uno es: "+x);
    }
    
    void a () {
        int x = 25;
        System.out.println("La variable x local en a es: "+x);
        x++;
        System.out.println("La variable x local en a es: "+x+" antes de salir");
    }
    
    void b () {
        System.out.println("\n La variable x es: "+x+" al ingresar en b");
        x*=10;
        System.out.println("La variable x es: "+x+" al salir de b");
    }
    
    public static void main (String args[]) {
        Amb s = new Amb();
        s.uno();
    }
}
