package com.learning.java;

import java.io.PrintStream;
import java.util.Arrays;
import com.learning.core.Complexity;

/**
 * @author Mandvee Vatsa
 * @date 09-Feb-2026 3:56:19 pm
 */

public class LogicBuilding
{
   private static LogicBuilding prac = new LogicBuilding();
   // Eager Initialization (Simple & Thread-safe)
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
      out.println();
      out.println("Learning Logic Building");
      reverseNumber(-12345);
      removeDuplicatesInSortedArray(new int[] {1, 1, 2, 2, 3, 4, 8});
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
      out.println("Number: " + number + " Reversed: " + revNumber + " TC: "
               + Complexity.Logarithmic.getValue() + " SC: "
               + Complexity.Constant.getValue());
      /** Number: -12345 reversed: -54321 **/
      /**
       * Iteration 1: processingVariable: -12345, digit = -5, revNumber = -5
       **/
      /**
       * Iteration 2: processingVariable: -1234, digit = -4, revNumber = -54
       **/
      /**
       * Iteration 3: processingVariable: -123, digit = -3, revNumber = -543
       **/
      /**
       * Iteration 4: processingVariable: -12, digit = -2, revNumber = -5432
       **/
      /**
       * Iteration 5: processingVariable: -1, digit = -1, revNumber = -54321
       **/
      /** TC: O(log n), SC: O(1) **/
   }

   private void removeDuplicatesInSortedArray(int[] array)
   {
      int[] originalArray = Arrays.copyOf(array, array.length);
      int uniqueNumIndex = 0;
      for (int traversingIndex =
               1; traversingIndex < array.length; traversingIndex++)
      {
         if (array[uniqueNumIndex] != array[traversingIndex])
         {
            uniqueNumIndex++;
            array[uniqueNumIndex] = array[traversingIndex];
         }
      }

      out.println("Array: " + Arrays.toString(originalArray)
               + " removed duplicates in Sorted Array: "
               + Arrays.toString(Arrays.copyOf(array, uniqueNumIndex + 1))
               + " TC: " + Complexity.Linear.getValue() + " SC: "
               + Complexity.Constant.getValue());

      /**
       * Array: [1, 1, 2, 2, 3, 4, 8] removed duplicates in Sorted Array: [1, 2,
       * 3, 4, 8]
       **/
      /**
       * Iteration 1: uniqueNumIndex: 0, traversingIndex = 1 Do Nothing [1, 1,
       * 2, 2, 3, 4, 8]
       **/
      /**
       * Iteration 2: uniqueNumIndex: 0, traversingIndex = 2 Execute if [1, 2,
       * 2, 2, 3, 4, 8]
       **/
      /**
       * Iteration 3: uniqueNumIndex: 1, traversingIndex = 3 Do Nothing [1, 2,
       * 2, 2, 3, 4, 8]
       **/
      /**
       * Iteration 4: uniqueNumIndex: 1, traversingIndex = 4 Execute if [1, 2,
       * 3, 2, 3, 4, 8]
       **/
      /**
       * Iteration 5: uniqueNumIndex: 2, traversingIndex = 5 Execute if [1, 2,
       * 3, 4, 3, 4, 8]
       **/
      /**
       * Iteration 6: uniqueNumIndex: 3, traversingIndex = 6 Execute if [1, 2,
       * 3, 4, 8,]
       **/
      /** TC: O(n), SC: O(1) **/
   }


}
