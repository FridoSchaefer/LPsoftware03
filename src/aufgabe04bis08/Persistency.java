package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public interface Persistency
{
  /**
   * speichert einen Zettelkasten an einem übergebenen Ort
   * @param zk Zettelkasten der gespeichert werden soll
   * @param fileName Speicherort
   */
  void save(Zettelkasten zk, String fileName);

  /**
   * lädt einen Zettelkasten
   * @param fileName Speicheradresse des zu ladenden Zettelkastens
   * @return Das geladene Objekt
   */
  Zettelkasten load(String fileName);
}
