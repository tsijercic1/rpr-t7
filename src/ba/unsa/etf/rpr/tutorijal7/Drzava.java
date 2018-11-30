package ba.unsa.etf.rpr.tutorijal7;

public class Drzava {
    String naziv;
    int brojStanovnika;
    double povrsina;
    String jedinicaPovrsine;
    Grad glavniGrad;

    public Drzava() {
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

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinicaPovrsine() {
        return jedinicaPovrsine;
    }

    public void setJedinicaPovrsine(String jedinicaPovrsine) {
        this.jedinicaPovrsine = jedinicaPovrsine;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
