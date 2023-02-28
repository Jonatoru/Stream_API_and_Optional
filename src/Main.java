import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

        System.out.println("Задача 1");
        System.out.println("");
        Stream<Employees> employeesStream = Stream.of(new Employees("Дмитрий", 25),
                new Employees("Николай", 27),
                new Employees("Владимир", 45));
        BiConsumer<Employees, Employees> biConsumer = (min, max) -> System.out.println("Минимальное значение: " + min.toString() + " Максимальное значение: " + max.toString());
        Comparator<Employees> employeesComparator = Comparator.comparing(Employees::getAge).thenComparing(Employees::getName);
        findMinMax(employeesStream, employeesComparator, biConsumer);

        System.out.println("");
        System.out.println("Задача 2");
        System.out.println("");

        findCountEvenNums(List.of(35,28,44,99,50,14));
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer){
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()){
            minMaxConsumer.accept(null,null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }
    public static void findCountEvenNums(List<Integer> list) {
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        Stream<Integer> evenStream = stream.filter(predicate);
        System.out.println("Колличество четных чисел: " + evenStream.count());
    }
}