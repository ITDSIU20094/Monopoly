package SettingWindow;

import Controller.CommunicationController;
import Model.GameEngine;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client extends Thread {
    private Thread thread;
    private String threadName;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    private CommunicationController communicationController = CommunicationController.getInstance();
    private GameEngine gameEngine = GameEngine.getInstance();
    public Client(String name) {
        threadName = name;

    }
    public void sendMessage(Object msg) {
        try {
            outObject.writeObject(msg);
            outObject.reset();
        } catch (Exception e) {
            System.out.println("[Client]: Error during sendMessage" + e);
        }
    }
    @Override
    public void start() {
        System.out.println("[Client]: Thread created with name " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}