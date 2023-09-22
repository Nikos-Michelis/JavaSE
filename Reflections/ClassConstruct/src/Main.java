public class Main {

    public static void main(String[] args) {

        Person p = new Person("John", "Doe", "15th road 112", 1000);
        Class<?> myClass = p.getClass();
        System.out.println(myClass.getName());

        Class<?> myClass2 = Person.class;
        System.out.println(myClass2.getName());
    }
}

