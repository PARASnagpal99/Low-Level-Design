package ObserverPattern;

import ObserverPattern.Observable.IPhoneObservableImpl;
import ObserverPattern.Observable.StocksObservable;
import ObserverPattern.Observer.EmailAlertObserverImpl;
import ObserverPattern.Observer.MobileAlertObserverImpl;
import ObserverPattern.Observer.NotificationAlertObserver;

public class Store {
       public static void main(String[] args){
           StocksObservable IphoneStockObservable = new IPhoneObservableImpl() ;

           NotificationAlertObserver notificationAlertObserver1 = new EmailAlertObserverImpl("paras.nagpal@rupeek.com", IphoneStockObservable);
           NotificationAlertObserver notificationAlertObserver2 = new EmailAlertObserverImpl("paras.nagpal743@gmail.com" , IphoneStockObservable);
           NotificationAlertObserver notificationAlertObserver3 = new MobileAlertObserverImpl("8168876354" , IphoneStockObservable);

           IphoneStockObservable.add(notificationAlertObserver1);
           IphoneStockObservable.add(notificationAlertObserver2);
           IphoneStockObservable.add(notificationAlertObserver3);

           IphoneStockObservable.setStockCount(10);
           IphoneStockObservable.setStockCount(100);
       }
}
