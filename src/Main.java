import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        persons.stream()
                .filter(Person -> Person.getAge() < 18)
                .count();

        persons.stream()
                .filter(Person -> Person.getAge() > 18 && Person.getAge() < 27)
                .filter(Person -> Person.getSex() == Sex.MAN)
                .map(Person -> Person.getFamily())
                .collect(Collectors.toList());

        persons.stream()
                .filter(Person -> Person.getEducation() == Education.HIGHER)
                .filter(Person -> Person.getAge() > 18)
                .filter(Person -> Person.getAge() < 60 && Person.getSex() == Sex.WOMAN | Person.getAge() < 65 && Person.getSex() == Sex.MAN )
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }



}