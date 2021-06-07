package com.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImp implements  MyRemote{
    public String sayHello()  {
        return "Servber says Hello!";
    }

    public MyRemoteImp(){}

    public static void main(String[] args) {
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            MyRemote service = new MyRemoteImp();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
