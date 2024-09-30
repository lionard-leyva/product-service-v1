package ericfreeman.observer;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer<Float>> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    JFrame Frame;
    public WeatherData() {
        observers = new ArrayList<>();

    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers() {

    }
}
