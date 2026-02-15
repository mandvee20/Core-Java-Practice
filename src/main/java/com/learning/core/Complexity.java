package com.learning.core;

/**
 * @author Mandvee Vatsa
 * @date 12-Feb-2026 11:30:07 pm
 */

public enum Complexity
{

   Constant("O(1)"),
   Logarithmic("O(log n)"),
   Linear("O(n)"),
   Linerarithmetic("O(n log n)");


   String value;

   Complexity(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }


}
