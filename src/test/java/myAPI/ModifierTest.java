package myAPI;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ModifierTest {

    private final List<Integer> list = new ArrayList<>();

    @Before
    public void setList(){
        for (int i = 0; i < 10 ; i++) {
            list.add(i);
        }
    }

    @Test
    public void modifyCollectionPrimeEvenTest() {

        Collection<Number> correctModifiedList = new ArrayList<>();
        Modifier modifier = new Modifier<Integer>( value -> new PredicateTemplate().isPrime(value),
                position-> new PredicateTemplate().isEven(position),
                value -> value*10);
        Collection<Integer> myModifiedList = modifier.modifyCollection(list);

        assertFalse(correctModifiedList.equals( myModifiedList));
    }

    @Test
    public void modifyCollectionPrimeUnevenTest() {

        Collection<Integer> correctModifiedList = new ArrayList<>();
        correctModifiedList.add(30);
        correctModifiedList.add(50);
        correctModifiedList.add(70);

        Modifier modifier = new Modifier<Integer>( value -> new PredicateTemplate().isPrime(value),
                position-> new PredicateTemplate().isUneven(position),
                value -> value*10);

        Collection<Integer> myModifiedList = modifier.modifyCollection(list);

        assertArrayEquals(correctModifiedList.toArray(), myModifiedList.toArray());
    }

    @Test
    public void toSet() {
        List<Number> listWithCopies = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            for (Number number : list){
                listWithCopies.add(number);
            }
        }
        assertArrayEquals(list.toArray(),new Modifier<Integer>(null,null,null).toSet(list).toArray());
    }

    @Test
    public void excludeAllElementsAtPositions() {
        new Modifier<Integer>(null,pos -> true,null).excludeElementsAtPositions(list);
        assertEquals( 0, list.size());
    }

    @Test
    public void excludeElementsAtEvenPositions() {
        List<Number> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(5);
        expectedList.add(7);
        expectedList.add(9);

        Modifier modifier = new Modifier<Integer>(null,
                pos -> new PredicateTemplate().isEven(pos),
                null);

        modifier.excludeElementsAtPositions(list);

        assertEquals( expectedList, list);
    }

    @Test
    public void excludeNoElementsAtPositions() {
        int oldSz = list.size();
        new Modifier<Integer>(null,pos -> false,null).excludeElementsAtPositions(list);
        assertEquals( oldSz, list.size());
    }
}