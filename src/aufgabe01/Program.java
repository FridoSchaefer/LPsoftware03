package aufgabe01;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

import java.io.*;
import java.util.ArrayList;

public class Program
{

  public static void main(String[] args)
  {
    Adresse adresse = new Adresse();
    adresse.setStrasse("Ringstr. 1");
    adresse.setOrt("Musterstadt");

    Person hugo = new Person();
    hugo.setName("Hugo Schmidt");
    hugo.setAdresse(adresse);

    Person erika = new Person();
    erika.setName("Erika Schmidt");
    erika.setAdresse(adresse);

    //Array List erstellen und befüllen
    ArrayList<Person> personen = new ArrayList<>();
    personen.add(erika);
    personen.add(hugo);

    File test = new File("src\\aufgabe01\\Personen.txt");

    //Serialisierung von Person zu Datei
    try (FileOutputStream fileOutputStream = new FileOutputStream(test)) {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(personen);
      objectOutputStream.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    //neue ArrayList zur Deserialisierung
    ArrayList<Person> newPersonen = new ArrayList<>();

    //Deserialisierung von Datei zu Objekt
    try (FileInputStream fileInputStream = new FileInputStream(test)) {
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      newPersonen = (ArrayList) objectInputStream.readObject();
      objectInputStream.close();
    }
    catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    //Ausgabe der Personen
    for (Person person : newPersonen) {
      System.out.println(person);
    }

    //Überprüfung auf Gleichheit der Adressen
    System.out.println(newPersonen.get(0).getAdresse()==(newPersonen.get(1).getAdresse()));
  }
}
