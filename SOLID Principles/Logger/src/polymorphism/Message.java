package polymorphism;

public class Message {

    private String message;


    public Message(String message){
        this.message = message;
    }


    public void setDate(String date) {
        this.message = date;
    }

    public String getDate() {
        return message;
    }
}
