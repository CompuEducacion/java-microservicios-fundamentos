package api.lambda.ops.e05;

/**
 *
 * @author oracle
 */
public enum State {    
    CA("CA"),
    CO("CO"),
    MA("MA");
    
    private final String str;
    
    State(String stateStr){
        this.str = stateStr;
    }
    
    public String getStr(){
        return str;
    }        
   
}
