package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
       String emailId ;
       StocksObservable observable ;

       public EmailAlertObserverImpl(String emailId , StocksObservable stocksObservable){
           this.observable = stocksObservable ;
           this.emailId = emailId ;
       }

       @Override
       public void update(){
           sendMail(emailId , "product is in stock , hurryUp");
       }

       public void sendMail(String emailId , String msg){
              System.out.println("mail sent to : " + emailId);
       }
}
