package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public abstract class Medium implements Comparable<Medium>{
    private String Titel;

    /**
     * Konstruktor
     * @param _titel
     */
    public Medium(String _titel){
        setTitel(_titel);
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String _titel) {
        Titel = _titel;
    }

    public int compareTo(Medium medium) {
        return this.Titel.compareToIgnoreCase(medium.Titel);
    }

    public StringBuilder calculateRepresentation(){
        StringBuilder objString = new StringBuilder();
        objString.append("Titel: " + getTitel() + "\n");
        return objString;
    }
}
