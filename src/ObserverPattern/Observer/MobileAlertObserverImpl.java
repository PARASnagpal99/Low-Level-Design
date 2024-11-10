package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String phoneNumber;
    StocksObservable observable;

    public MobileAlertObserverImpl(String phoneNumber, StocksObservable stocksObservable) {
        this.phoneNumber = phoneNumber;
        this.observable = stocksObservable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(phoneNumber, "product is in stock hurry up!");
    }

    void sendMsgOnMobile(String number, String message) {
        System.out.println("message sent on number " + number);
    }
}
