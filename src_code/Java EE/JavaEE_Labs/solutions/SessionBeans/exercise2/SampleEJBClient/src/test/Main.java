package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            BasicSessionRemote bean = (BasicSessionRemote) ctx.lookup("java:global/SampleEJBApplication/BasicSessionBean");
            System.out.println("Message: " + bean.getMessage());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
