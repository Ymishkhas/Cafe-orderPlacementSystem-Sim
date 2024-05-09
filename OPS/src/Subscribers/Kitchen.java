package Subscribers;

public class Kitchen implements Subscriber{
    @Override
    public void notify(String orderDetails)
    {
        // Send to kitchen
        System.out.println("\nOrder sent to Cafe...");
    }
}
