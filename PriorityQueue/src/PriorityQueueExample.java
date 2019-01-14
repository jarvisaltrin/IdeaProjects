import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {
    public static void main(String[] args){
        // Natural ordering example of Priority Queue
        Queue<Integer>  integerQueue = new PriorityQueue<Integer>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
            integerQueue.add(rand.nextInt(100));
        }
        for(int i=0;i<7;i++){
            Integer in = integerQueue.poll();
            System.out.println("Processing Integer: "+in);
        }

        // Priority Queue example with Comparator
        Queue<Customer> customerQueue = new PriorityQueue<Customer>(7,idComparator);

        addDataToQueue(customerQueue);

        pollDataFromQueue(customerQueue);
    }

    // Comparator anonymous class implementation
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return (int) (o1.getId() - o2.getId());
        }
    };

    private static void addDataToQueue(Queue<Customer> customerQueue){
        Random rand = new Random();
        for(int i=0;i<7;i++){
            int id = rand.nextInt(100);
            customerQueue.add(new Customer(id, "Name "+id));
        }
    }

    private static void pollDataFromQueue(Queue<Customer> customerQueue){
        while(true){
            Customer customer = customerQueue.poll();
            if (customer == null)
                break;
            System.out.println("Processing Customer with ID: "+customer.getId());
            System.out.println("Processing Customer with name: "+customer.getName());
        }
    }
}
