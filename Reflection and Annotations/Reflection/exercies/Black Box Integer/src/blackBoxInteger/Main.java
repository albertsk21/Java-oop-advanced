package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, NoSuchFieldException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Class<?> blackBoxIntClass = BlackBoxInt.class;
        Constructor<?> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();


        Field field;
        field = blackBoxIntClass.getDeclaredField("innerValue");
        field.setAccessible(true);


        String[] tokens = bfr.readLine().split("_");
        while (!tokens[0].equals("END")){

            makeOperation(blackBoxInt, tokens[0] ,Integer.parseInt(tokens[1]));
            System.out.println(field.get(blackBoxInt));
            tokens = bfr.readLine().split("_");

        }

    }
    private static void makeOperation(BlackBoxInt blackBoxInt,String nameOfOperation, int value)  {
        Method method;
        try {
            Class<?> blackBoxIntClass = BlackBoxInt.class;
            method = blackBoxIntClass.getDeclaredMethod(nameOfOperation,int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt,value);

        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
