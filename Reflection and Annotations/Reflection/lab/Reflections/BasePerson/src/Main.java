import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));
        Class<BasePerson> basePersonClass = BasePerson.class;
        System.out.println(basePersonClass.getName());


        //---GET-CLASS---//
        Class<?> basePersonClassForName = Class.forName("BasePerson");
        System.out.println("Class name without the package name: " + basePersonClass.getSimpleName());


        //---GET-INTERFACE---//
        Class<?>[] interfaces = basePersonClass.getInterfaces();
        for ( Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        //---GET-SUPER-CLASS---//
        Class<? super BasePerson> basePersonSuperClass = basePersonClass.getSuperclass();
        System.out.println(basePersonSuperClass.getSimpleName());





        //---SUPER-CLASS-FROM-ANOTHER-CLASS---//
        Class<Employee> employeeClass = Employee.class;
        System.out.println(employeeClass.getSuperclass());

        //*- Get just name from super class -*//
        System.out.println(employeeClass.getSuperclass().getSimpleName());



    }
}
