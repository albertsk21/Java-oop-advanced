import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {




        Class<BasePerson> basePersonClass = BasePerson.class;


        Field[] fields = basePersonClass.getDeclaredFields();

        for (Field field : fields) {

            int modifiers = field.getModifiers();
            boolean isPrivate = Modifier.isPrivate(modifiers);
            if(isPrivate){
                System.out.println(isPrivate);
            }

        }


    }
}
