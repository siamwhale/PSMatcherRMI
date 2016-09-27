
package psmatcherrmi;
/**
 *
 * @author siamwhale
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PSMatcherInf extends Remote {
    public String getMessage() throws RemoteException;
}
