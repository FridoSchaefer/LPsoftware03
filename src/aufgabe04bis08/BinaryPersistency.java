package aufgabe04bis08;

import java.io.*;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class BinaryPersistency implements Persistency
{

  /**
   * Methode zum Speichern eines Zettelkastenobjekts in eine Binary Datei
   * @param zk Zettelkasten der gespeichert werden soll
   * @param fileName Speicherort
   */
  @Override
  public void save(Zettelkasten zk, String fileName)
  {
    try(FileOutputStream fos = new FileOutputStream(fileName + ".bin")){
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(zk);
      oos.close();
    }
    catch (IOException e)
    {
      throw new IllegalArgumentException("Speichern fehlgeschlagen!");
    }
  }

  /**
   * Methode zum Laden einer binary Datei
   * @param fileName Speicheradresse des zu ladenden Zettelkastens
   * @return gibt den Deserialisierten Zettelkasten zurück
   */
  @Override
  public Zettelkasten load(String fileName)
  {
    try(FileInputStream fis = new FileInputStream(fileName + ".bin")){
      ObjectInputStream ois = new ObjectInputStream(fis);
      Zettelkasten zk = (Zettelkasten) ois.readObject();
      return zk;
    }
    catch (FileNotFoundException e){
      throw new IllegalArgumentException("Die Datei existiert nicht an dem angegebenen Ort!");
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new IllegalArgumentException("Laden fehlgeschlagen!");
    }
  }
}
