import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionTypeChanger {
    public <T> Set<T> toSetUsingStream(Collection<T> collection) {
        return collection.
                stream().
                collect(Collectors.toSet());
    }

    public <T> Set<T> toSet(final Collection<T> collection) {
        Set<T> set = new HashSet<>();

        for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); ) {
            set.add(iterator.next());
        }

        return set;
    }
}
