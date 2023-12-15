import java.lang.Math;
public class Main {
    public static void main(String[] args) throws Exception {
        Harta harta = new Harta();
        harta.generareHarta();
        Generatie gen = new Generatie();
        gen.creareGeneratii();
        for(Individ i : gen.generatie){
            i.getDistance(harta);
        }
    }
}