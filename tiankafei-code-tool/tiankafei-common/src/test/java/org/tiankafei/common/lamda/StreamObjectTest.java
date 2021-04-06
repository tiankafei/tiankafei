package org.tiankafei.common.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author tiankafei
 * @Date 2020/3/18
 * @Version V1.0
 **/
public class StreamObjectTest {

    public static void main(String[] args) {
        createPersonList();
        System.out.println("==========================");
    }

    public static void createPersonList() {
        String str = "java,python,scala";
        Stream.of(str.split(",")).map(x -> new Person(x)).forEach(System.out::println);
        System.out.println("-----------------------");
        Stream.of(str.split(",")).map(Person::new).forEach(System.out::println);
        System.out.println("-----------------------");
        Stream.of(str.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
        System.out.println("-----------------------");
        Stream.of(str.split(",")).map(Person::build).forEach(System.out::println);
        System.out.println("-----------------------");
        List<Person> collect = Stream.of(str.split(",")).map(Person::build).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("-----------------------");
        Stream.of(str.split(",")).map(x -> x.split("")).flatMap(x -> Arrays.stream(x)).distinct().forEach(System.out::println);
        System.out.println("-----------------------");
        Stream.of(str.split(",")).map(x -> x.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println("-----------------------");

    }

}

@Data
@Accessors(chain = true)
class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public static Person build(String name) {
        Person p = new Person();
        p.setName(name);
        return p;
    }

}