import java.util.ArrayList;
import java.util.Random;
public class Generatie {
    Individ[] generatie1 = new Individ[10];
    Individ[] generatie2 = new Individ[10];
    Individ temporar = new Individ();
    private double celmaiFitOverall = 10000;
    private double celmaiputinfitOverall = 0;
    //returneaza cel mai fit traseu din toate generatiile
    public double getCelmaiFitOverall(){
        return this.celmaiFitOverall;
    }
    //returneaza cel mai putin fit traseu din toate generatiile
    public double getCelmaiputinfitOverall(){
        return this.celmaiputinfitOverall;
    }
    //seteaza valoarea celui mai fit individ
    public void setCelmaiFitOverall(double fitness){
        this.celmaiFitOverall = fitness;
    }
    //seteaza valoarea celui mai putin fit individ
    public void setCelmaiputinfitOverall(double fitness){
        this.celmaiputinfitOverall = fitness;
    }
    //se genereaza prima generatie de 10 indivizi random
    public void crearePrimaGeneratie(){
        for(int i = 0; i < 10; i++){
            generatie1[i] = new Individ();
            generatie1[i].generareTraseu();
        }
    }
    //crossover unde se aplica si mutatia la sfarsit
    public void incrucisare(){
        for(int i = 0; i < 10; i++){
            generatie2[i] = new Individ();
        }
        Random rand = new Random();
        int punctTaietura;
        ArrayList<Integer> traseu3 = new ArrayList<Integer>();
        ArrayList<Integer> traseu4 = new ArrayList<Integer>();
        for(int i = 0; i <10; i += 2){
            punctTaietura = rand.nextInt(5,15);
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
        for(int i = 0; i < 10; i ++){
            generatie1[i] = generatie2[i];
        }
    }
    //se inlocuiesc localitatile care apar mai mult de 1 data, cu cele care nu apar deloc
    public void reparareGeneratie() {
        for (int i = 0; i < 10; i++) {
            generatie1[i].reparare();
        }
    }
    //se returneaza cel mai fit traseu din generatia curenta
    public int celmaiFit(Harta harta){
        ArrayList<Double> fitnessGeneratie = new ArrayList<Double>();
        double fitnessMax = 100000;
        double fitnessMin = 0;
        int indexCelmaifit = 0;
        for(Individ i : generatie1){
            fitnessGeneratie.add(i.getDistance(harta));
        }
        for(int i = 0; i < 10; i++){
            if(fitnessMax > fitnessGeneratie.get(i)){
                fitnessMax = fitnessGeneratie.get(i);
                indexCelmaifit = i;
            }else if(fitnessMin < fitnessGeneratie.get(i)){
                fitnessMin = fitnessGeneratie.get(i);
            }if(fitnessMax < getCelmaiFitOverall()){
                setCelmaiFitOverall(fitnessMax);
            }if(fitnessMin > getCelmaiputinfitOverall()){
                setCelmaiputinfitOverall(fitnessMin);
            }
        }
        System.out.print("Traseul cel mai fit din aceasta generatie are " + fitnessMax + " km \n");
        fitnessGeneratie.clear();
        return indexCelmaifit;
    }
    //se sorteaza vectorul de trasee crescator in functie de fitness (distanta totala), folosind BUBBLE SORT
    public void sortareGeneratie(Harta harta){
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 9; j++){
                if(generatie1[j].getDistance(harta) > generatie1[j + 1].getDistance(harta)){
                    temporar = generatie1[j + 1];
                    generatie1[j + 1] = generatie1[j];
                    generatie1[j] = temporar;
                }
            }
        }
    }
}
