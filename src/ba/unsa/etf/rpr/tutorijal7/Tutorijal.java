package ba.unsa.etf.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tutorijal {
    public static ArrayList<Grad> ucitajGradove(){
        ArrayList<Grad> gradovi=new ArrayList<>();
        Scanner tok = null;
        try {
            tok = new Scanner(new FileReader("mjerenja.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        String naziv="";
        double[] mjerenja=new double[1000];

        int j=0;
        String temp="";

        while(tok.hasNext()){
            temp=tok.nextLine();
            temp=temp.replace(',','\n');
            Scanner mojParser=new Scanner(temp);
            naziv=mojParser.nextLine();
            for(int i=0;mojParser.hasNextLine()&&i<1000;i++,j++){
                mjerenja[i]=mojParser.nextDouble();
            }
            gradovi.add(new Grad(naziv,mjerenja,j));
            j=0;
        }
        return gradovi;
    }
    public static void main(String[] args) {
	// write your code here
        ArrayList<Grad> gradovi;
        gradovi=ucitajGradove();
        for(int i=0;i<gradovi.size();i++){
            System.out.println(gradovi.get(i).getNaziv());
        }


    }
}

