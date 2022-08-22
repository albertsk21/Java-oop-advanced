import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person > people = addPeople(bfr);
        Map<String, Product> products = addProducts(bfr);


        String[] input = bfr.readLine().split(" ");
        while(!input[0].equals("END")){

            //---GET-INFORMATION---//
            String namePerson = input[0];
            String nameProduct = input[1];

            //---GET-OBJECTS---//
            Person person = people.get(namePerson);
            Product product = products.get(nameProduct);
            person.buyProduct(product);

            //---INSERT-OBJECT---//
            people.put(namePerson,person);

            //---NEXT-LINE---//
            input = bfr.readLine().split(" ");
        }

        Map<String, List<String>> productAndPerson =  getProductAndPeopleNames(people);
        print(productAndPerson);



    }

    public static void print( Map<String, List<String>> productAndPerson){

        for (String person : productAndPerson.keySet()) {

            List<String> products = productAndPerson.get(person);

            StringBuilder   output = new StringBuilder(String.format("%s - ",person));

            for (int i = 0; i < products.size(); i++) {

                if(i == products.size() - 1){
                    output.append(products.get(i));
                }else{
                    output.append(String.format("%s, ",products.get(i)));
                }

            }
            System.out.println(output);
        }



    }
    public static Map<String, List<String>> getProductAndPeopleNames(Map<String, Person > people){

        Map<String, List<String>> productAndPerson =  new LinkedHashMap<>();


        for (Person person : people.values()) {

            if(person.getProducts().isEmpty()){
                List<String> noProduct = new ArrayList<>();
                noProduct.add("Nothing bought");
                productAndPerson.put(person.getName(),noProduct);
            }else{
                List<String> productsList = getNamesProducts(person.getProducts());
                productAndPerson.put(person.getName(),productsList);
            }

        }
        return productAndPerson;
    }
    public static List<String> getNamesProducts (List<Product> products){

        List<String> getNames = new ArrayList<>();

        for (Product product : products) {
            getNames.add(product.getName());
        }
        return getNames;
    }
    public static Map<String, Person> addPeople(BufferedReader bfr) throws IOException {

        Map<String, Person > people = new LinkedHashMap<>();
        String[] input = bfr.readLine().split(";");
        for (String s : input) {
            String[] tokens = s.split("=");
            String name = tokens[0];
            name = name.replaceAll(" ","");
            double money = Double.parseDouble(tokens[1]);
            Person person = new Person(name, money);
            people.put(name, person);

        }
        return people;
    }
    public static Map<String, Product> addProducts(BufferedReader bfr) throws IOException {

        Map<String, Product > products = new LinkedHashMap<>();
        String[] input = bfr.readLine().split(";");
        for (String s : input) {
            String[] tokens = s.split("=");
            String name = tokens[0];
            name = name.replaceAll(" ","");
            double cost = Double.parseDouble(tokens[1]);
            Product product =  new Product(name,cost);
            products.put(name, product);

        }
        return products;
    }

}
