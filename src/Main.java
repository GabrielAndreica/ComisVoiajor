public class Main {
    public static void main(String[] args) {

        Harta harta = new Harta();

        int[] v;

        v = harta.getcoord();

        harta.loc1.setx(v[0]);
        harta.loc1.sety(v[1]);
        harta.loc2.setx(v[2]);
        harta.loc2.sety(v[3]);
        harta.loc3.setx(v[4]);
        harta.loc3.sety(v[5]);
        harta.loc4.setx(v[6]);
        harta.loc4.sety(v[7]);
        harta.loc5.setx(v[8]);
        harta.loc5.sety(v[9]);

    }
}