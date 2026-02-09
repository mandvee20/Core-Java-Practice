package com.learning.core;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.learning.java.StreamPractice;

/**
 * @author Mandvee Vatsa
 * @date 30-Jan-2026 2:32:36 pm
 */

public class MainController
{

   public static void main(String[] args)
   {
      if (ArrayUtils.isNotEmpty(args) && StringUtils.isNotBlank(args[0]))
      {
        UserInputProcessor.getInstance().processRequest(args[0]);
      }
      else
      {
         Initiallizer.getInstance().printAvailableTopics();
         Initiallizer.getInstance().startAcceptingUserInputs();
      }


   }

}
