import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args){
        Class<Reflection> aClass = Reflection.class;

        Class<Reflection> reflectionClass = Reflection.class;

        Method[] methods =  reflectionClass.getDeclaredMethods();


        for (Method method : methods) {

            System.out.println("Name: " + method.getName() + " ReturnType: " + method.getReturnType().getSimpleName());
        }



    }
}
