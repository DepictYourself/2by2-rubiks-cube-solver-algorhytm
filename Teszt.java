package rubik;

public class Teszt {

    public static void main(String[] args){
        Kocka k = new Kocka();
        
        k.getfeltoltes();
        System.out.println(k.toString());
        
        k.keveres();
        System.out.println(k.toString());
        
        k.kirakas();        
        System.out.println("forgatások száma: "+k.getP());
        System.out.println(k.getSt());
        System.out.println(k.toString());
    }
}
