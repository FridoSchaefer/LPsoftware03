package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bibliothek {

    /*private static final String TYPEOFMEDIUM = "@(.[A-Z]*)\\{";
    private static final String VALUEOFMEDIUM = "([A-Z]*) = (\\{(.+?)}|[0-9]+)";*/

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

        zettelkasten.sort("A");

        HumanReadablePersistency humanReadablePersistency = new HumanReadablePersistency();
        humanReadablePersistency.save(zettelkasten,"testing");
        //humanReadablePersistency.load("testing");

        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());
        }

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

    /**
     * Methode zur Überprüfung der User Eingabe
     * @param userInput
     * @return bool
     */
   /* public static boolean isInputAnInt(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }

    public static void parseBibTex(Medium[] parsingArray) {
        Scanner read = new Scanner(System.in);
        String successMessage = "Folgendes Medium wurde erfolgreich hinzugefügt: ";
        int counter = parsingArray.length;

        while(true) {
            System.out.println("Bitte geben sie einen Text in Form vom BibTex Standard ein. Um die Eingabe zu beenden, drücken sie bitte die \"1\"");
            String userInput = read.nextLine();

            //Check ob der USer das Programm abbrechen will
            if (isInputAnInt(userInput) && Integer.parseInt(userInput) == 1) {
                System.out.println("Eingabemöglichkeit wurde beendet.");
                read.close();
                return;
            }

            String[] bibTex = generateBibTex(userInput);
            if (parsingArray.length <= counter) {
                Medium[] tempArr = new Medium[parsingArray.length + 1];
                System.arraycopy(parsingArray, 0, tempArr, 0, parsingArray.length);
                parsingArray = tempArr;
            }

            if (bibTex[0] != null) {
                try {
                    switch (bibTex[0]) {
                        case "book":
                            parsingArray[counter] = new Buch(bibTex[1], Integer.parseInt(bibTex[2]), bibTex[3], bibTex[4], bibTex[5]);
                            System.out.println(successMessage + parsingArray[counter].calculateRepresentation());
                            ++counter;

                            break;
                        case "cd":
                            parsingArray[counter] = new CD(bibTex[1], bibTex[2], bibTex[3]);
                            System.out.println(successMessage + parsingArray[counter].calculateRepresentation());
                            ++counter;

                            break;
                        case "journal":
                            parsingArray[counter] = new Zeitschrift(bibTex[1], bibTex[2], Integer.parseInt(bibTex[3]), Integer.parseInt(bibTex[4]));
                            System.out.println(successMessage + parsingArray[counter].calculateRepresentation());
                            ++counter;
                            break;

                        case "elMed":
                            parsingArray[counter] = new ElektronischesMedium(bibTex[1], bibTex[2]);
                            System.out.println(successMessage + parsingArray[counter].calculateRepresentation());
                            ++counter;
                            break;

                        default:
                            throw new IllegalArgumentException("Die Eingabe enthält kein Medium eines unterstützten Typs!");
                    }
                } catch (Exception e) {
                    System.err.println("BibTex konnte nicht verarbeitet werden mit folgendem Fehler: " + e + " !");
                }
            } else {
                System.err.println("Die Eingabe war an einer unbestimmten Stelle fehlerhaft. Bitte überprüfen sie ihre Eingabe genauer!");
            }
        }
    }

    *//**
     * Methode zur Generierung eines Medium Arrays mithilfe von Regex Gruppen
     * @param userInput
     * @return medium Array
     *//*
    public static String[] generateBibTex(String userInput) {
        String[] inputPosition = new String[6];
        Pattern pTypeOfMedium = Pattern.compile("@(.[A-Z]*)\\{", 2);

        for(Matcher mTypeOfMedium = pTypeOfMedium.matcher(userInput);mTypeOfMedium.find(); inputPosition[0] = mTypeOfMedium.group(1)) {
        }

        Pattern pValueOfMedium = Pattern.compile("([A-Z]*) = (\\{(.+?)}|[0-9]+)", 2);
        Matcher mValueOfMedium = pValueOfMedium.matcher(userInput);

        while(true) {
            while(true) {
                while(mValueOfMedium.find()) {
                    String value = mValueOfMedium.group(2).replace("{", "").replace("}", "");
                    switch (mValueOfMedium.group(1)) {
                        case "title":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[1] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valider Titel übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "year":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[2] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valides Jahr übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "label":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[2] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valides Label übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "issn":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[2] = value;
                                break;
                            }
                            System.err.println("Es wurde keine valide ISSN übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "URL":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[2] = value;
                                break;
                            }
                            System.err.println("Es wurde keine valide URL übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "publisher":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[3] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valider Herausgeber übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "artist":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[3] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valider Künstler übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "volume":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[3] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valides Volume übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "isbn":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[4] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valide ISBN übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "number":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[4] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valide Nummer übergeben!");
                            inputPosition[0] = null;
                            break;

                        case "author":
                            if (value != null && !value.isEmpty()) {
                                inputPosition[5] = value;
                                break;
                            }
                            System.err.println("Es wurde kein valider Autor übergeben!");
                            inputPosition[0] = null;
                            break;

                        default:
                            System.err.println(mValueOfMedium.group(1) + " ist kein vom Format unterstütztes Datenfeld!");
                            inputPosition[0] = null;
                    }
                }
                return inputPosition;
            }
        }
    }*/
}
