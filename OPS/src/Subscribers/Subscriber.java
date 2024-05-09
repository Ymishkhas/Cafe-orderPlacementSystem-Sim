package Subscribers;

public interface Subscriber {
    //can receive controller object or even order object instead of String and print
    //as per kitchen or subscribee desired formatting
    public void notify(String orderDetails);
}
