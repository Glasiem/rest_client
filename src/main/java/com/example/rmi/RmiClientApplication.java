package com.example.rmi;

import com.example.rmi.remote.RemoteDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SpringBootApplication
public class RmiClientApplication {
	public static RemoteDB remoteDB; // Assuming you've configured this bean
	public static final String UNIQUE_BINDING_NAME = "server.db";

	public static void main(String[] args) throws RemoteException, NotBoundException {
		final Registry registry = LocateRegistry.getRegistry(8081);
		remoteDB = (RemoteDB) registry.lookup(UNIQUE_BINDING_NAME);

		SpringApplication.run(RmiClientApplication.class, args);
	}

}
