package test;

import javax.ejb.Stateless;

@Stateless
public class BasicSessionBean implements BasicSessionRemote {

    public String getMessage() {
        return "Hello EJB World";
    }
}
