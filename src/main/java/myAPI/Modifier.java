package myAPI;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Modifier<T extends Number> {
    Predicate<T> numberPredicate;
    Predicate<Integer> positionPredicate;
    Function<T,T> modifier;

    public Modifier(final Predicate<T> numberPredicate, final Predicate<Integer> positionPredicate, final Function<T,T> modifier){
        this.modifier = modifier;
        this.positionPredicate = positionPredicate;
        this.numberPredicate = numberPredicate;
    }

    public void excludeElementsAtPositions(Collection<T> collection){
        int currPos = 0;
        Iterator<T> iterator = collection.iterator();

        while (iterator.hasNext()){
            iterator.next();
            if(positionPredicate.test(currPos)){
                iterator.remove();
            }
            currPos++;
        }
    }

    public Collection<T> modifyCollection(Collection<T> collection){
        int currPos = 0;
        List<T> modifiedList = new ArrayList<>();
        Iterator<T> iterator = collection.iterator();

        while (iterator.hasNext()) {
            T currNum = iterator.next();

            if (numberPredicate.test(currNum) && positionPredicate.test(currPos)) {
                modifiedList.add(modifier.apply(currNum));
            }
            currPos++;
        }
        return modifiedList;
    }

    public Set<T> toSet(final Collection<T> collection){
        Set<T> set = new HashSet<>();

        for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); ){
            set.add(iterator.next());
        }

        return set;
    }

//    public static long calcSumOf3DMatricesElems(final Collection<Collection<Number>> ... collections){
//        long accumulator = 0;
//
//        for (int i = 0; i < collections.length; i++){
//            for (int j = 0; j < collections[i].size(); i++){
//                for (Iterator<Collection<Number>> iterator = collections[i].iterator(); iterator.hasNext();){
//                    for (Number number : iterator.next()){
//                        accumulator+=number.longValue();
//                    }
//                }
//            }
//        }
//
//        return accumulator;
//    }

    public BigInteger calcSumOf3DMatricesElems(final  ArrayList<ArrayList<ArrayList<T>>> lolWtf){
        BigInteger accumulator = new BigInteger("0");

        for (ArrayList<ArrayList<T>> arrayListArrayList : lolWtf){
           for (ArrayList<T> arrayList : arrayListArrayList){
               for (Number number : arrayList){
                   accumulator.add(new BigInteger(String.valueOf(number.longValue())));
               }
           }
        }
        return accumulator;
    }

    public void fillArrayWithRandomNumbers(ArrayList<ArrayList<ArrayList<Integer>>> lolWtf, int bound, int dimension) {
        Random random = new Random();

        for (int i = 0; i < dimension; i++) {
            ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < dimension; j++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int k = 0; k < dimension; k++) {
                    arrayList.add(random.nextInt(bound));
                }
                arrayListArrayList.add(arrayList);
            }
            lolWtf.add(arrayListArrayList);
        }
    }

//        for (ArrayList<ArrayList<Integer>> arrayListArrayList : lolWtf){
//            for (ArrayList<Integer> arrayList : arrayListArrayList){
//                for (int i = 0; i < arrayList.size(); i++){
//                    arrayList.add(random.nextInt(bound));
//                }
//            }
//        }
    }

