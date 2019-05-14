import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(50));
        }
        List<Number> listForStreamApi = new ArrayList<>(list);

        System.out.println("Generated values");
        System.out.println();
        System.out.println(list);
        System.out.println();

        System.out.println("My collection collectionModifier");
        System.out.println();
        System.out.println("1) This example multiplies prime numbers at even positions by 10");
        System.out.println();
        CollectionModifier collectionModifier = new CollectionModifier<Integer>(value -> new PredicateTemplate().isPrime(value),
                position -> new PredicateTemplate().isEven(position),
                value -> value * 10);

        Collection<Integer> myModifiedList = collectionModifier.modifyConsideringNumberAndPositionPredicates(list);

        System.out.println(myModifiedList);
        System.out.println();

        System.out.println("2) Collection -> set");
        System.out.println();
        System.out.println(new CollectionTypeChanger().toSet(list));
        System.out.println();

        System.out.println("3) Sum of array<array<array>>>");
        System.out.println();
        ArrayList<ArrayList<ArrayList<Integer>>> array = new ArrayList<>();
        collectionModifier.fillArrayWithRandomNumbers(array, 50, 10);
        System.out.println(collectionModifier.calcSumOf3DMatricesElems(array));

        System.out.println();
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println();

        System.out.println("Stream API same methods");
        System.out.println();
        System.out.println("1) This example multiplies prime numbers at even positions by 10");
        System.out.println();

        CollectionStreamModifier collectionStreamModifier = new CollectionStreamModifier<Integer>(value -> new PredicateTemplate().isPrime(value),
                position -> new PredicateTemplate().isEven(position),
                value -> value * 10);

        Collection<Integer> streamApiModifiedList = collectionStreamModifier.modifyConsideringNumberAndPositionPredicates(listForStreamApi);

        System.out.println(streamApiModifiedList);
        System.out.println();

        System.out.println("2) Collection -> set");
        System.out.println();
        System.out.println(new CollectionTypeChanger().toSetUsingStream(listForStreamApi));
        System.out.println();
    }
}
