import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));
        Class<BasePerson> basePersonClass = BasePerson.class;
        Class<Employee> employeeClass = Employee.class;


        Field[] fields = basePersonClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Name: " + field.getName() + " Type: " + field.getType().getSimpleName());
        }



        Method age = basePersonClass.getMethod("getAge",null);
        System.out.println(age.getReturnType());
        Employee employee = employeeClass.getDeclaredConstructor(String.class, String.class, int.class, String.class).newInstance("Alex","Smith",22,"Marketing");
        System.out.println(age.invoke(employee));
    }
}
