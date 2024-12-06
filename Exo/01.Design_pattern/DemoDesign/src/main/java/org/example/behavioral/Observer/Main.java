//package org.example.behavioral.Observer;
//
//import MyObserver;
//
//public class Main {
//    public static void main(String[] args) {
//        Subject subject = new Subject();
//
//        Observer observer1 = new MyObserver("Observer 1");
//        Observer observer2 = new MyObserver("Observer 2");
//
//        subject.addObserver(observer1);
//        subject.addObserver(observer2);
//
//        subject.notifyObservers("msg 1");
//        subject.notifyObservers("msg 2");
//
//        subject.removeObserver(observer1);
//        subject.notifyObservers("msg 3");
//    }
//}
