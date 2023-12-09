public class Generatie {
    Individ[] generatie = new Individ[10];
    public void creareGeneratii(){
        for(int i = 0; i < 10; i++){
            generatie[i] = new Individ();
            generatie[i].generareTraseu();
            generatie[i].getTraseu();
        }
    }
}
