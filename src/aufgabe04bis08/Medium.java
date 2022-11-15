package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public abstract class Medium implements Comparable<Medium>{
    private String titel;

    /**
     * Konstruktor
     * @param _titel
     */
    public Medium(String _titel){
        setTitel(_titel);
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String _titel) {
        if(_titel.isBlank()){
            throw new IllegalArgumentException("Eingegebener Titel ist ungültig!");
        }else
        {
            titel = _titel;
        }
    }

    public int compareTo(Medium medium) {
        return this.titel.compareToIgnoreCase(medium.titel);
    }

    public StringBuilder calculateRepresentation(){
        StringBuilder objString = new StringBuilder();
        objString.append("Titel: " + getTitel() + "\n");
        return objString;
    }
}
