package com.sparta.ahmed.model;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadManager {

    private final CopyOnWriteArrayList<Thread> threads = new CopyOnWriteArrayList<>();
    private final ArrayList<EmployeeDTO> employees;
    private static final int NUMBER_OF_THREADS = 10;

    public ThreadManager(ArrayList<EmployeeDTO> employees) {
        this.employees = employees;
    }
    
    public void createThread(ArrayList<EmployeeDTO> splitList) {
        threads.add(new Thread(new EmployeeWriter(splitList)));
    }

    public void runThreads() {
        splitArrayList(employees);
        startThreads();
    }

    public synchronized void startThreads() {
        for (Thread thread : threads) {
            thread.start();
            while (thread.isAlive()) {
            }
        }
    }

    public void splitArrayList(ArrayList<EmployeeDTO> listToSplit) {
        int numberInEachList = listToSplit.size() / NUMBER_OF_THREADS;
        if (listToSplit.size() < 500) {
            return;
        }

        int lastIndex = listToSplit.size();
        int midIndex = (listToSplit.size() / 2);

        ArrayList<EmployeeDTO> firstHalf = new ArrayList<>(listToSplit.subList(0, midIndex));
        ArrayList<EmployeeDTO> secondHalf = new ArrayList<>(listToSplit.subList(midIndex, lastIndex));

        splitArrayList(firstHalf);
        splitArrayList(secondHalf);

        if (firstHalf.size() <= 500) {
            createThread(firstHalf);
        }
        if (secondHalf.size() <= 500) {
            createThread(secondHalf);
        }
    }


}
