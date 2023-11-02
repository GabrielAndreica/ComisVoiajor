public class Localitate {

    private int x;
    private int y;

    private String nume;

    public int getx(){

        System.out.println(this.x);
        return this.x;

    }

    public int gety(){

        System.out.println(this.y);
        return this.y;

    }

    public void getnume(){

        System.out.println(this.nume);

    }

    public void setx(int valoare){

        this.x = valoare;

    }

    public void sety(int valoare){

        this.y = valoare;

    }

    public void setnume(String valoare){

        this.nume = valoare;

    }


}
