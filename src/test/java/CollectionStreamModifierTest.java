
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


public class CollectionStreamModifierTest {
    private final List<Number> list = new ArrayList<>();

    @Before
    public void setList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void modifyCollectionPrimeEvenTest() {

        Collection<Number> correctModifiedList = new ArrayList<>();
        CollectionStreamModifier collectionStreamModifier = new CollectionStreamModifier<Integer>(
                value -> new PredicateTemplate().isPrime(value),
                position -> new PredicateTemplate().isUneven(position),
                value -> value * 10);

        Collection<Number> myModifiedList = collectionStreamModifier.modifyConsideringNumberAndPositionPredicates(list);

        assertFalse(correctModifiedList.equals(myModifiedList));
    }

    @Test
    public void modifyCollectionPrimeUnevenTest() {

        Collection<Integer> correctModifiedList = new ArrayList<>();
        correctModifiedList.add(30);
        correctModifiedList.add(50);
        correctModifiedList.add(70);

        CollectionStreamModifier collectionStreamModifier = new CollectionStreamModifier<Integer>(
                value -> new PredicateTemplate().isPrime(value),
                position -> new PredicateTemplate().isUneven(position),
                value -> value * 10);

        Collection<Integer> myModifiedList = collectionStreamModifier.modifyConsideringNumberAndPositionPredicates(list);

        assertArrayEquals(correctModifiedList.toArray(), myModifiedList.toArray());
    }


}