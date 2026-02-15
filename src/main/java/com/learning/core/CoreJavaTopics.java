package com.learning.core;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Mandvee Vatsa
 * @date 30-Jan-2026 2:51:22 pm
 */

public enum CoreJavaTopics
{
   STRING,
   WRAPPERS,
   GENRIC,
   COLLECTIONS,
   STREAMS,
   LOGIC,
   KNX,
   MQTT,
   ALL;

   public static CoreJavaTopics fromString(String name)
   {
      try
      {
         for (CoreJavaTopics topic : CoreJavaTopics.values())
         {
            if (StringUtils.equalsIgnoreCase(topic.name(), name)) return topic;
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return ALL;
   }

}


