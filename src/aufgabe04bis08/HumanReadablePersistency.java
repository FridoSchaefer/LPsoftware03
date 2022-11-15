package aufgabe04bis08;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
    * @author Frido Schäfer
    * MatrikelNR: 19449
    * System: Windows 10 JDK17
    */

public class HumanReadablePersistency implements Persistency
{

  /**
   * Methode zum Speichern eines Zettelkastenobjekts in einer .txt Datei
   * @param zk Zettelkasten der gespeichert werden soll
   * @param fileName Speicherort
   */
  @Override
  public void save(Zettelkasten zk, String fileName)
  {try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", StandardCharsets.UTF_8))){
    for(Medium medium : zk){
      writer.write(medium.calculateRepresentation() + System.lineSeparator());
    }
    writer.flush();
  }
  catch (IOException e)
  {
    throw new IllegalArgumentException("Fehler beim Speichern!");
  }
  }

  /**
   * Methode zum Laden eines Zettelkastenobjekts aus einer .txt Datei
   * @param fileName Speicheradresse des zu ladenden Zettelkastens
   * @return Zettelkastenobjekt
   */
  @Override
  public Zettelkasten load(String fileName)
  {
    throw new UnsupportedOperationException();
  }
}
