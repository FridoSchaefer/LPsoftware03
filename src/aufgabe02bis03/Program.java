package aufgabe02bis03;

/**
 * @author Frido Schäfer
 * MatrikelNR: 19449
 * System: Windows 10 JDK17
 */

public class Program
{
  /**
   * Main Program zum Testen
   * @param args
   */
  public static void main(String[] args) {

    Familie[] familie = new Familie[2];

    familie[0] = new Familie("Dieter", "Sina");
    familie[0].addKind("Adelheid");
    familie[0].addKind("Dieter JR.");

    familie[1] = new Familie("Reinhardt", "Erika");

    for (int y = 0; y < 2; y++) {
      for (Familie.Familienmitglied member : Familie.Familienmitglied.values()) {
        System.out.println(familie[y].getMitglied(member));
      }
      System.out.println();
    }

    System.out.println("---------------------------------------------------");

    for (int x = 0; x < 2; x++) {
      for (String name : familie[x]) {
        System.out.println(name);
      }
      System.out.println();
    }
  }
}
//Die Datenkapselung wird sehr stark verletzt
