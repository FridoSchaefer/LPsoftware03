package aufgabe04bis08;

import java.net.URL;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class ElektronischesMedium extends Medium{

    private String URL;

    /**
     * Konstruktor
     * @param _titel
     * @param _url
     */
    public ElektronischesMedium (String _titel, String _url){
        super(_titel);
        setURL(_url);
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String _URL) {
        if(checkURL(_URL)){
            this.URL = _URL;
        }else{
            throw new IllegalArgumentException("Die eingegeben URL ist falsch oder in einem falschen Format!");
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

    public static boolean checkURL(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception)
        {
            return false;
        }
    }

    @Override
    public StringBuilder calculateRepresentation() {
        StringBuilder objString = super.calculateRepresentation();
        objString.append("URL: " + getURL() + "\n");
        return objString;
    }
}
