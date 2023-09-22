public class Main {

    public static void main(String[] args) {

        try {
            Class<?> myClass = Class.forName("Person");
            // return the class Name
            System.out.println(myClass.getName());
            // scan all class methods and print
            for (var method: myClass.getMethods())
                System.out.println(method);
            System.out.println("=".repeat(20));
            // scan all class fields and print
            for (var field: myClass.getFields())
                System.out.println(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

