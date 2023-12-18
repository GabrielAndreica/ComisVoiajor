import java.util.ArrayList;
import java.util.Random;

public class Generatie {
    Individ[] generatie1 = new Individ[10];
    Individ[] generatie2 = new Individ[10];
    public void crearePrimaGeneratie(){
        for(int i = 0; i < 10; i++){
            generatie1[i] = new Individ();
            generatie1[i].generareTraseu();
        }
    }

    public void incrucisare(){

        for(int i = 0; i < 10; i++){
            generatie2[i] = new Individ();
        }

        Random rand = new Random();
        int punctTaietura;
        ArrayList<Integer> traseu3 = new ArrayList<Integer>();
        ArrayList<Integer> traseu4 = new ArrayList<Integer>();

        for(int i = 0; i <10; i += 2){

            punctTaietura = rand.nextInt(20);
            System.out.println(punctTaietura);
            traseu3.clear();
            traseu4.clear();

            for(int j = 0; j < 19; j++){
                if(j <= punctTaietura){
                    traseu3.add(generatie1[i].getTraseu().get(j));
                    traseu4.add(generatie1[i + 1].getTraseu().get(j));
                }else {
                    traseu3.add(generatie1[i + 1].getTraseu().get(j));
                    traseu4.add(generatie1[i].getTraseu().get(j));
                }
            }

            generatie2[i].setTraseu(traseu3);
            generatie2[i].mutatie();
            generatie2[i+1].setTraseu(traseu4);
            generatie2[i+1].mutatie();
        }
    }
}
