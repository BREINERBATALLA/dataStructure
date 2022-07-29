import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamLambda {

    public static void main(String[] args) {


        Person p1 = new Person(1,"Brei", LocalDate.of(1999,8,05));
        Person p2 = new Person(2,"Ai", LocalDate.of(1998,04,15));
        Person p3 = new Person(3,"Gggg", LocalDate.of(1990,06,25));
        Person p4 = new Person(4,"hhh", LocalDate.of(2010,04,21));
        Person p5 = new Person(5,"zZzz", LocalDate.of(1999,01,16));


        Product pr1= new Product(1,"Papa",100000.0);
        Product pr2= new Product(2,"Lulo",1777.0);
        Product pr3= new Product(3,"Lulo",20000.0);
        Product pr4= new Product(4,"Papaya",1000.0);
        Product pr5= new Product(5,"Yuca",40000.0);

        List<Person> personList= Arrays.asList(p1,p2,p3,p4,p5);
        List<Product> productList=Arrays.asList(pr1,pr2,pr3,pr4,pr5);

        //Métodos a referencia, si tengo en la izq lo que envio en la funcion de la der--> x-> sout(x)
        //(x-> System.out.println(x)) == System.out::println
        personList.forEach(System.out::println);

        System.out.println("");

        //List<?>  recibir lista de cualquier tipo en un método
        //Stream(paralelStream trabaja con hilos más optimo) es un método que nos permite trabajar de forma declarativa las colecciones.
        //Filter(param-> predicate)
        personList.stream().filter(p-> Period.between(p.getBirthday(),LocalDate.now()).getYears()>=18)
                  .collect(Collectors.toList())
                  .forEach(System.out::println);

        //map (param-> funcion) //obtener lista de edades

        personList.stream().map(person -> Period.between(person.getBirthday(),LocalDate.now()).getYears())
                  .collect(Collectors.toList())
                  .forEach(System.out::println);

        personList.stream().map(p-> p.getName()+" Code")
                  .collect(Collectors.toList())
                  .forEach(System.out::println);

        Function<Person,String> nameFunction= name-> "Code" + name.getName(); //recibe, salida

        personList.stream().map(nameFunction)
                            .collect(Collectors.toList())
                            .forEach(System.out::println);

        //sorted, ordenar una coleccion (param-> Comparator)

        //Comparator, criterio de comparación(lambda)

        Comparator<Person> byNameAsc= (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Person> byNameDesc= (Person o1, Person o2) -> o2.getName().compareTo(o1.getName());
        Comparator<Person> byBirthDateAsc= (Person o1, Person o2) -> o1.getBirthday().compareTo(o2.getBirthday());

        personList.stream()
                    .sorted(byNameAsc)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        System.out.println("");

        personList.stream()
                    .sorted(byBirthDateAsc)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);



        //Match, (param-> predicate)  AllMatch, noneMatch AnyMatch(alguno cumple? no ejecuta todos, hasta que uno cumpla)
        //  retorna boolean

        boolean rpta=personList.stream()
                    .anyMatch(p-> p.getName().startsWith("B"));

        System.out.println(rpta);

        //podemos usar Predicate, dónde lo indicamos

        Predicate<Person> startsWithB= person -> person.getName().startsWith("B");

        boolean rpta2=personList.stream()
                .anyMatch(startsWithB);

        //Limit-Skip

        personList.stream()
                    .skip(4) //salta los primeros 4
                        .collect(Collectors.toList())
                            .forEach(System.out::println);

        personList.stream()
                .limit(2) //trae los dos primeros
                .collect(Collectors.toList())
                .forEach(System.out::println);

        int pageNumber=1;  //cambia
        int pageSize=2;
        personList.stream()
                .skip(pageNumber * pageSize)
                .limit(pageSize) //trae los dos primeros
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Double::sum , summarizingDouble, groupping By, interfaces funcionales

        Map<String,Long> mapita=productList.stream().collect(Collectors.groupingBy(p-> p.getName(),Collectors.counting()));
        System.out.println(mapita);

        Function<Integer,Integer> integerFunction= value-> value+10;

        System.out.println(integerFunction.apply(10));





        //Optional.of(valor)
        Optional<String> optionalS=Optional.empty();

        System.out.println(optionalS.orElse("Nothing"));

        System.out.println(Period.between(LocalDate.of(1999,8,5),LocalDate.now()).getYears());


    }

}
