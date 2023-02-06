package Functional_interfaces_and_lambdas;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {
        List<House> home = new ArrayList<>();
        House house1 = new House("Муринская дорога 16", "подземная порковка ", -2);
        House house2 = new House("Муринская дорога 16", "этаж с квартирами", 1);
        House house3 = new House("Муринская дорога 16", "этаж с квартирами", 3);
        House house4 = new House("Муринская дорога 16", "подземная парковка", -1);
        House house5 = new House("Муринская дорога 16", "этаж с квартирами", 5);
        home.add(house1);
        home.add(house2);
        home.add(house3);
        home.add(house4);
        home.add(house5);
        for (House house : home) {
            System.out.println(house);
        }
        //Задание 1
        //Написать Predicate, который проверяет, является ли число положительным.
        //То есть, если число положительное, то предикат должен возвращать true, в противном случае false.
        //Реализовать Predicate в двух вариантах:
        //через анонимный класс
        //через лямбду
        Predicate<House> predicate = new Predicate<House>() {
            @Override
            public boolean test(House house) {
                return house.getFloor() > 0;
            }
        };


        Predicate<House> predicate1 = house -> house.getFloor() > 0;
        for (House house : home) {
            System.out.println("Anonymous class");
            System.out.println(house.getFloor() + " этаж с квартирами " + predicate.test(house));
            System.out.println("lambdas");
            System.out.println(house.getFloor() + " этаж с квартирами " + predicate1.test(house));
        }
        List<People> people1 = new ArrayList<>();
        People vasya = new People("Вася", 35);
        People kolya = new People("Коля", 25);
        People slava = new People("Слава", 21);
        People sasha = new People("Саша", 49);
        people1.add(vasya);
        people1.add(kolya);
        people1.add(slava);
        people1.add(sasha);
//Создать Consumer, который будет принимать на вход имя человека и выводить в консоль его приветствие.
//Реализовать Consumer в двух вариантах:
//через анонимный класс
//через лямбду
        System.out.println("Anonymous class");
        Consumer<People> consumer = new Consumer<People>() {
            @Override
            public void accept(People people) {
                System.out.println("Привет меня завут " + people.getName());
            }
        };
        Consumer<String> consumer3 = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет меня завут " + name);
            }
        };
        consumer3.accept("Вася");
        consumer.accept(sasha);

        System.out.println("lambdas");
        Consumer<People> consumer1 = people2 -> System.out.println("Привет меня завут " + people2.getName());
        consumer1.accept(slava);
//Задание 3
//Реализовать функциональный интерфейс Function, который принимает на вход вещественное число типа Double,
// а возвращает его округленный вариант типа Long.
//Реализовать Function в двух вариантах:
//через анонимный класс
//через лямбду
        System.out.println("Anonymous class");
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(function.apply(8.1));

        System.out.println("lambdas");
        Function<Double, Long> function1 = aDouble -> aDouble.longValue();
        System.out.println(function1.apply(9.78));
//Задание 4
//Написать Supplier, который будет возвращать случайное число от 0 до 100.
//Реализовать Supplier в двух вариантах:
//через анонимный класс
//через лямбду
        System.out.println("Anonymous class");
        Supplier<Integer> supplier = new Supplier<Integer>() {

            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };

        System.out.println(supplier.get());

        Predicate<House>predicate2= house->house.getFloor()>=1;
        Function<House,String>function2=House::getFloorNames;
        var house7 = predicate2.test(house1)?function2.apply(house5):function2.apply(house4);
        System.out.println(house7 +" ternaryOperator");


    }
//Задание 5
//Давайте попрактикуемся в комбинировании функций в более сложные функции.
// Для примера построим следующую комбинацию. Дан предикат condition и две функции ifTrue и ifFalse.
//
//public static <T, U> Function<T, U> ternaryOperator(
//Predicate<? super T> condition,
//Function<? super T, ? extends U> ifTrue,
//Function<? super T, ? extends U> ifFalse) {
//Напишите метод ternaryOperator, который из них построит новую функцию,
// возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}