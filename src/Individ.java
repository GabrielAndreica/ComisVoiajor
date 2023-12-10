import java.util.ArrayList;
import java.util.Random;
public class Individ {
    ArrayList<Integer> traseu = new ArrayList<Integer>();
    public void generareTraseu(){
        Random rand = new Random();
        for(int i = 0; i < 20; i++){
            traseu.add(rand.nextInt(20));
        }
    }
    public void getTraseu(){
            System.out.println(traseu);
    }
   /*public double distantaTraseu(){
        double contor;
        double x1,x2,y1,y2;
        for(int i = 0; i < 20; i++){

        }
    }
*/
}
