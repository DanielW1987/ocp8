package chapter8.reader_writer;

import chapter8.stream.Person;

import java.io.*;
import java.time.LocalDate;

/**
 * User: dwg
 * Date: 06.06.2017
 * Time: 18:12
 * <p>
 * Copyright LucaNet AG
 * </p>
 */

public class PrintWriterTest {

  public static void main( String... args ) throws IOException {

    File dir         = new File("src/chapter8/files");
    File destination = new File( dir,"PrintWriterTest.txt" );

    // Personen erstellen
    Person dwg = new Person(   "Daniel"
                             , "Wagner"
                             , LocalDate.of(1987, 7, 8)
                             , null
                             , null
                             , null );

    try( PrintWriter writer = new PrintWriter( new BufferedWriter( new FileWriter( destination ) ) ) ){

      // Objekt in den Output schreiben
      writer.println(dwg);

      // String in den Output schreiben (auch via print mgl.
      writer.write("Hallo");

    }
  }
}