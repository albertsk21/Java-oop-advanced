import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){


        Class<Reflection> reflectionClass = Reflection.class;

        Method[] getMethods = Arrays
                .stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted((f,s)-> f.getName().compareTo(s.getName()))
                .toArray(Method[]::new);

        Method[] setMethods = Arrays
                .stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted((f,s)-> f.getName().compareTo(s.getName()))
                .toArray(Method[]::new);

        for (Method method: getMethods) {
            System.out.printf("%s will return a field of the class %s%n",method.getName(),method.getReturnType().getName());
        }

        for (Method method: setMethods) {
            System.out.printf("%s will set a field of the class %s%n",method.getName(),method.getParameterTypes()[0].getName());
        }



    }
}
