package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class Zeitschrift extends Medium{

    private String ISSN;
    private int Volume;
    private int Nummer;

    /**
     * Konstruktor
     * @param _titel
     * @param _issn
     * @param _volume
     * @param _nummer
     */
    public Zeitschrift(String _titel, String _issn, int _volume, int _nummer){
        super(_titel);
        setISSN(_issn);
        setVolume(_volume);
        setNummer(_nummer);
    }

    public String getISSN() {
        return ISSN;
    }

    public int getVolume() {
        return Volume;
    }

    public int getNummer() {
        return Nummer;
    }

    @Override
    public String getTitel() {
        return super.getTitel();
    }

    public void setISSN(String _ISSN) {
        if(_ISSN.isBlank()){
            throw new IllegalArgumentException("Eingegebene ISSN ist ungültig!");
        }else
        {
            this.ISSN = _ISSN;
        }
    }

    public void setVolume(int _volume) {
        Volume = _volume;
    }

    public void setNummer(int _nummer) {
        Nummer = _nummer;
    }

    @Override
    public void setTitel(String _titel) {
        super.setTitel(_titel);
    }

    @Override
    public StringBuilder calculateRepresentation() {
        StringBuilder objString = super.calculateRepresentation();
        objString.append("ISSN: " + getISSN() + "\n");
        objString.append("Volume: " + getVolume() + "\n");
        objString.append("Nummer: " + getNummer() + "\n");
        return objString;
    }
}
