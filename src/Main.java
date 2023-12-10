import java.lang.Math;
public class Main {


    public static void main(String[] args) throws Exception {
        Harta harta = new Harta();
        harta.generareHarta();


        Generatie gen = new Generatie();
        gen.creareGeneratii();

        double distantaTotala = 0, x1, y1, x2, y2, dx, dy;
        for(int i = 0; i < 19; i++){
            x1 = harta.localitati[gen.generatie[0].traseu.get(i)].getx();
            x2 = harta.localitati[gen.generatie[0].traseu.get(i+1)].getx();
            y1 = harta.localitati[gen.generatie[0].traseu.get(i)].gety();
            y2 = harta.localitati[gen.generatie[0].traseu.get(i+1)].gety();

            dx = x2 - x1;
            dy = y2 - y1;
            distantaTotala = Math.sqrt(dx * dx + dy * dy);

        }

        System.out.println(distantaTotala);


    }

}