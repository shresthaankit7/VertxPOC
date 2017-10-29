package rx.java.Server;
import io.vertx.core.json.JsonObject;
import rx.Observable;
import io.vertx.rxjava.core.AbstractVerticle;
import rx.java.Database.DBService;

import java.util.ArrayList;

/**
 * Created by ankit07 on 9/18/16.
 */
public class Server extends AbstractVerticle {


    public void start(){

        Observable output = getOutput();

        output.subscribe(s->{
            System.out.println("OUTPUT -> " + s.toString());
        });

    }

    public Observable getOutput() {
        System.out.println("Get Observable Called !!!");

        ArrayList multiplicantList = new ArrayList<Integer>();

        multiplicantList.add(2);
        multiplicantList.add(3);
        multiplicantList.add(4);

        Integer tempValue = new Integer(0);

        JsonObject c = new JsonObject()
                .put("driver_class","com.mysql.jdbc.Driver")
                .put("url", "jdbc:mysql://localhost:3306/first")
                .put("user","root")
                .put("password","asdf123");

        DBService dbService = new DBService();

        System.out.println("HERE!!!");

        dbService.select(vertx,c).subscribe(s->{
            System.out.println("*****  ->" + s.toString());
        });


        return Observable.just("HI!!!!!");
    }
}
