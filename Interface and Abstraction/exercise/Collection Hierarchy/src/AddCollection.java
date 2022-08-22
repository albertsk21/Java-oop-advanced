public class AddCollection extends Collection  implements Addable{


    @Override
    public int add(String element) {

        if(super.items.size() == 0){
            super.items.add(element );
            return 0;
        }else{
            super.items.add(super.items.size() - 1,element );
            return super.items.size() - 1;
        }

    }
}
