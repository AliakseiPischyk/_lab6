import java.util.Collection;

public interface Modifier<T extends Number> {
    Collection<T> modifyConsideringNumberAndPositionPredicates(Collection<T> collection);
}
