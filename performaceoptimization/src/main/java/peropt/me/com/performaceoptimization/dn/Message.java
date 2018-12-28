package peropt.me.com.performaceoptimization.dn;

/**
 * desc:
 */
public class Message {
    public Handler target;
    public Object obj;
    
    @Override
    public String toString() {
        return obj.toString();
    }
    
    public Message() {
        
    }
}
