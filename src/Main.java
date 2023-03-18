import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Main {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }

    }
    public static  void findCountEvenNums(List<Integer> list) {
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate;
        predicate = (n) -> (n % 2) == 0;
        Stream<Integer> resStream = stream.filter(predicate);
        System.out.println("Количество четных чисел: " + resStream.count());
    }

}