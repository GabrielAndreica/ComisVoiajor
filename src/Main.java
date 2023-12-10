public class Main {
    public static void main(String[] args) throws Exception {
        Harta harta = new Harta();
        harta.generareHarta();
        harta.localitati[3].getnume();
        harta.localitati[3].getx();
        harta.localitati[3].gety()  ;

        Generatie gen = new Generatie();
        gen.creareGeneratii();
    }
}