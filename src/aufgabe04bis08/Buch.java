package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class Buch extends Medium{

    private int erscheinungsjahr;
    private String verlag;
    private String ISBN;
    private String Author;

    /**
     * Konstruktor
     * @param _titel
     * @param _erscheinungsjahr
     * @param _verlag
     * @param _isbn
     * @param _author
     */
    public Buch(String _titel, int _erscheinungsjahr, String _verlag, String _isbn, String _author){
        super(_titel);
        setErscheinungsjahr(_erscheinungsjahr);
        setVerlag(_verlag);
        setISBN(_isbn);
        setAuthor(_author);
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int _erscheinungsjahr) {
        this.erscheinungsjahr = _erscheinungsjahr;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String _verlag) {
        if(_verlag.isBlank()){
            throw new IllegalArgumentException("Eingegebener Verlag ist ungültig!");
        }else
        {
            this.verlag = _verlag;
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String _ISBN) {

        /**
         * Konvertierung des übergebenen Strings in einen Integer Array
         */
        String numberIsbnStr = _ISBN.replaceAll("-","");
        int[] isbnArr = new int[numberIsbnStr.length()];
        char[] numberStrArray = numberIsbnStr.toCharArray();
        for(int i = 0; i < numberStrArray.length; i++){
            isbnArr[i] = Character.getNumericValue(numberStrArray[i]);
        }

        /**
         * einfache Überprüfung der Länge und korrektheit der ISBN mit einer Hilfsvariable
         */
        boolean check = false;
        if(isbnArr.length == 13){
            check = checkISBN13(isbnArr);
        } else if (isbnArr.length == 10) {
            check = checkISBN10(isbnArr);
        }else{
            this.ISBN = null;
            throw new IllegalArgumentException("Die eingegebene ISBN hate nicht die korrekte Laenge!");
        }

        if(check){
            this.ISBN = _ISBN;
        }else {
            this.ISBN = null;
            throw new IllegalArgumentException("Die eingegebene ISBN-Nummer ist falsch!");
        }
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String _author) {
        if(_author.isBlank()){
            throw new IllegalArgumentException("Eingegebene Author ist ungültig!");
        }else
        {
            Author = _author;
        }
    }

    @Override
    public String getTitel() {
        return super.getTitel();
    }

    @Override
    public void setTitel(String _titel) {
        super.setTitel(_titel);
    }

    /**
     * Vorgegebene Methode zur Überprüfung der Korrektheit einer 10 Stellen langen ISBN
     * @param isbn
     * @return
     */
    public static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vorgegebene Methode zur Überprüfung der Korrektheit einer 13 Stellen langen ISBN
     * @param isbn
     * @return
     */
    public static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public StringBuilder calculateRepresentation() {
        StringBuilder objString = super.calculateRepresentation();
        objString.append("Erscheinungsjahr: " + getErscheinungsjahr() + "\n");
        objString.append("Verlag: " + getVerlag() + "\n");
        objString.append("ISBN: " + getISBN() + "\n");
        objString.append("Verfasser: " + getAuthor() + "\n");
        return objString;
    }
}
