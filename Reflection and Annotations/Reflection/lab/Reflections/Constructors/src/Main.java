
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));
        Class<BasePerson> basePersonClass = BasePerson.class;
        Class<Employee> employeeClass = Employee.class;

        Constructor<?>[] publicConstructors = basePersonClass.getConstructors();
        Constructor<?>[] allConstructors = basePersonClass.getDeclaredConstructors();

        Constructor<BasePerson> constructorFirstName = basePersonClass.getConstructor(String.class);
        Employee employee = employeeClass.getDeclaredConstructor(String.class,String.class,int.class,String.class).newInstance("Peter","John",22,"kjcdsjv");
        System.out.println(employee);

    }
}
