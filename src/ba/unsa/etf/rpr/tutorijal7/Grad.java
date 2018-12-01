package ba.unsa.etf.rpr.tutorijal7;

public class Grad {
    String naziv;
    int brojStanovnika;
    double[] temperature = new double[1000];
    int brojMjerenja;

    public Grad() {
    }

    public Grad(String naziv,  double[] temperature,int brojMjerenja) {
        this.naziv = naziv;
        this.brojStanovnika = 0;
        this.brojMjerenja=brojMjerenja;
        this.setTemperature(temperature,brojMjerenja);

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
