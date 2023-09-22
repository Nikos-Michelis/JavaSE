import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Class<?> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (var field: fields)
            System.out.println(field);

        Person p = new Person("John", "Doe", "15th str.", 1000);

        try {
            Field field = personClass.getDeclaredField("firstName");
            field.setAccessible(true);// make them Accessible
            field.set(p, "Bob");// and change the value to "Bob"
            System.out.println(p);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

