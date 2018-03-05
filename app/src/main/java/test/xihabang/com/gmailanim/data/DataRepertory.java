package test.xihabang.com.gmailanim.data;

import java.util.ArrayList;
import java.util.List;
import test.xihabang.com.gmailanim.model.Message;

public class DataRepertory {

    public static List<Message> getData(){
      List<Message> dataList=new ArrayList<>();


      Message message1=new Message();
      message1.setId(1);
      message1.setImportant(false);
      message1.setPicture("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3939678082,2313710932&fm=27&gp=0.jpg");
      message1.setFrom("Google Alerts");
      message1.setSubject("Google Alert - android");
      message1.setMessage("Now android supports multiple voice recogonization");
      message1.setTimestamp("10:30 AM");
      message1.setRead(false);


      Message message2=new Message();
      message2.setId(2);
      message2.setImportant(true);
      message2.setFrom("Amazon.in");
      message2.setSubject("Apple Macbook Pro");
      message2.setMessage("Your Amazon.in Today's Deal Get Macbook Pro");
      message2.setTimestamp("9:20 AM");
      message2.setRead(false);
      dataList.add(message2);

      Message message3=new Message();
      message3.setId(3);
      message3.setImportant(false);
      message3.setPicture("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3939678082,2313710932&fm=27&gp=0.jpg");
      message3.setFrom("IMDB");
      message3.setSubject("Check out top rated movies this week");
      message3.setMessage("Find out the top rated movies this week by editor choice");
      message3.setTimestamp("9:15 AM");
      message3.setRead(false);
      dataList.add(message3);

      Message message4=new Message();
      message4.setId(4);
      message4.setImportant(false);
      message4.setPicture("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3939678082,2313710932&fm=27&gp=0.jpg");
      message4.setFrom("Dinesh Reddy, Me");
      message4.setSubject("Let's get started");
      message4.setMessage("I started working on project proposals. Wanted to know");
      message4.setTimestamp("9:00 AM");
      message4.setRead(true);
      dataList.add(message4);

      Message message5=new Message();
      message5.setId(5);
      message5.setImportant(false);
      message5.setFrom("BookMyShow");
      message5.setSubject("Will the lost boy find his family?");
      message5.setMessage("LION a movie that humanity needs. Online version report spam 97%");
      message5.setTimestamp("8:55 AM");
      message5.setRead(false);
      dataList.add(message5);


      Message message6=new Message();
      message6.setId(6);
      message6.setImportant(false);
      message6.setFrom("MakeMyTrip");
      message6.setSubject("A joyous Train Ride in North East!");
      message6.setMessage("North East Package starting from Rs31,999/- only!");
      message6.setTimestamp("8:10 AM");
      message6.setRead(false);
      dataList.add(message6);


      Message message7=new Message();
      message7.setId(7);
      message7.setImportant(false);
      message7.setFrom("Disqus 14");
      message7.setSubject("Re: Comment on Android Working with");
      message7.setMessage("Hey Ravi, after following your article I am getting this error");
      message7.setTimestamp("8:10 AM");
      message7.setRead(true);
      dataList.add(message7);



      Message message8=new Message();
      message8.setId(8);
      message8.setImportant(true);
      message8.setFrom("Evans, Ravi 3");
      message8.setSubject("Advertisement Enquiry");
      message8.setMessage("Hello, I want to buy the advertising space on");
      message8.setTimestamp("7:59 AM");
      message8.setRead(false);


      Message message9=new Message();
      message9.setId(9);
      message9.setImportant(false);
      message9.setPicture("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3939678082,2313710932&fm=27&gp=0.jpg");
      message9.setFrom("Karthik Tamada");
      message9.setSubject("Call Me");
      message9.setMessage("I am going home because I am not feeling well!");
      message9.setTimestamp("4:05 AM");
      message9.setRead(false);


      Message message10=new Message();
      message10.setId(10);
      message10.setImportant(false);
      message10.setFrom("Order-Update");
      message10.setSubject("Your Amazon order #408-2878882019");
      message10.setMessage("Your Orders | Amazon.in shipment of pendrive");
      message10.setTimestamp("5:00 AM");
      message10.setRead(true);


      Message message11=new Message();
      message11.setId(11);
      message11.setImportant(false);
      message11.setFrom("Instapage");
      message11.setSubject("Lead notification from Instapage");
      message11.setMessage("Congratulations! You just aquired a new lead");
      message11.setTimestamp("3:00 AM");
      message11.setRead(false);

      Message message12=new Message();
      message12.setId(12);
      message12.setImportant(false);
      message12.setFrom("Droid5");
      message12.setSubject("Droid5 Android Project");
      message12.setMessage( "Planning to start an android app for droid5");
      message12.setTimestamp("5:00 AM");
      message12.setRead(false);


      Message message13=new Message();
      message13.setId(13);
      message13.setImportant(true);
      message13.setFrom("Gmail Team");
      message13.setSubject("Gmail Business Suite");
      message13.setMessage("Your Gmail business suite is expiring today!");
      message13.setTimestamp("Feb 20");
      message13.setRead(true);

      Message message14=new Message();
      message14.setId(14);
      message14.setImportant(false);
      message14.setFrom("Medium Daily Digest");
      message14.setSubject("6 Things You need to know to Recover");
      message14.setMessage("Daily Digest Your daily three recommendations");
      message14.setTimestamp("8:15 AM");
      message14.setRead(false);

      Message message15=new Message();
      message15.setId(15);
      message15.setImportant(false);
      message15.setFrom("Alex, Ravi 24");
      message15.setSubject("Advertisement proposal to promote my android app");
      message15.setMessage("Hello Ravi, Thanks for your link. Here is the proposal");
      message15.setTimestamp( "Feb 17");
      message15.setRead(false);


      dataList.add(message1);
      dataList.add(message2);
      dataList.add(message3);
      dataList.add(message4);
      dataList.add(message5);
      dataList.add(message6);
      dataList.add(message7);
      dataList.add(message8);
      dataList.add(message9);
      dataList.add(message10);
      dataList.add(message11);
      dataList.add(message12);
      dataList.add(message13);
      dataList.add(message14);
      dataList.add(message15);

      return dataList;
    }

}
