package api.lambda.interfaces.e01;

import java.util.List;
import java.util.function.Consumer;


public class ConsumerTest {
  
  public static void main(String[] args) {
    
    List<Employee> eList = Employee.createShortList();
    Employee first = eList.get(0);
    
    Consumer<Employee> eCons = e -> e.printSummary(); // Write your consumer lambda here
    
    System.out.println("=== First Salary");
    // Call your consumer here
    eCons.accept(first);
    
  }
}
