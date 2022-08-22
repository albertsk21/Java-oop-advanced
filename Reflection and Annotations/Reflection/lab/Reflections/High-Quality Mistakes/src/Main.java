import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){


    Class<Reflection> reflectionClass = Reflection.class;



        //CHECK FIELDS
        Field[] fields = reflectionClass.getDeclaredFields();
        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(field -> System.out.printf("%s must be private!%n",field.getName()));


        Method[] methods = reflectionClass.getDeclaredMethods();
        //CHECK GETTERS
        Arrays.stream(methods)
                .filter(method -> !Modifier.isPublic(method.getModifiers()) && method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(method -> System.out.printf("%s must be public!%n",method.getName()));

        //CHECK SETTERS
        Arrays.stream(methods)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()) && method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(method -> System.out.printf("%s must be private!%n",method.getName()));





    }
}
