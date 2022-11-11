package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class CD extends Medium{

    private String Label;
    private String Kuenstler;

    /**
     * Konstruktor
     * @param _titel
     * @param _label
     * @param _kuenstler
     */
    public CD (String _titel, String _label, String _kuenstler){
        super(_titel);
        setLabel(_label);
        setKuenstler(_kuenstler);
    }

    public String getLabel() {
        return Label;
    }

    public String getKuenstler() {
        return Kuenstler;
    }

    @Override
    public String getTitel() {
        return super.getTitel();
    }

    public void setLabel(String _label) {
        if(_label.isBlank()){
            throw new IllegalArgumentException("Eingegebenes Lable ist ungültig!");
        }else
        {
            this.Label = _label;
        }
    }

    public void setKuenstler(String _kuenstler) {
        if(_kuenstler.isBlank()){
            throw new IllegalArgumentException("Eingegebener Künstler ist ungültig!");
        }else
        {
            this.Kuenstler = _kuenstler;
        }
    }

    @Override
    public void setTitel(String _titel) {
        super.setTitel(_titel);
    }

    @Override
    public StringBuilder calculateRepresentation() {
        StringBuilder objString = super.calculateRepresentation();
        objString.append("Label: " + getLabel() + "\n");
        objString.append("Kuenstler: " + getKuenstler() + "\n");
        return objString;
    }
}
