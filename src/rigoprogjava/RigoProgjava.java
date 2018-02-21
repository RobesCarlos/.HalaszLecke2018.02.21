package rigoprogjava;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class RigoProgjava {
    private static Map<String, Felhasznalo> felhasznalok = new TreeMap<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg email címed!");
        String mailCim = sc.nextLine();
        System.out.println("Add meg a neved!");
        String nev = sc.nextLine();
        felhasznalok.put(mailCim, new Felhasznalo(mailCim, nev));
        
        System.out.println("Üzeneteid: ");
        felhasznalok.get("[Feladoneve]").ujFogadott(new KonstruktorMess("[Feladoneve]", "[Üzenet]", "[Cimzettneve]"));
        felhasznalok.get("[Feladoneve]").getUzenetek();
    }  
}
    
   class Felhasznalo{
       private String nev;
       private String mailCim;

       private Set<KonstruktorMess> bejovoUzenetek = new HashSet<>();
       private Set<KonstruktorMess> kimenoUzenetek = new HashSet<>();


       public Felhasznalo( String mailCim, String nev) {
           this.nev = nev;
           this.mailCim = mailCim;
       }



       public void ujFogadott(KonstruktorMess yk2){
           bejovoUzenetek.add(yk2);
       }
       public void ujKuldott(KonstruktorMess yk2){
           kimenoUzenetek.add(yk2);
       }



       public void getUzenetek(){
           for(KonstruktorMess elem: bejovoUzenetek){
               System.out.println(elem);
           }
           for(KonstruktorMess elem: kimenoUzenetek){
               System.out.println("\r\r" + elem);
           }
       }

       @Override
       public String toString(){
           return "Email: " + mailCim + " | Név: "+ nev;
       }
   }

   class KonstruktorMess{
       private String fromName;
       private String szovegKuldott;
       private String forName;

       public KonstruktorMess(String fromName, String szovegKuldott, String forName) {
           this.fromName = fromName;
           this.szovegKuldott = szovegKuldott;
           this.forName = forName;
       }


       public String getFromName() {
           return fromName;
       }
       public String getSzovegKuldott() {
           return szovegKuldott;
       }
       public String getForName() {
           return forName;
       }



       @Override
       public String toString(){
           return "Felado neve: " +fromName+ " \tCímzett: " +forName+ " \n "+szovegKuldott;
       }
    }
