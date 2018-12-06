package ba.unsa.etf.rpr.tutorijal7;

public class Grad {
    private String naziv;
    private int brojStanovnika;
    private double[] temperature = new double[1000];
    private int brojMjerenja;

    public Grad() {
    }

    public Grad(String naziv,  double[] temperature,int brojMjerenja) {
        this.naziv = naziv;
        this.brojStanovnika = 0;
        this.brojMjerenja=brojMjerenja;
        this.setTemperature(temperature,brojMjerenja);
    }
    public Grad(String naziv, double[] temperature, int brojMjerenja, int brojStanovnika){
        this.naziv=naziv;
        this.brojMjerenja=brojMjerenja;
        setTemperature(temperature,brojMjerenja);
        this.brojStanovnika=brojStanovnika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double[] getTemperature() {
        return temperature.clone();
    }

    public void setTemperature(double[] temperature,int brojMjerenja) {
        System.arraycopy(temperature, 0, this.temperature, 0, brojMjerenja);
    }
}
