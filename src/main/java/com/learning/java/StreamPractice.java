package com.learning.java;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Mandvee Vatsa
 * @date 30-Jan-2026 2:31:42 pm
 */

public class StreamPractice
{

   private static StreamPractice prac = new StreamPractice();
   private PrintStream out = System.out;

   public static StreamPractice getInstance()
   {
      return prac;
   }

   private StreamPractice()
   {

   }

   public void printStreamUses()
   {


      /** Stream: java.util.stream.ReferencePipeline$Head@57829d67 **/

      Stream<String> streamEmpty = Stream.empty();
      out.println("Empty Stream: " + streamEmpty.collect(Collectors.toSet()));
      /** Empty Stream: java.util.stream.ReferencePipeline$Head@57829d67 **/
      /** Empty Stream: [] **/

      Collection<String> collection = Arrays.asList("a", "b", "c");
      Stream<String> streamOfCollection = collection.stream();
      out.println("Collection Stream: "
               + streamOfCollection.collect(Collectors.toSet()));
      /**
       * Collection Stream: java.util.stream.ReferencePipeline$Head@19dfb72a
       **/
      /** Collection Stream: [a, b, c] **/
      Stream<String> skippedstreamOfCollection = collection.stream();
      out.println("Collection Skipped Stream: "
               + skippedstreamOfCollection.skip(2).collect(Collectors.toSet())); // Skips
                                                                                 // First
                                                                                 // N
                                                                                 // Elements
      /** Collection Skipped Stream: [c] **/

      String[] arr = new String[] {"a", "b", "a", "c", "d"};
      Stream<String> streamOfArrayFull = Arrays.stream(arr);
      Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // start, end
                                                                   // inclusive

      out.println("Array Stream: "
               + streamOfArrayFull.collect(Collectors.toSet()));
      /** Array Stream: java.util.stream.ReferencePipeline$Head@17c68925 **/
      /** Array Stream: [a, b, c] **/
      out.println("Sub Array Stream: "
               + streamOfArrayPart.collect(Collectors.toSet()));
      /** Sub Array Stream: java.util.stream.ReferencePipeline$Head@7e0ea639 **/
      /** Sub Array Stream: [b, c] **/

      Stream<String> streamBuilder =
               Stream.<String>builder().add("a").add("b").add("c").build();
      out.println(
               "Builder Stream: " + streamBuilder.collect(Collectors.toSet()));
      /** Builder Stream: [a, b, c] **/

      Stream streamObjectBuilder =
               Stream.builder().add("a").add(1).add("c").build();
      out.println("Object Builder Stream: "
               + streamObjectBuilder.collect(Collectors.toSet()));
      /** Object Builder Stream: [a, 1, c] **/

      Stream<String> streamGenerated =
               Stream.generate(() -> "element").limit(3); // Infinite By Default
      out.println("Generated Stream: "
               + streamGenerated.collect(Collectors.toList()));
      /** Generated Stream: [element, element, element] **/
      int count = 10;
      Stream<Integer> intStreamGenerated =
               Stream.generate(() -> count + 1).limit(3); // Infinite By Default
      out.println("Generated Int Stream: "
               + intStreamGenerated.collect(Collectors.toList()));
      /** Generated Int Stream: [11, 11, 11] **/

      Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);
      out.println("Iterated Int + 2 Stream: "
               + streamIterated.collect(Collectors.toList()));
      /** Iterated Int + 2 Stream: [40, 42, 44, 46, 48] **/

      Stream<Integer> streamSquareIterated =
               Stream.iterate(2, n -> n * n).limit(10);
      out.println("Iterated Int Square Stream: "
               + streamSquareIterated.collect(Collectors.toList()));
      /** Iterated Int Square Stream: [2, 4, 16, 256, 65536, 0, 0, 0, 0, 0] **/

      IntStream intStream = IntStream.range(1, 3); // start inclusive, end
                                                   // exclusive
      out.println(
               "IntStream: " + intStream.boxed().collect(Collectors.toSet()));
      /** IntStream: java.util.stream.IntPipeline$Head@182decdb **/
      /** IntStream: [1, 2] **/

      LongStream longClosedStream = LongStream.rangeClosed(1, 10); // start ,
                                                                   // end
                                                                   // inclusive
      out.println("LongClosed Stream: "
               + longClosedStream.boxed().collect(Collectors.toSet()));
      /** LongClosed Stream: java.util.stream.LongPipeline$Head@39ed3c8d **/
      /** LongClosed Stream: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] **/

      Random random = new Random();
      DoubleStream doubleRandomStream = random.doubles(4);
      out.println("Double Random Stream: "
               + doubleRandomStream.boxed().collect(Collectors.toSet()));
      /**
       * Double Random Stream: [0.5637808003294317, 0.7079214481631119,
       * 0.13498164673945545, 0.8548570897922212]
       **/

      IntStream intRandomStream = random.ints(10, 0, 5); // start inclusive, end
                                                         // exclusive range
      out.println("IntRandomStream: "
               + intRandomStream.boxed().collect(Collectors.toList()));
      /** IntRandomStream: [3, 1, 3, 3, 4, 0, 2, 0, 3, 1] **/

      IntStream streamOfChars = "abc".chars();
      out.println("Char Int Stream: "
               + streamOfChars.boxed().collect(Collectors.toList()));
      /** Char Int Stream: [97, 98, 99] **/ /** No Char Stream in JDK **/

      Stream<String> streamOfString =
               Pattern.compile(",").splitAsStream("a, b, c:d");
      out.println("String Pattern Stream : "
               + streamOfString.collect(Collectors.toList()));
      /** String Pattern Stream : [a, b, c:d] **/

      String filePath = "/home/Mandvee/Desktop/StreamFile.txt";
      /** File Content **/
      /*
       * Hello!!! I am A Dummy Test File. Nice To Meet You
       * User @@@@@!!!$$$$$!!!....
       */
      try
      {
         Path path = Paths.get(filePath);
         Stream<String> streamOfStrings = Files.lines(path);
         out.println("File Stream : "
                  + streamOfStrings.collect(Collectors.toList()));
         /**
          * File Stream : [Hello!!!, I am A Dummy Test File., Nice To Meet You
          * User @@@@@!!!$$$$$!!!....]
          **/

         Stream<String> streamWithCharset =
                  Files.lines(path, Charset.forName("UTF-8"));
         out.println("File with Charset Stream : "
                  + streamWithCharset.collect(Collectors.toList()));
         /**
          * File with Charset Stream : [Hello!!!, I am A Dummy Test File., Nice
          * To Meet You User @@@@@!!!$$$$$!!!....]
          **/
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      try
      {
         Stream<String> stream = Stream.of("a", "b", "c")
                  .filter(element -> element.contains("b"));
         out.println("Accessing Terminated Stream : "
                  + stream.collect(Collectors.toList()));
         /** Accessing Terminated Stream : [b] **/

         out.println("Operating Terminated Stream : ");
         Optional<String> anyElement = stream.findAny();
         /**
          * Operating Terminated Stream : java.lang.IllegalStateException:
          * stream has already been operated upon or closed
          **/
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      out.println("Skipped Stream : "
               + Arrays.stream(arr).skip(2).collect(Collectors.toList()));
      /** Skipped Stream : [a, c, d] **/
      out.println("Limited Stream : "
               + Arrays.stream(arr).limit(2).collect(Collectors.toList()));
      /** Limited Stream : [a, b] **/
      out.println("Sorted Stream : "
               + Arrays.stream(arr).sorted().collect(Collectors.toList()));
      /** Sorted Stream : [a, a, b, c, d] **/
      out.println("Distinct Stream : "
               + Arrays.stream(arr).distinct().collect(Collectors.toList()));
      /** Distinct Stream : [a, b, c, d] **/
      out.println("Reversed Stream : " + Arrays.stream(arr)
               .sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
      /** Reversed Stream : [d, c, b, a, a] **/
      out.println("Natural Stream : " + Arrays.stream(arr)
               .sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
      /** Natural Stream : [a, a, b, c, d] **/
      out.println("Count Stream : " + Arrays.stream(arr).count());
      /** Natural Stream : [a, a, b, c, d] **/
      out.println("Max Stream : "
               + Arrays.stream(arr).max(Comparator.naturalOrder()).get());
      /** Max Stream : d **/
      out.println("Min Stream : "
               + Arrays.stream(arr).min(Comparator.naturalOrder()).get());
      /** Min Stream : a **/
      out.println("Sum Stream : " + IntStream.of(1, 2, 3).sum());
      /** Sum Stream : 6 **/

      OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
      out.println("Reduced Accumulated Stream : " + reduced.getAsInt());
      /** Reduced Accumulated Stream : 6 **/
      // accumulator = 1
      // accumulator = 1 + 2 → 3
      // accumulator = 3 + 3 → 6

      int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
      out.println("Reduced Accumulated Stream, with identity : "
               + reducedTwoParams);
      /** Reduced Accumulated Stream, with identity : 16 **/
      // accumulator = 10 // identity
      // accumulator = 10 + 1 → 11
      // accumulator = 11 + 2 → 13
      // accumulator = 13 + 3 → 16

      int reducedTwoParamsParallelStream = Arrays.asList(1, 2, 3)
               .parallelStream().reduce(10, (a, b) -> a + b);
      out.println("Reduced Accumulated Parallel Stream, with identity : "
               + reducedTwoParamsParallelStream);
      /** Reduced Accumulated Parallel Stream, with identity : 36 **/
      // accumulator = 10 // identity
      // accumulator = 10 + 1 → 11
      // accumulator = 10 + 2 → 12
      // accumulator = 10 + 3 → 13
      // accumulator = 11 + 12 + 13 → 36

      int reducedParams =
               Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> {
                  System.out.println("COMBINER CALLED"); /** Not Printed **/
                  return (a * a) + (b * b);
               });
      out.println("Reduced Accumulated & Combined Stream, with identity : "
               + reducedParams);
      /** Reduced Accumulated & Combined Stream, with identity : 16 **/
      // accumulator = 10 // identity
      // accumulator = 10 + 1 → 11
      // accumulator = 11 + 2 → 13
      // accumulator = 13 + 3 → 16

      int reducedParallelStreamParams = Arrays.asList(1, 2, 3).parallelStream()
               .reduce(10, (a, b) -> a + b, (a, b) -> {
                  System.out.println("COMBINER CALLED FROM PARALLEL STREAM");
                  return (a * a) + (b * b);
               });
      out.println(
               "Reduced Accumulated & Combined Parallel Stream, with identity : "
                        + reducedParallelStreamParams);
      /**
       * Reduced Accumulated & Combined Parallel Stream, with identity : 98090
       **/
      /**
       * Reduced Accumulated & Combined Parallel Stream, with identity : 70394
       **/
      // accumulator = 10 // identity
      // accumulator = 10 + 1 → 11
      // accumulator = 10 + 2 → 12
      // accumulator = 10 + 3 → 13
      // Based on Division in Parallel Stream
      // 1st Case:
      // combiner = (11*11 + 12*12) → 265
      // combiner = (265*265 + 13*13) → 70394
      // 2nd Case:
      // combiner = (11*11 + 13*13) → 290
      // combiner = (290*290 + 12*12) → 84244
      // 3rd Case:
      // combiner = (12*12 + 13*13) → 313
      // combiner = (313*313 + 11*11) → 98090

      List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
               new Product(14, "orange"), new Product(13, "lemon"),
               new Product(23, "bread"), new Product(13, "sugar"));
      List<String> collectorCollection = productList.stream().map(Product::name)
               .collect(Collectors.toList());
      out.println("Collected List : " + collectorCollection);
      /** Collected List : [potatoes, orange, lemon, bread, sugar] **/
      
   }

}


record Product(int quantity, String name)
{
}
