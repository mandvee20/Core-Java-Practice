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
      reverseString("REVERSE");
      removeDuplicatesInSortedArray(new int[] {1, 1, 2, 2, 3, 4, 8});
      moveAllZerosToEnd(new int[] {1, 0, 2, 0, 3, 4, 8});
   }

   private void reverseNumber(int number)
   {
      out.println("Reverse a Integer Number");
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
      out.println("Remove Duplicates From a Sorted Array");
      int[] originalArray = Arrays.copyOf(array, array.length);
      int uniqueNumIndex = 0;
      /**
       * uniqueNumIndex always points to the position where the unique
       * element is placed.
       */
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

      /** Array: [1, 1, 2, 2, 3, 4, 8] removed duplicates in Sorted Array: [1, 2, 3, 4, 8] TC: O(n) SC: O(1) **/
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


   private void moveAllZerosToEnd(int[] array){
      out.println("Move All Zeros To End");
      int[] originalArray = Arrays.copyOf(array, array.length);
      int nextNonZeroPosition = 0;
      /**
       * nextNonZeroPosition always points to the position where the next non-zero
       * element should be placed.
       */
      for(int i =0; i< array.length;i++){
         if(array[i] != 0){
            int temp = array[i];
            array[i] = array[nextNonZeroPosition];
            array[nextNonZeroPosition] = temp;
            nextNonZeroPosition++;
         }
         // else
         // Do Nothing
      }

      out.println("Array: " + Arrays.toString(originalArray)
              + " moved all Zeros to End: "
              + Arrays.toString(array)
              + " TC: " + Complexity.Linear.getValue() + " SC: "
              + Complexity.Constant.getValue());

      /**  Array: [1, 0, 2, 0, 3, 4, 8] moved all Zeros to End: [1, 2, 3, 4, 8, 0, 0] TC: O(n) SC: O(1) **/

/**
 * Iteration 1:
 * nextNonZeroPosition = 0, traversingIndex = 0
 * arr[0] = 1 (Non-Zero)
 * Swap arr[0] with arr[0]
 * Array: [1, 0, 2, 0, 3, 4, 8]
 * nextNonZeroPosition becomes 1
 */

/**
 * Iteration 2:
 * nextNonZeroPosition = 1, traversingIndex = 1
 * arr[1] = 0
 * Do Nothing
 * Array: [1, 0, 2, 0, 3, 4, 8]
 */

/**
 * Iteration 3:
 * nextNonZeroPosition = 1, traversingIndex = 2
 * arr[2] = 2 (Non-Zero)
 * Swap arr[2] with arr[1]
 * Array:  [1, 2, 0, 0, 3, 4, 8]
 * nextNonZeroPosition becomes 2
 */

/**
 * Iteration 4:
 * nextNonZeroPosition = 2, traversingIndex = 3
 * arr[3] = 0
 * Do Nothing
 * Array:  [1, 2, 0, 0, 3, 4, 8]
 */

/**
 * Iteration 5:
 * nextNonZeroPosition = 2, traversingIndex = 4
 * arr[4] = 3 (Non-Zero)
 * Swap arr[4] with arr[2]
 * Array: [1, 2, 3, 0, 0, 4, 8]
 * nextNonZeroPosition becomes 3
 */

/**
 * Iteration 6:
 * nextNonZeroPosition = 3, traversingIndex = 5
 * arr[5] = 4 (Non-Zero)
 * Swap arr[5] with arr[3]
 * Array:  [1, 2, 3, 4, 0, 0, 8]
 */

/**
 * Iteration 7:
 * nextNonZeroPosition = 3, traversingIndex = 6
 * arr[6] = 5 (Non-Zero)
 * Swap arr[6] with arr[4]
 * Array: [1, 2, 3, 4, 8, 0, 0]
 * nextNonZeroPosition becomes 4
 */

/**
 * Final Array:
 *[1, 2, 3, 4, 8, 0, 0]
 */

/** TC: O(n), SC: O(1) **/
   }
private void reverseString(String originalString){
   out.println("Reverse a String");
   /**
    * Approach:
    * Use Two Pointers.
    * One pointer starts from the beginning and
    * another from the end.
    * Keep swapping characters until both pointers meet.
    */

      char[] stringArr = originalString.toCharArray();
      int left = 0;
      int right = originalString.length() - 1;
      while (left < right) {
         char temp = stringArr[left];
         stringArr[left] = stringArr[right];
         stringArr[right] = temp;
         left++;
         right--;
      }
   out.println("String: " + originalString
           + " Reversed: "
           + String.valueOf(stringArr)
           + " TC: " + Complexity.Linear.getValue() + " SC: "
           + Complexity.Linear.getValue());

   /** String: REVERSE Reversed: ESREVER TC: O(n) SC: O(n) **/
/** TC: O(n), SC: O(n) **/
}

}
