
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bfr.readLine().split("\\s+");
        int removeCounter = Integer.parseInt(bfr.readLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        List<Integer> resultAddToAddRemoveCollection = new ArrayList<>();
        List<Integer> resultAddMyList = new ArrayList<>();
        List<Integer> resultAddCollection = new ArrayList<>();

        for (String element : arr) {
            resultAddToAddRemoveCollection.add(addRemoveCollection.add(element));
            resultAddMyList.add(myList.add(element));
            resultAddCollection.add(addCollection.add(element));
        }
        System.out.println(printIndexes(resultAddCollection));
        System.out.println(printIndexes(resultAddToAddRemoveCollection));
        System.out.println(printIndexes(resultAddMyList));





        StringBuilder removeFirstCollection = new StringBuilder();
        StringBuilder removeSecondCollection = new StringBuilder();

        for (int i = 0; i < removeCounter ; i++) {

            if(i == removeCounter - 1){
                removeFirstCollection.append(addRemoveCollection.remove());
                removeSecondCollection.append(myList.remove());

            }else{
                removeFirstCollection.append(addRemoveCollection.remove()).append(" ");
                removeSecondCollection.append(myList.remove()).append(" ");

            }
        }
        System.out.println(removeFirstCollection);
        System.out.println(removeSecondCollection);
    }


    public static String printIndexes(List<Integer> list){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                output.append(list.get(i));
            }else{
                output.append(String.format("%d ",list.get(i)));
            }
        }
        return output.toString();
    }

}