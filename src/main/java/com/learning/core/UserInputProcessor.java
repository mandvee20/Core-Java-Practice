package com.learning.core;

import org.apache.commons.lang3.StringUtils;
import com.learning.java.StreamPractice;

/**
 * @author Mandvee Vatsa
 * @date 30-Jan-2026 3:30:38 pm
 */

public class UserInputProcessor
{
   private static UserInputProcessor processor = new UserInputProcessor();
   //Eager Initialization (Simple & Thread-safe)
   
   public static UserInputProcessor getInstance() {
      return processor;
   }
   public void processRequest(String input) {
      System.out.println();
      switch (CoreJavaTopics.valueOf(StringUtils.upperCase(input)))
      {
         case STREAMS:
            StreamPractice.getInstance().printStreamUses();
            break;
         default:
            break;
      }
   }
}
