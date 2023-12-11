public class Localitate {
    private int index;
    private double x;
    private double y;
    private String nume;
    public int getIndex(){
        System.out.println(this.index);
        return this.index;
    }
    public double getx(){
        return this.x;
    }
    public double gety(){
        return this.y;
    }
    public String getnume(){
        return this.nume;
    }
    public void setIndex(int valoare){
        this.index = valoare;
    }
    public void setx(double valoare){
        this.x = valoare;
    }
    public void sety(double valoare){
        this.y = valoare;
    }
    public void setnume(String valoare){
        this.nume = valoare;
    }
}