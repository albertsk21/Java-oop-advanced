public class MyListImpl extends Collection implements MyList{




    @Override
    public String remove() {
        return super.items.remove(super.items.size() - 1);
    }

    @Override
    public int add(String element) {
        if(super.maxSize > super.items.size()){
            super.items.add(element);
        }
        return 0;
    }

    @Override
    public int getUsed() {
        return super.items.size();
    }
}
