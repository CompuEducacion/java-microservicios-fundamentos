package api.stream.e01;

import java.util.List;
import java.util.function.Predicate;

public class RoboMail01 {

    public void mail(List<Employee> pl, Predicate<Employee> pred) {
        for (Employee e : pl) {
            if (pred.test(e)) {
                roboMail(e);
            }
        }
    }

    public void text(List<Employee> pl, Predicate<Employee> pred) {
        for (Employee e : pl) {
            if (pred.test(e)) {
                roboText(e);
            }
        }
    }

    public void roboMail(Employee p) {
        System.out.println("Emailing: " + p.getGivenName()
                + " " + p.getSurName() + " age " + p.getAge()
                + " at " + p.getEmail());
    }

    public void roboText(Employee p) {
        System.out.println("Texting: " + p.getGivenName()
                + " " + p.getSurName() + " age " + p.getAge()
                + " at " + p.getPhone());
    }
}