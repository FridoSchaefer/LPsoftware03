package aufgabe04bis08;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibTexPersistency implements Persistency
{
  private static final String typeOfMedium = "@(.[a-zA-Z]*)\\{";
  private static final String valueOfMedium = "([a-zA-Z]*) = (\\{(.+?)}|[0-9]+)";


  /**
   * Speichert einen Zettelkasten
   * @param zk       zu speichernder Zettelkasten
   * @param fileName Übergebener Speicherort
   */
  @Override
  public void save(Zettelkasten zk, String fileName)
  {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", StandardCharsets.UTF_8)))
    {
      for (Medium medium : zk)
      {
        if (medium.getClass().getSimpleName().equals("Buch"))
        {
          Buch buch = (Buch) medium;
          bw.write(
              "@book{author = {" +
                  buch.getAuthor() +
                  "}, title = {" +
                  buch.getTitel() +
                  "}, publisher = {" +
                  buch.getAuthor() +
                  "}, year = " +
                  buch.getErscheinungsjahr() +
                  ", isbn = {" +
                  buch.getISBN() +
                  "}}"
          );
        } else if (medium.getClass().getSimpleName().equals("CD"))
        {
          CD cd = (CD) medium;
          bw.write(
              "@cd{title = {" +
                  cd.getTitel() +
                  "}, artist = {" +
                  cd.getKuenstler() +
                  "}, label = { " +
                  cd.getLabel() +
                  "}}"
          );
        } else if (medium.getClass().getSimpleName().equals("ElektronischesMedium"))
        {
          ElektronischesMedium elMed = (ElektronischesMedium) medium;
          bw.write(
              "@elMed{title = {" +
                  elMed.getTitel() +
                  "}, URL = {" +
                  elMed.getURL() +
                  "}}"
          );
        } else if (medium.getClass().getSimpleName().equals("Zeitschrift"))
        {
          Zeitschrift zeitschrift = (Zeitschrift) medium;
          bw.write(
              "@journal{title = {" +
                  zeitschrift.getTitel() +
                  "}, issn = {" +
                  zeitschrift.getISSN() +
                  "}, volume = " +
                  zeitschrift.getVolume() +
                  ", number = " +
                  zeitschrift.getNummer() +
                  "}"
          );
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Lädt einen Zettelkasten
   * @param fileName Speicherort von dem aus ein Zettelkasten geladen werden soll
   * @return Den geladenen Zettelkasten
   */
  @Override
  public Zettelkasten load(String fileName)
  {
    ArrayList<String> rawInput = new ArrayList<>();
    StringBuilder readValue = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
    {
      while (br.ready())
      {
        readValue.append(br.read());
      }
    }
    catch (IOException e)
    {
      throw new IllegalArgumentException("Fehler beim lesen der Datei");
    }

    Zettelkasten zk = new Zettelkasten();

    for (String input : rawInput)
    {
      zk.addMedium(generateBibTex(input));
    }
    return zk;
  }

  /**
   * generiert Medien von der BibTex Eingabe mithilfe von Regex Groups
   *
   * @param Input String im BibTex Format
   * @return Medium
   */
  public static Medium generateBibTex(String Input)
  {
    String[] Position = new String[6];

    Pattern pTypeOfMedium = Pattern.compile(typeOfMedium, Pattern.CASE_INSENSITIVE);
    Matcher mTypeOfMedium = pTypeOfMedium.matcher(Input);
    while (mTypeOfMedium.find())
    {
      Position[0] = mTypeOfMedium.group(1);
    }

    Pattern pValueOfMedium = Pattern.compile(valueOfMedium, Pattern.CASE_INSENSITIVE);
    Matcher mValueOfMedium = pValueOfMedium.matcher(Input);

    while (mValueOfMedium.find())
    {
      //Aufräumen der Eingabe
      String value = mValueOfMedium.group(2).replace("{", "").replace("}", "");

      //legt die Werte an die richtigen Stellen im Array
      switch (mValueOfMedium.group(1))
      {
        case "title" ->
        {
          Position[1] = value;
        }
        case "year", "URL", "issn", "label" ->
        {
          Position[2] = value;
        }
        case "publisher", "volume", "artist" ->
        {
          Position[3] = value;
        }
        case "isbn", "number" ->
        {
          Position[4] = value;
        }
        case "author" ->
        {
          Position[5] = value;
        }
        default ->
        {
          System.err.println(mValueOfMedium.group(1) + " ist kein vom Format unterstütztes Datenfeld!");
          Position[0] = null;
        }
      }
    }
    Medium medium = null;
    if (Position[0] != null)
    {
      try
      {
        switch (Position[0])
        {
          case "book" ->
          {
            medium = new Buch(Position[1], Integer.parseInt(Position[2]), Position[3], Position[4], Position[5]);
          }
          case "cd" ->
          {
            medium = new CD(Position[1], Position[2], Position[3]);
          }
          case "journal" ->
          {
            medium = new Zeitschrift(Position[1], Position[2], Integer.parseInt(Position[3]), Integer.parseInt(Position[4]));
          }
          case "elMed" ->
          {
            medium = new ElektronischesMedium(Position[1], Position[2]);
          }
          default ->
          {
            throw new IllegalArgumentException("Die Eingabe enthält kein Medium eines unterstützten Typs");
          }
        }
      }
      catch (Exception exception)
      {
        throw new IllegalArgumentException("Medium konnte nicht geladen werden");
      }
    }
    return medium;
  }
}


