package com.learning.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Mandvee Vatsa
 * @date 26-Feb-2026 2:49:45 pm
 */

public class ScannerCases
{
   private static ScannerCases scannerCases = new ScannerCases();
   // Eager Initialization (Simple & Thread-safe)
   private PrintStream out = System.out;

   Scanner scanner;

   public static ScannerCases getInstance()
   {
      return scannerCases;
   }

   private ScannerCases()
   {

   }

   public void printScannerCasess()
   {
      out.println();
      out.println("Learning Scanner Cases");

      scanner = new Scanner(System.in);
      out.println("Console Input Scanner, Enter two words : ");
      while (scanner.hasNext())
      {
         out.println("Processing Console Input Untill Scanner Has Next");
         /** Hello World! **/
         String firstWord = scanner.next();
         out.println("First Word: " + firstWord);
         String secondWord = scanner.next();
         out.println("Second Word: " + secondWord);
         /**
          * First Word: Hello Second Word: World
          **/

         scanner.nextLine();
         out.println();
         /** 12 **/
         out.println("Enter a number: ");
         out.println("Number is: " + scanner.nextInt());
         /** Number is: 12 **/
         out.println("Enter a word: ");
         /** \n **/ /** Left By nextInt in Buffer() **/
         String skippedword = scanner.nextLine();
         /** abc **/
         String finalWord = scanner.nextLine();
         out.println(
                  "Word couldn't be processed in first Try! as New Line Left in Buffer by Previous Next Int"
                           + skippedword);
         /**
          * Word couldn't be processed in first Try! as New Line Left in Buffer
          * by Previous Next Int
          **/
         out.println("Oops! got processed in next Try: " + finalWord);
         /** Oops! got processed in next Try: abc **/


         out.println();
         break;
      }
      out.println("Console Input Scanner, Enter a line : ");

      while (scanner.hasNextLine())
      {
         /** I am a developer. **/
         String firstLine = scanner.nextLine();
         out.println("First Line: " + firstLine);
         /** First Line: I am a developer. **/
         break;
      }
      out.println("Closed Console Input Scanner!");
      scanner.close();

      URL filePath = getClass().getClassLoader().getResource("ScannerFile.txt");

      try
      {
         scanner = new Scanner(new File(filePath.toURI()));
         out.println("File Input Scanner with .(Full Stop) as Delimiter: ");
         /**
          *File Contents: 
          *HI, I am a Word!
          *4, I am a Integer Number!
          *5.5, I am a Double Number!
          *true, I am a Boolean Unit!
          **/      
         
         scanner.useDelimiter("\\!\n");
         while (scanner.hasNextLine())
         {
            out.println("Processing File Input Untill Scanner Has Next Line");

            String str1 = scanner.next();
            out.println("First Line: " + str1);
            /** First Line: HI, I am a Word **/
            String str2 = scanner.next();
            out.println("Second Line: " + str2);
            /** Second Line: 4, I am a Integer Number **/
            String str3 = scanner.next();
            out.println("Third Line: " + str3);
            /** Third Line: 5.5, I am a Double Number **/
            String str4 = scanner.next();
            out.println("Fourth Line: " + str4);
            /** Fourth Line: true, I am a Boolean Unit **/

            Scanner str2Scanner = new Scanner(str2);
            str2Scanner.useDelimiter("\\,");
            int num = str2Scanner.nextInt();
            out.println("Second Line Number: " + num);
            /** Second Line Number: 4 **/
            str2Scanner.close();

            Scanner str3Scanner = new Scanner(str3);
            str3Scanner.useDelimiter("\\,");
            double decimal = str3Scanner.nextDouble();
            out.println("Third Line Decimal: " + decimal);
            str3Scanner.close();
            /** Third Line Decimal: 5.5 **/

            Scanner str4Scanner = new Scanner(str4);
            str4Scanner.useDelimiter("\\,");

            boolean bool = str4Scanner.nextBoolean();
            out.println("Fourth Line Boolean: " + bool);
            str4Scanner.close();
            /** Fourth Line Boolean: true **/
            break;
         }
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (URISyntaxException e)
      {
         e.printStackTrace();
      }

   }
}
