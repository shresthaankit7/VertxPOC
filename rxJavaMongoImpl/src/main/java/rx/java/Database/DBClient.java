package rx.java.Database;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.mongo.impl.MongoClientImpl;
import rx.Observable;

/**
 * Created by ankit07 on 9/18/16.
 */
public class DBClient {

    public static MongoClient mongoClient;

    public static JDBCClient jdbcClient;

    public DBClient(Vertx vertx, JsonObject config{
        System.out.println("WAYNE ROONEY");
        JsonObject c = new JsonObject()
                .put("driver_class","com.mysql.jdbc.Driver")
                .put("url", "jdbc:mysql://localhost:3306/first")
                .put("user","root")
                .put("password","asdf123");

        this.jdbcClient = JDBCClient.createShared(vertx,c);
        System.out.println("MANCHESTER UNITED");

    }

    public static MongoClient getMongoClient(){
        return mongoClient;
    }
}
