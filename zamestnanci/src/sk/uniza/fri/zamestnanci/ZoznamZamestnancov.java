
package sk.uniza.fri.zamestnanci;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vaclavko
 * trieda urcena studentom
 */
public class ZoznamZamestnancov {
    private ArrayList<Zamestnanec> pracovnici;
  
   
   
    public ZoznamZamestnancov() {
        this.pracovnici = new ArrayList<Zamestnanec> ();
        
    }

    public boolean addZamestnanca(Zamestnanec zamestnanec) {

        return this.pracovnici.add(zamestnanec);
    }
       
    public String toString()   {
        String ret = String.format("V nasom podniku pracuju nasledovni zamestnanci: %n")  ;
        for (Zamestnanec pomZam : this.pracovnici) {
            ret = ret + pomZam + "\n";
        }
        return ret; 
    }
    
    public Zamestnanec poskytniZamestnanca(int osobneCislo) {
        Zamestnanec hladany = null;
        boolean nasiel = false;
        int i = 0;
      
        while ((!nasiel) && (this.pracovnici.size() > i )) {
            Zamestnanec pomZam = this.pracovnici.get(i);
            if (pomZam.getOsobneCislo() == osobneCislo) {
                hladany = pomZam;
                nasiel = true;
            }
            i++;  
        }
        return hladany;   
    }    
    
    public boolean nastavOdmenyZamestnancovi(int osobneCislo, int odmeny) {
        Zamestnanec zam = this.poskytniZamestnanca(osobneCislo);
        if (zam != null)  {
            zam.setOdmeny(odmeny);
            return true;
        } else {
            return false;
        }
    }
    
    
    
    public Zamestnanec najdiNajmenejZarabajuceho() {
        Zamestnanec min = null;
        double minPlat = Double.MAX_VALUE;
        for (Zamestnanec pomZam : this.pracovnici) {
            if (pomZam.getCelkovyPlat() < minPlat) {
                min = pomZam;
                minPlat = pomZam.getCelkovyPlat();
            }
        }
        return min; 
    }

    public void zapisDoTextovehoSuboru(String nazovSuboru) {
        try {
            FileOutputStream fos = new FileOutputStream(nazovSuboru);
            PrintStream zapisovac = new PrintStream(fos);
            zapisovac.println("v nasom podniku pracuju nasledovni zamestnanci: \n");
            for (Zamestnanec z : this.pracovnici) {
                zapisovac.println(z + "\n");
            }
            zapisovac.close();
        } catch (IOException ex) {
            System.out.println("doslo k chybe pri zapise do suboru" + ex.getMessage());
        }
    }

    public void citajOdmenyZTextovehoSuboru(String nazovSuboru) {
        try {
            FileInputStream fis = new FileInputStream(nazovSuboru);
            Scanner citac = new Scanner(fis);

            while (citac.hasNextInt()) {
                int cisloZamestnanca = citac.nextInt();
                int vyskaOdmeny = citac.nextInt();
                Zamestnanec jeden = null;
                try {
                    jeden = this.poskytniZamestnanca(cisloZamestnanca);
                    jeden.setOdmeny(vyskaOdmeny);
                } catch (IllegalArgumentException iex) {
                    System.out.println(iex.getMessage());
                }


            }
            citac.close();
        } catch (IOException ioex) {
            System.out.println("Doslo k chybe pri citani suboru " + ioex.getMessage());
        }
    }

    public void citajOdmenyZBinarnehoSuboru(String nazovSuboru) {
        DataInputStream subor = null;
        boolean koniecSuboru = false;

        try {
            //otvorime streamy
            FileInputStream fos = new FileInputStream(nazovSuboru);
            BufferedInputStream bos = new BufferedInputStream(fos);
            subor = new DataInputStream(bos);

            //osetrenie moznych chyb
        } catch (IOException e) {
            System.out.println("Doslo k chybe pri praci so suborom " + e.getMessage());
            koniecSuboru = true;
        }
        //pokial este je co citat
        while (!koniecSuboru) {
            try {
                int cisloZamestnanca = subor.readInt();
                int vyskaOdmeny = subor.readInt();
                Zamestnanec jeden = null;
                try {
                    jeden = this.poskytniZamestnanca(cisloZamestnanca);
                    jeden.setOdmeny(vyskaOdmeny);
                } catch (IllegalArgumentException eex) {
                    //nenaslo zamestnanca
                    System.out.println(eex.getMessage());
                }

            } catch (EOFException e) {
                //neexistuje test na koniec suboru alebo hasNext?? a tak to zachytime ako vynimku
                System.out.println("Koniec suboru");
                koniecSuboru = true;
            } catch (Exception e2) {
                //ak nastanu ine vynimky
                System.out.println("Chyba pri citani z binarneho suboru " + e2.getMessage());
            }
        }


        if ((koniecSuboru) && (subor != null)) {
            try {
                subor.close();
                //close moze vyvolat vynimku
            } catch (IOException e) {
                System.out.println("Chyba pri zatvarani suboru " + e.getMessage());
            }
        }



    }

}
