import myAPI.Modifier;
import myAPI.PredicateTemplate;
import streamAPI.StreamMethods;

import java.util.*;

public class main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for(int i = 0; i < 50 ; i ++){
            list.add(random.nextInt(50));
        }
        List<Number> listForStreamApi = new ArrayList<>(list);

        System.out.println("Generated values");
        System.out.println();
        System.out.println(list);
        System.out.println();

        System.out.println("My collection modifier");
        System.out.println();
        System.out.println("1) This example multiplies prime numbers at even positions by 10");
        System.out.println();
        Modifier modifier = new Modifier<Integer>( value -> new PredicateTemplate().isPrime(value),
                position-> new PredicateTemplate().isEven(position),
                value -> value*10);

        Collection<Integer> myModifiedList = modifier.modifyCollection(list);

        System.out.println(myModifiedList);
        System.out.println();

        System.out.println("2) Collection -> set");
        System.out.println();
        System.out.println(modifier.toSet(list));
        System.out.println();

        System.out.println("3) Sum of array<array<array>>>");
        System.out.println();
        ArrayList<ArrayList<ArrayList<Integer>>> array = new ArrayList<ArrayList<ArrayList<Integer>>>();
        modifier.fillArrayWithRandomNumbers(array,50, 10);
        System.out.println(modifier.calcSumOf3DMatricesElems(array));

        System.out.println();
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println();

        System.out.println("Stream API same methods");
        System.out.println();
        System.out.println("1) This example multiplies prime numbers at even positions by 10");
        System.out.println();

        StreamMethods streamMethods = new StreamMethods<Integer>( value -> new PredicateTemplate().isPrime(value),
                position-> new PredicateTemplate().isEven(position),
                value -> value*10);

        Collection<Integer> streamApiModifiedList = streamMethods.modifyCollection(listForStreamApi);

        System.out.println(streamApiModifiedList);
        System.out.println();

        System.out.println("2) Collection -> set");
        System.out.println();
        System.out.println(StreamMethods.toSet(listForStreamApi));
        System.out.println();

    }
}
