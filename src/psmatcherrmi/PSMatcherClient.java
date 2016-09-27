/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psmatcherrmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author siamwhale
 */
public class PSMatcherClient {
    public static void main(String args[]) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        PSMatcherInf  obj = (PSMatcherInf ) registry.lookup("PSMatcherServer");
        System.out.println(obj.getMessage()); 
    }
}
