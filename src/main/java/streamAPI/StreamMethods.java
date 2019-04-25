package streamAPI;

import myAPI.Modifier;

import java.util.Collection;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;

public class StreamMethods<T extends Number> {
    Predicate<T> numberPredicate;
    Predicate<Integer> positionPredicate;
    Function<T,T> modifier;

    public StreamMethods(final Predicate<T> numberPredicate, final Predicate<Integer> positionPredicate, final Function<T,T> modifier){
        this.modifier = modifier;
        this.positionPredicate = positionPredicate;
        this.numberPredicate = numberPredicate;
    }

    public Collection<Number> modifyCollection(Collection<T> collection){

        new Modifier(null,
                positionPredicate.negate(),
                null)
                .excludeElementsAtPositions(collection); // e.g. isEven() passed then delete those which match !isEven()

        return collection.stream().
                filter(numberPredicate).
                map(modifier).
                collect(Collectors.toList());
    }

    public static<T> Set<T> toSet(Collection<T> collection){
        return collection.
                stream().
                collect(Collectors.toSet());
    }
}
