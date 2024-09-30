package ericfreeman.observer;

import java.util.List;
import java.util.ArrayList;

public interface Subject<T> {
    void registerObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void notifyObservers();
}

