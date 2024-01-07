import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Individ {
    public ArrayList<Integer> traseu = new ArrayList<Integer>();
    //se calculeaza distanta dintre 2 puncte tinand cont de latitudine, longitudine si o raza aproximativa a pamantului (luat integral de pe internet)
    public static double haversine(double lat1, double lon1,
                                   double lat2, double lon2) {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
    //se genereaza random un traseu
    public void generareTraseu() {
        Random rand = new Random();
        for (int i = 0; i < 19; i++){
            traseu.add(rand.nextInt(20));
        }
    }
    //se returneaza vectorul ce contine ordinea in care sunt parcurse localitatile dintr-un traseu
    public ArrayList<Integer> getTraseu() {
        return this.traseu;
    }
    //se seteaza localitatile in vectorul ce contine ordinea lor
    public void setTraseu(ArrayList<Integer> traseu1) {
        for (int i = 0; i < 19; i++){
            traseu.add(traseu1.get(i));
        }
    }
    //se calculeaza distanta totala a unui traseu
    public double getDistance(Harta harta) {
        double distantaTotala = 0, x1, y1, x2, y2;
        Localitate start = harta.localitati[0];
        x2 = harta.localitati[0].getx();
        y2 = harta.localitati[0].gety();
        distantaTotala += haversine(start.getx(), start.gety(), x2, y2);
        for (int i = 0; i < 18; i++) {
            x1 = harta.localitati[this.traseu.get(i)].getx();
            y1 = harta.localitati[this.traseu.get(i)].gety();
            x2 = harta.localitati[this.traseu.get(i + 1)].getx();
            y2 = harta.localitati[this.traseu.get(i + 1)].gety();
            distantaTotala += haversine(x1, y1, x2, y2);
        }
        x1 = harta.localitati[this.traseu.get(18)].getx();
        y1 = harta.localitati[this.traseu.get(18)].gety();
        distantaTotala += haversine(x1, y1, start.getx(), start.gety());
        return distantaTotala;
    }
    //se schimba 2 gene intre ele
    public void mutatie() {
        Random rand = new Random();
        int loc1 = rand.nextInt(19);
        int loc2 = rand.nextInt(19);
        Collections.swap(traseu, loc1, loc2);
    }
    //se inlocuiesc localitatile care apar mai mult de 1 data, cu cele care nu apar deloc pentru traseul actual
    public void reparare() {
        int[] vectorfrecventa = new int[20];
        for(int i = 0; i < 20; i++){
            vectorfrecventa[i] = 0;
        }
        for(int i = 1; i < 19; i++){
            vectorfrecventa[traseu.get(i)] += 1;
        }
        for (int i = 1; i < 19; i++) {
            if (vectorfrecventa[i] > 1) {
                for (int j = 1; j < 19; j++) {
                    if (vectorfrecventa[j] == 0) {
                        for (int k = 0; k < 19; k++) {
                            if (traseu.get(k) == i) {
                                traseu.set(k, j);
                                vectorfrecventa[i] -= 1;
                                vectorfrecventa[j] += 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}