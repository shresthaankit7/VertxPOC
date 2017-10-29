package rx.java.Database;

import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.ext.jdbc.JDBCClient;
import rx.Observable;

/**
 * Created by ankit07 on 12/25/16.
 */
public class DBService {


    public Observable select(Vertx vertx, JsonObject config){

        System.out.println("Branch1 !!!!");
        JsonObject c = new JsonObject()
                .put("driver_class","com.mysql.jdbc.Driver")
                .put("url", "jdbc:mysql://localhost:3306/first")
                .put("user","root")
                .put("password","asdf123");

        JDBCClient client = JDBCClient.createShared(vertx,c);

        System.out.println("***********************");
        return Observable.create(subscriber -> {
            client.getConnectionObservable().subscribe(conn -> {

                conn.queryObservable("SELECT * FROM multipicant");
            });
        });

    }

}
