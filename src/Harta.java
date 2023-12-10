import java.io.File;
import java.io.FileReader;
import java.security.PublicKey;
import java.util.Scanner;

public class Harta {

    /*private int[] v = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10};

    public int[] getcoord(){

        for(int i = 0; i<=9; i++){

            System.out.print(v[i] + " ");

        }
        return v;

    }

    Localitate loc1 = new Localitate();
    Localitate loc2 = new Localitate();
    Localitate loc3 = new Localitate();
    Localitate loc4 = new Localitate();
    Localitate loc5 = new Localitate();
*/
    Localitate[] localitati = new Localitate[20];

    public void generareHarta() throws Exception{
        Scanner sc = new Scanner(new File("C:\\Users\\USER\\Documents\\GitHub\\ComisVoiajor\\src\\Coordonate_localitati.csv"));
        sc.useDelimiter(",");
        double valoare;
        for(int i = 0; i < 20; i++){
            localitati[i] = new Localitate();
            localitati[i].setnume(sc.next());
            localitati[i].setx(Double.parseDouble(sc.next()));
            localitati[i].sety(Double.parseDouble(sc.next()));
            localitati[i].setIndex(i);
        }

    }




}
