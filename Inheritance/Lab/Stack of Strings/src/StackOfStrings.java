import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackOfStrings {


    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }


    public void push(String str){
        data.add(0 , str);
    }


    public String pop(){
        String element = data.get(0);
        this.data.remove(0);
        return element;
    }

    public boolean isEmpty(){
        return  this.data == null || this.data.size() == 0;
    }



    public String peek(){

        if(data.isEmpty()){
            throw new EmptyStackException();
        }


        return data.get(data.size() - 1);

    }

}
