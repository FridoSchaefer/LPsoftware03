package aufgabe02bis03;

import java.util.ArrayList;
import java.util.Iterator;

public class Familie implements Iterable<String>
{

  public enum Familienmitglied {
    VATER,
    MUTTER,
    KINDER
  }

  private ArrayList<String> mitglieder = new ArrayList<>();

  /**
   * Konstruktor mit Überprüfung auf korrektheit und Vollständigkeit
   * @param vater
   * @param mutter
   */
  public Familie(String vater, String mutter) {
    try {
      if (!(vater.isEmpty() || mutter.isEmpty())) {
        mitglieder.add(mutter);
        mitglieder.add(vater);
      }
      else {
        throw new IllegalArgumentException("Don't use an empty value for parents!");
      }
    }
    catch (NullPointerException e) {
      System.err.println("Empty value for parents!");
    }
  }

  /**
   * addKind Methode mit Überprüfung auf Korrektheit und Vollständigkeit
   * @param kind
   */
  public void addKind(String kind) {
    try {
      if (!kind.isEmpty()) {
        mitglieder.add(kind);
      }
      else {
        throw new IllegalArgumentException("Don't use an empty value for kind");
      }
    }
    catch (NullPointerException e) {
      System.err.println("Empty value for kind!");
    }
  }

  /**
   * getMitglied Methode mit Überprüfung für Kinder
   * @param mitglied
   * @return
   */
  public String getMitglied(Familienmitglied mitglied) {
    switch (mitglied) {
      case MUTTER:
        return String.valueOf(mitglieder.get(0));
      case VATER:
        return String.valueOf(mitglieder.get(1));
      case KINDER:
        if (mitglieder.size() > 2) {
          StringBuilder kinder = new StringBuilder();
          int x;
          for (x = 2; x < mitglieder.size(); x++) {
            kinder.append(mitglieder.get(x));
            if (x < mitglieder.size() - 1) {
              kinder.append(", ");
            }
          }
          return kinder.toString();
        }
        else {
          return "";
        }
      default:
        throw new IllegalArgumentException("This family member does not exist!");
    }
  }

  @Override
  public Iterator<String> iterator()
  {
    return mitglieder.iterator();
  }
}
