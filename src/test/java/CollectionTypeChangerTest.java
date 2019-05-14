import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class CollectionTypeChangerTest {

    private final List<Number> list = new ArrayList<>();

    @Before
    public void setList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void toSetUsingStream() {
        List<Number> listWithCopies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (Number number : list) {
                listWithCopies.add(number);
            }
        }
        assertArrayEquals(list.toArray(), new CollectionTypeChanger().toSetUsingStream(list).toArray());
    }

    @Test
    public void toSet() {
        List<Number> listWithCopies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (Number number : list) {
                listWithCopies.add(number);
            }
        }
        assertArrayEquals(list.toArray(), new CollectionTypeChanger().toSet(list).toArray());
    }
}