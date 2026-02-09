package com.learning.java;

import java.io.PrintStream;

/**
 * @author Mandvee Vatsa
 * @date 09-Feb-2026 3:56:19 pm
 */

public class LogicBuilding
{
   private static LogicBuilding prac = new LogicBuilding();
   private PrintStream out = System.out;

   public static LogicBuilding getInstance()
   {
      return prac;
   }

   private LogicBuilding()
   {

   }

   public void buildLogic()
   {
      out.println("Learning Logic Building");
      reverseNumber(12345);
   }

   private void reverseNumber(int number)
   {
      int revNumber = 0;
      int processingVariable = number;
      while (processingVariable != 0)
      {
         int digit = processingVariable % 10;
         processingVariable = processingVariable / 10;
         revNumber = revNumber * 10 + digit;
      }
      out.println("Number: " + number + " reversed: " + revNumber);
      /** Number: -12345 reversed: -54321 **/
   }

   
}
