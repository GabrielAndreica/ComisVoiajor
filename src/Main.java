public class Main {
    public static void main(String[] args) throws Exception {
        Harta harta = new Harta();
        harta.generareHarta();

        Generatie gen = new Generatie();
        gen.crearePrimaGeneratie();

        for(Individ i : gen.generatie1){
            i.getDistance(harta);
        }

        for(int i = 0; i < 10; i++){
            System.out.println(gen.generatie1[i].getTraseu());
        }

        System.out.println('\n');

        gen.incrucisare();

        System.out.println('\n');
        for(int i = 0; i < 10; i++){
            System.out.println(gen.generatie2[i].getTraseu());
        }
    }
}