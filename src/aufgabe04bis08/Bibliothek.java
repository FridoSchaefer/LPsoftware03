package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class Bibliothek {

    /**
     * Main Klasse zur Überprüfung der Methoden
     * @param args
     */
    public static void main(String[] args){

        Zettelkasten zettelkasten = new Zettelkasten();

        zettelkasten.addMedium(new Buch("Duden 01. Die deutsche Rechtschreibung",
                                        2004,
                                        "Bibliographisches Institut, Mannheim",
                                        "3-411-04013-0",
                                        "-"));
        zettelkasten.addMedium(new CD("Live At Wembley","Queen","Parlophone (EMI)"));

       // zettelkasten.sort("A");


        try {zettelkasten.addMedium(new CD("drop", "-", "-"));} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.addMedium(new CD("drop", "-", "-"));} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.addMedium(new Zeitschrift("drop", "-", 0, 0));} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.addMedium(new Zeitschrift("drop", "-", 0, 0));} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.addMedium(new Zeitschrift("drop", "-", 0, 0));} catch (Exception e) {e.printStackTrace();}

        //try {zettelkasten.findMedium("drop");} catch (Exception e) {e.printStackTrace();}
        /*try {zettelkasten.dropMedium("");} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.dropMedium("drop");} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.dropMediumOnDuplicate("", Zettelkasten.TypesOfMedia.ALL);} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.dropMediumOnDuplicate("drop", Zettelkasten.TypesOfMedia.CD);} catch (Exception e) {e.printStackTrace();}
        try {zettelkasten.dropMediumOnDuplicate("drop", Zettelkasten.TypesOfMedia.ALL);} catch (Exception e) {e.printStackTrace();}*/



        /*for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());
        }*/

        /*BinaryPersistency bp = new BinaryPersistency();
        bp.save(zettelkasten, "binaryPersitency_save");

        bp.load("binaryPersitency_save");
        for(Medium medium : zettelkasten){
            System.out.println(medium.calculateRepresentation());
        }*/

        /*HumanReadablePersistency humanReadablePersistency = new HumanReadablePersistency();
        humanReadablePersistency.save(zettelkasten,"testing");
        //humanReadablePersistency.load("testing.txt");

        for(Medium medium : zettelkasten){
            System.out.println(medium.calculateRepresentation());
        }*/

        BibTexPersistency btp = new BibTexPersistency();

        btp.save(zettelkasten, "bibTex");
        //btp.load("bibTex");


        //zettelkasten.findMedium("Duden 01. Die deutsche Rechtschreibung");

        //zettelkasten.dropMedium("Duden 01. Die deutsche Rechtschreibung");




        /*Medium mediumArray[] = new Medium[4];
        mediumArray[0] = new Buch("Duden 01. Die deutsche Rechtschreibung",2004, "Bibliographisches Institut, Mannheim", "3-411-04013-0", "-");
        mediumArray[1] = new CD("1", "Apple (Bea (EMI))", "The Beatles");
        mediumArray[2] = new Zeitschrift("Der Spiegel", "0038-7452", 54, 6);
        mediumArray[3] = new ElektronischesMedium("Hochschule Stralsund", " http://www.hochschule-stralsund.de");*/


        //parseBibTex(mediumArray);

        /*for(int i = 0; i < mediumArray.length; i++){
            System.out.println(mediumArray[i].calculateRepresentation());
        }*/
    }
}
