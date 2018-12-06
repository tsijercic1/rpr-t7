package ba.unsa.etf.rpr.tutorijal7;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tutorijal {
    public static void main(String[] args) {
	// write your code here
        ArrayList<Grad> gradovi;
        gradovi=ucitajGradove();
        for(int i=0;i<gradovi.size();i++){
            System.out.println(gradovi.get(i).getNaziv());
        }


    }

    public static UN ucitajXml(ArrayList<Grad> gradovi){
        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }
        UN un = new UN();
        ArrayList<Drzava> drzave = new ArrayList<>();

        NodeList drzaveXml = xmldoc.getElementsByTagName("drzava");

        for(int i = 0; i < drzaveXml.getLength(); i++) {
            Node drzavaNode = drzaveXml.item(i);

            if(drzavaNode instanceof Element) {
                Element drzavaEl = (Element)drzavaNode;

                int stanovnika = Integer.parseInt(drzavaEl.getAttribute("stanovnika"));
                String naziv = drzavaEl.getElementsByTagName("naziv").item(0).getTextContent();

                Element gGradXml = (Element)drzavaEl.getElementsByTagName("glavnigrad").item(0);
                int gStanovnika = Integer.parseInt(gGradXml.getAttribute("stanovnika"));
                String nazivGrada = gGradXml.getTextContent().trim();

                Element povrsinaXml = (Element)drzavaEl.getElementsByTagName("povrsina").item(0);
                String jedinica = povrsinaXml.getAttribute("jedinica");
                double povrsina = Double.parseDouble(drzavaEl.getElementsByTagName("povrsina").item(0).getTextContent());

                Grad glavniGrad = new Grad(nazivGrada, null, 0,stanovnika);
                drzave.add(new Drzava(naziv, stanovnika, povrsina, jedinica, glavniGrad));
            }
        }

        un.setDrzave(drzave);
        return un;
    }


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
}

