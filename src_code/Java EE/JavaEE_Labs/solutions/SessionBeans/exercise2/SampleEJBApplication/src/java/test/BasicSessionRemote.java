package test;

import javax.ejb.Remote;

@Remote
public interface BasicSessionRemote {

    String getMessage();
}
