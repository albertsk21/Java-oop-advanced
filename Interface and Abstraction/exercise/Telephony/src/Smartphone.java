import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public class Smartphone implements Callable,Browsable {



    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String browse() {

        Pattern pattern = Pattern.compile("[0-9]+");

        String output = "";


        for (int i = 0; i < this.urls.size() ; i++) {


            String url = this.urls.get(i);
            Matcher matcher = pattern.matcher(url);



            if(i == this.urls.size() - 1){

                if(withoutNumbers(url)){
                    output += String.format("Browsing: %s!",url);

                }else{
                    output += "Invalid URL!";

                }
            }else{

                if(withoutNumbers(url)){
                    output += String.format("Browsing: %s!\n",url);

                }else{
                    output += "Invalid URL!\n";

                }
            }


        }

        return output;
    }

    @Override
    public String call(){


        String output = "";


        for (int i = 0; i < this.numbers.size() ; i++) {


            String number = this.numbers.get(i);




            if(i == this.numbers.size() - 1){

                if(justNumbers(number)){
                    output += String.format("Calling... %s",number);

                }else{
                    output += "Invalid number!";

                }
            }else{

                if(justNumbers(number)){
                    output += String.format("Calling... %s\n",number);

                }else{
                    output += "Invalid number!\n";

                }
            }


        }

        return output;
    }

    public static boolean justNumbers(String item){

        Pattern pattern = Pattern.compile("[0-9]");


        for (int i = 0; i <item.length(); i++) {

            Matcher matcher = pattern.matcher(String.valueOf(item.charAt(i)));

            if(!matcher.find()){
                return false;
            }


        }


        return true;
    }
    public static boolean withoutNumbers(String item){

        Pattern pattern = Pattern.compile("[0-9]");


        for (int i = 0; i <item.length(); i++) {

            Matcher matcher = pattern.matcher(String.valueOf(item.charAt(i)));

            if(matcher.find()){
                return false;
            }


        }


        return true;
    }


}
