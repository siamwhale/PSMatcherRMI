/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psmatcherrmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author siamwhale
 */
public class PSMatcherServer implements PSMatcherInf {
    public static final String MESSAGE = "Hello world";
    
    public PSMatcherServer() throws RemoteException {
    	
    }
    
    public String getMessage() throws RemoteException {
        return MESSAGE;
    }
 
    public static void main(String args[]) throws Exception {
        System.out.println("PSMatcherServer started");
        
        //Instantiate RmiServer
        PSMatcherServer obj = new PSMatcherServer();
 
        try { //special exception handler for registry creation
        	
            PSMatcherInf stub = (PSMatcherInf) UnicastRemoteObject.exportObject(obj,0);
            Registry reg;
            try {
            	reg = LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created.");

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	reg = LocateRegistry.getRegistry();
            }
        	reg.rebind("PSMatcherServer", stub);

        } catch (RemoteException e) {
        	e.printStackTrace();
        }
    }
}
