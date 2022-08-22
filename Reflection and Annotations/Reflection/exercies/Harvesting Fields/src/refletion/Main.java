package refletion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        String input = bfr.readLine();
        while (!input.equals("HARVEST")) {
            switch (input) {
                case "private":
                    print(privateFields(richSoilLandClass));
                    break;
                case "protected":
                    print(protectedFields(richSoilLandClass));
                    break;
                case "public":
                    print(publicFields(richSoilLandClass));
                    break;
                case "all":
                    print(allFields(richSoilLandClass));
                    break;
            }

            input = bfr.readLine();
        }

    }

    public static Field[]  privateFields(Class<RichSoilLand> richSoilLandClass){
        return Arrays.stream(richSoilLandClass.getDeclaredFields())
                .filter(field -> Modifier.isPrivate(field.getModifiers()))
                .toArray(Field[]::new);
    }
    public static Field[]  publicFields(Class<RichSoilLand> richSoilLandClass){
        return Arrays.stream(richSoilLandClass.getDeclaredFields())
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .toArray(Field[]::new);
    }
    public static Field[]  protectedFields(Class<RichSoilLand> richSoilLandClass){
        return Arrays.stream(richSoilLandClass.getDeclaredFields())
                .filter(field -> Modifier.isProtected(field.getModifiers()))
                .toArray(Field[]::new);
    }
    public static Field[]  allFields(Class<RichSoilLand> richSoilLandClass){
        return richSoilLandClass.getDeclaredFields();
    }
    public static void print( Field[] fields){
        for (Field field: fields) {
            System.out.printf("%s %s %s%n",checkModifier(field), field.getType().getSimpleName(),field.getName());
        }
    }
    public static String checkModifier(Field field){
        if(Modifier.isPublic(field.getModifiers())){
            return "public";
        }if(Modifier.isProtected(field.getModifiers())){
            return "protected";
        }if(Modifier.isPrivate(field.getModifiers())){
            return "private";
        }
        return null;
    }
}
