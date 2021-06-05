package com.bridglelabz1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {

        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) myNumberList.add(i);


        //creation sample collection
        List<Double> doubleList = new ArrayList<Double>();
        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
        Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;
        List<Double> evenList = new ArrayList<Double>();

        myNumberList.forEach(n -> {
            doubleList.add(toDoubleFunction.apply(n));
        });
        System.out.println("Printing Double list " +doubleList);

        doubleList.forEach(n1 -> {
            if (isEvenFunction.test(n1.intValue()))
                evenList.add(n1);
        });
        System.out.println("Even List " + evenList);


        //Method8: Processing the stream
        myNumberList.stream().forEach(n -> {
            System.out.println("method8  stream for each value " + n);
        });
        //Method 9 Process the stream ,Apply Operation on the stream and then store result
        List<Double>streamList= myNumberList.stream()
                .filter(isEvenFunction)
                .map(toDoubleFunction)
                .collect(Collectors.toList());
        System.out.println("Method 9 Printing double list: " + streamList);
        //Method 10 Process the stream ,Apply Operation on the stream and then store result find peek
        List<Double>streamPeekList= myNumberList.stream()
                .filter(isEvenFunction)
                .peek(n-> System.out.println(" 10 Peek even number "+n))
                .map(toDoubleFunction)
                .collect(Collectors.toList());
        System.out.println("mehod 10 print peek " +streamPeekList);
       //Method 11 Process the first even
        Integer first = myNumberList.stream()
                .filter(isEvenFunction)
                .peek(n-> System.out.println("11 peek even number "+n))
                .findFirst()
                .orElse(null);
        System.out.println("Method 11 first even " +first);

        //Method 12 Process the find max
        Integer max = myNumberList.stream()
                .filter(isEvenFunction)
                .max(Comparator.comparingInt(Integer::intValue))
                .orElse(null);
        System.out.println("Method 12 find max " +max);

        //Method 13 Process the find min
        Integer min = myNumberList.stream()
                .filter(isEvenFunction)
                .min((n1,n2)->n1-n2)
                .orElse(null);
        System.out.println("Method 13 find min " +min);
        //Method 14 Process the find min
        Integer sum = myNumberList.stream()
                .reduce(0,Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("Method 14 find avg of sum " +sum+ "/" +count+ " = " +sum/count);
        //Method 15 Checking all even, single even or none are divisible by 6
        boolean alleven = myNumberList.stream().allMatch(isEvenFunction);
        boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
        boolean noneMultOfix = myNumberList.stream().noneMatch(i->i>0 && i%6 ==0);
        System.out.println("all even: " +alleven+ "   oneEven: " +oneEven+ "    none Multiple of six: " +noneMultOfix);

    }

}






