import java.io.File;
import java.util.Scanner;
public class Harta {
    Localitate[] localitati = new Localitate[20];
    //se citesc localitatile din csv si se adauga in vectorul localitati
    public void generareHarta() throws Exception{
        Scanner sc = new Scanner(new File("C:\\Users\\Gabriel\\Proiecte\\Programare\\Proiect_Voiajor\\ComisVoiajor\\src\\coordonate_loc.csv"));
        sc.useDelimiter(",");
        for(int i = 0; i < 20; i++){
            localitati[i] = new Localitate();
            localitati[i].setnume(sc.next());
            localitati[i].setx(Double.parseDouble(sc.next()));
            localitati[i].sety(Double.parseDouble(sc.next()));
            localitati[i].setIndex(i);
        }
    }
    //returneaza numele unei localitati precizate prin index i
    public String getLocalitate(int i){
        return localitati[i].getnume();
    }
}
