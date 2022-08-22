import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> aClass = Reflection.class;


        Class<BasePerson> basePersonClass  = BasePerson.class;

        for (Field field : basePersonClass.getDeclaredFields()) {


            int modifiers =  field.getModifiers();
            boolean isPrivate = Modifier.isPublic(modifiers);
            System.out.println(modifiers);
            System.out.println(isPrivate);
        }



    }
}
