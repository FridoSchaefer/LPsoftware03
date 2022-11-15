package aufgabe04bis08;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;

public class Zettelkasten implements Iterable<Medium>, Serializable
{
  //Hilfsvariablen fürs Sortieren
  boolean sortedUp = false;
  boolean sortedDown = false;


  public enum TypesOfMedia {
    ALL,
    BUCH,
    CD,
    ELEKTRONISCHES_MEDIUM,
    ZEITSCHRIFT
  }

  public static ArrayList<Medium> myZettelkasten = new ArrayList<>();

  //Vergleich auf Basis des Typs
  private static final Comparator<Medium> compareByClassName = Comparator.comparing((Medium type) -> type.getClass().getName());

  // Vergleich auf Basis des Titels und des Typs
  private static final Comparator<Medium> compareByTitleAndClassName = Comparator.comparing((Medium titel) -> titel.getTitel()).thenComparing((Medium type) -> type.getClass().getName());



  /**
   * Methode zum Hinzufügen eines Mediums
   * @param inputMedium zu übergebendes Medium
   */
  public void addMedium (Medium inputMedium){
    myZettelkasten.add(inputMedium);
  }

  /**
   * Methode zum Löschen einzelner und nur einmal vorhandenen Medien
   * wirft Fehler bei Duplikaten
   * ruft die Methode findMedium auf für die Liste
   * @param titel Titel der übergeben werden muss für das Medium welches gelöscht werden soll
   */
  public void dropMedium(String titel) {
    List<Medium> foundMedia = findMedium(titel);
    Predicate<Medium> condition = myZettelkasten -> myZettelkasten.getTitel().equals(titel);
    if (foundMedia.toString().contains(titel) && !titel.equals("") && foundMedia.size()==1) {
      System.out.print("Medium mit folgendem Titel wurde erfolgreich gelöscht: " + titel);
      myZettelkasten.removeIf(condition);
    } else if (titel.equals("")) {
      throw new IllegalArgumentException("Übergebener Titel darf nicht leer sein");
    } else if (foundMedia.size()>1) {
      throw new IllegalArgumentException("duplicateEntry!");
    } else {
      throw new IllegalArgumentException("Fehler beim Versuch ein Medium zu löschen. Falscher Titel: " + titel);
    }
  }

  /**
   * Methode zum Löschen von Dopplungen
   * nimmt sich die Liste der Medien aus findMedium
   * überprüft, ob die Liste Dopplungen hat
   * @param title Der Titel des Mediums welche entfernt werden sollen
   * @param typesOfMedia Die doppelten Medien Typs die entfernt werden sollen, entweder spezifisch oder "ALL"
   */
  public void dropMediumOnDuplicate(String title, TypesOfMedia typesOfMedia) {
    List<Medium> foundMedia = findMedium(title);
    if (foundMedia.size() >= 1 && !title.isBlank()) {
      if (typesOfMedia == TypesOfMedia.ALL) {
        for (Medium hit : foundMedia) {
          myZettelkasten.remove(hit);
          System.out.println("Folgende Medien wurden erfolgreich gelöscht: " + hit.getClass().getSimpleName() + " - " + hit.getTitel() + System.lineSeparator());
        }
      }
      if (typesOfMedia == TypesOfMedia.BUCH) {
        for (Medium hit : foundMedia) {
          myZettelkasten.remove(hit);
          System.out.println("Folgende Medien wurden erfolgreich gelöscht: " + hit.getClass().getSimpleName() + " - " + hit.getTitel() + System.lineSeparator());
        }
      }
      if (typesOfMedia == TypesOfMedia.CD) {
        for (Medium hit : foundMedia) {
          myZettelkasten.remove(hit);
          System.out.println("Folgende Medien wurden erfolgreich gelöscht: " + hit.getClass().getSimpleName() + " - " + hit.getTitel() + System.lineSeparator());
        }
      }
      if (typesOfMedia == TypesOfMedia.ELEKTRONISCHES_MEDIUM) {
        for (Medium hit : foundMedia) {
          myZettelkasten.remove(hit);
          System.out.println("Folgende Medien wurden erfolgreich gelöscht: " + hit.getClass().getSimpleName() + " - " + hit.getTitel() + System.lineSeparator());
        }
      }
      if (typesOfMedia == TypesOfMedia.ZEITSCHRIFT) {
        for (Medium hit : foundMedia) {
          myZettelkasten.remove(hit);
          System.out.println("Folgende Medien wurden erfolgreich gelöscht: " + hit.getClass().getSimpleName() + " - " + hit.getTitel() + System.lineSeparator());
        }
      }
    } else if (title.isBlank()) {
      throw new IllegalArgumentException("Übergebener Titel darf nicht leer sein");
    } else {
      throw new IllegalArgumentException("Keine Duplikate gefunden");
    }
  }

  /**
   * Methode erstellt eine List von gefunden Medien, wenn > 1 wird diese sortiert
   * @param titel Titel nach dem gesucht werden soll
   * @return Liste der gefundenen Medien
   */
  public List<Medium> findMedium(String titel) {
    List<Medium> foundMedia = new ArrayList<>();
    for (Medium medium : myZettelkasten) {
      if (medium.getTitel().equals(titel)) {
        foundMedia.add(medium);
      }
    }
    if (foundMedia.size() > 1) {
      foundMedia.sort(compareByClassName);
      System.out.println("Medien mit Titel: " + titel + " gefunden");
      return foundMedia;
    } else if (foundMedia.size() == 1) {
      System.out.println("Medium mit Titel: " + titel + " gefunden");
      return foundMedia;
    } else {
      System.out.println("Keine Medien mit dem Titel: " + titel + " gefunden");
      return null;
    }
  }

  /**
   * Methode zum Sortieren des Zettelkastens
   * überprüft, ob schon sortiert ist
   * @param order Eingabe zur sortierung
   *              "" oder "A" für alphabetisch aufsteigend
   *              "Z" für Alphabetisch absteigend
   */
  public void sort(String order) {
    if ((order.equals("A") || order.isEmpty()) && !sortedUp) {
      sortedUp = true;
      sortedDown = false;
      myZettelkasten.sort(compareByTitleAndClassName);
      System.out.println("Absteigend sortiert: " + myZettelkasten);
    } else if (order.equals("Z") && !sortedDown) {
      sortedDown = true;
      sortedUp = false;
      myZettelkasten.sort(compareByTitleAndClassName.reversed());
      System.out.println("Aufsteigend sortiert: " + myZettelkasten);
    } else if (sortedUp) {
      System.out.println("Liste wurde schon alphabetisch sortiert");
    } else if (sortedDown) {
      System.out.println("Liste wurde schon gegen das Alphabet sortiert");
    }
    else {
      throw new IllegalArgumentException("Kein gültiger Parameter übergeben");
    }
  }

  @Override
  public Iterator<Medium> iterator()
  {
    return myZettelkasten.iterator();
  }
}
