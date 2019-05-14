import java.util.Collection;

import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;

public class CollectionStreamModifier<T extends Number> implements Modifier<T> {
    Predicate<T> numberPredicate;
    Predicate<Integer> positionPredicate;
    Function<T, T> modifier;

    public CollectionStreamModifier(final Predicate<T> numberPredicate, final Predicate<Integer> positionPredicate, final Function<T, T> modifier) {
        this.modifier = modifier;
        this.positionPredicate = positionPredicate;
        this.numberPredicate = numberPredicate;
    }

    @Override
    public Collection<T> modifyConsideringNumberAndPositionPredicates(Collection<T> collection) {

        new CollectionModifier(null,
                positionPredicate.negate(),
                null)
                .excludeElementsAtPositions(collection); // e.g. isEven() passed then delete those which match !isEven()

        return collection.stream().
                filter(numberPredicate).
                map(modifier).
                collect(Collectors.toList());
    }
}
