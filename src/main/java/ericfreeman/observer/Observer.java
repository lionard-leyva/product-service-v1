package ericfreeman.observer;

public interface Observer<T> {
    void update(T data);
}
