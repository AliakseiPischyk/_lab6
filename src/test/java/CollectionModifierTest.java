import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionModifierTest {

    private final List<Integer> list = new ArrayList<>();

    @Before
    public void setList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void modifyCollectionPrimeEvenTest() {

        Collection<Number> correctModifiedList = new ArrayList<>();
        CollectionModifier collectionModifier = new CollectionModifier<Integer>(value -> new PredicateTemplate().isPrime(value),
                position -> new PredicateTemplate().isEven(position),
                value -> value * 10);
        Collection<Integer> myModifiedList = collectionModifier.modifyConsideringNumberAndPositionPredicates(list);

        assertFalse(correctModifiedList.equals(myModifiedList));
    }

    @Test
    public void modifyCollectionPrimeUnevenTest() {

        Collection<Integer> correctModifiedList = new ArrayList<>();
        correctModifiedList.add(30);
        correctModifiedList.add(50);
        correctModifiedList.add(70);

        CollectionModifier collectionModifier = new CollectionModifier<Integer>(value -> new PredicateTemplate().isPrime(value),
                position -> new PredicateTemplate().isUneven(position),
                value -> value * 10);

        Collection<Integer> myModifiedList = collectionModifier.modifyConsideringNumberAndPositionPredicates(list);

        assertArrayEquals(correctModifiedList.toArray(), myModifiedList.toArray());
    }

    @Test
    public void excludeAllElementsAtPositions() {
        new CollectionModifier<Integer>(null, pos -> true, null).excludeElementsAtPositions(list);
        assertEquals(0, list.size());
    }

    @Test
    public void excludeElementsAtEvenPositions() {
        List<Number> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(5);
        expectedList.add(7);
        expectedList.add(9);

        CollectionModifier collectionModifier = new CollectionModifier<Integer>(null,
                pos -> new PredicateTemplate().isEven(pos),
                null);

        collectionModifier.excludeElementsAtPositions(list);

        assertEquals(expectedList, list);
    }

    @Test
    public void excludeNoElementsAtPositions() {
        int oldSz = list.size();
        new CollectionModifier<Integer>(null, pos -> false, null).excludeElementsAtPositions(list);
        assertEquals(oldSz, list.size());
    }
}