public class Main {
    public static void main(String[] args) throws Exception {
        int nrGeneratii = 0;
        //se genereaza harta cu localitatile si inf. aferente
        Harta harta = new Harta();
        harta.generareHarta();
        //se genereaza prima generatie de trasee random
        Generatie gen = new Generatie();
        gen.crearePrimaGeneratie();
        //se inlocuiesc localitatile care apar mai mult de 1 data, cu cele care nu apar deloc pentru toate traseele din prima generatie
        gen.reparareGeneratie();
        //se returneaza cel mai fit traseu din prima generatie
        gen.celmaiFit(harta);
        //decursul a 100.000 generatii (1.000.000 trasee)
        while(nrGeneratii < 100000){
            //se sorteaza vectorul de trasee crescator in functie de fitness (distanta totala)
            gen.sortareGeneratie(harta);
            //se realizeaza crossover-ul
            gen.incrucisare();
            //se inlocuiesc localitatile care apar mai mult de 1 data, cu cele care nu apar deloc pentru toate traseele din generatie
            gen.reparareGeneratie();
            //se returneaza cel mai fit traseu din generatia curenta
            gen.celmaiFit(harta);
            nrGeneratii += 1;
        }
        //se afiseaza cel mai bun si cel mai slab traseu generat
        System.out.println("\n====");
        System.out.println("Cel mai fit traseu din toate generatiile este de: " + gen.getCelmaiFitOverall() + " km");
        System.out.println("Cel mai putin fit traseu din toate generatiile este de: " + gen.getCelmaiputinfitOverall() + " km");
    }
}