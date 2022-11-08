package aufgabe01;

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
  }
}
