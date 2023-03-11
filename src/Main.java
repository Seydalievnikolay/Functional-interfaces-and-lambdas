import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        //Задание №1
        System.out.println("Задача №1");
        /*Numbers num = new Numbers(72);
        Numbers num2 = new Numbers(-72);


        List<Numbers> numbers = new ArrayList<>();

        numbers.add(num);
        numbers.add(num2);
        Predicate<Numbers> predicate = new Predicate<Numbers>() {
            @Override
            public boolean test(Numbers numbers1) {
                return numbers1.getNum() > 0;
            }
        };*/
        Predicate<Integer > positiveNumber = new Predicate<Integer>() {

            @Override
            public boolean test(Integer x) {
                if(x > 0) return  true;
                else return false;
            }
        };
        Predicate<Integer> positiveNumber2 = x -> x > 1;

        System.out.println(positiveNumber.test(7));
        System.out.println(positiveNumber.test(-3));
        System.out.println(positiveNumber2.test(6));
        System.out.println(positiveNumber2.test(-6));

        //Задание №2
        System.out.println("Задача №2");

        Person person = new Person("Aleksander",43);
        List<Person> people = new ArrayList<>();
        people.add(person);
        Consumer<Person> namePeople = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Hi ! " + person.getName());
            }
        };
        Consumer<Person> namePeople2 = person1 -> System.out.println("Hi ! " + person.getName());
        namePeople2.accept(person);
        namePeople.accept(person);

        //Задание №3
        System.out.println("Задача №3");

        Function<Double,Long> function = new Function<Double, Long>() {

            @Override
            public Long apply(Double aDouble) {

                return aDouble.longValue();
            }
        };
        System.out.println(function.apply(19.7));

        Function<Double,Long> function2 = Math::round;
        System.out.println(function2.apply(3.2));

        //Задание №4
        System.out.println("Задача №4");

        int from = 0;
        int to = 100;
        Random random = new Random();
        int randomNumber = from + random.nextInt(to-from);
        System.out.println(randomNumber);

        //Stream.generate(new Random()::nextInt).limit(1).forEach(System.out::println);


        Supplier<Integer> randomNum = () -> new Random().nextInt(100);

        Stream.generate(randomNum).limit(1).forEach(System.out::println);

        //Задание №5
        System.out.println("Задача №5");


        /*Predicate<Person> condition = (person1 -> person.getAge());
        Function<Person,Integer>ifTrue = (person1 -> person.getAge());
        Function<Person,Integer>ifFalse =  (person1 -> 18);
        Function<Person,Integer>function1 = ternaryOperator(condition,ifTrue,ifFalse);
        System.out.println();*/
        Predicate<Integer>predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 0)
                    return false;
                return true;
            }
        };
        Function<Integer,Double> function1 = x-> Double.valueOf(Math.abs(-23));
        Function<Integer,Double> function3 = x-> Double.valueOf(Math.pow(x,3));
        System.out.println(ternaryOperator(predicate,function1,function3).apply(2));




    }

    public static <T,U> Function<T,U> ternaryOperator(
           Predicate<? super T> condition,
           Function<? super T, ? extends U> ifTrue,
           Function<? super T, ? extends U> ifFalse
    ){
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }


}