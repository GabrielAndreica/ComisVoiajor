import java.util.ArrayList;
import java.util.Random;
public class Individ {
    ArrayList<Integer> localitati = new ArrayList<Integer>();
    public void generareTraseu(){
        Random rand = new Random();
        for(int i = 0; i < 5; i++){
            localitati.add(rand.nextInt(5));
        }
    }
    public void getTraseu(){
            System.out.println(localitati);
    }
}
