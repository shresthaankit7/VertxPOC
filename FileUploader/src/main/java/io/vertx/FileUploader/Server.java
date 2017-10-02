package io.vertx.FileUploader;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.streams.Pump;
import io.vertx.ext.web.Router;

import java.util.UUID;

/**
 * Created by ankit07 on 5/3/16.
 */
public class Server extends AbstractVerticle {

    public void start(){

        System.out.println("line from Nepal branch!!!!!!!");
        Router router = Router.router(vertx);

        router.get("/fileupload").handler(routingContext ->{

            HttpServerResponse response = routingContext.response();

            response.putHeader("context-type","text/plain");
            response.setStatusCode(200);
            response.end("Resquest got");
        });

        HttpServer httpServer = vertx.createHttpServer().requestHandler(req -> {
            req.pause();
            String filename = UUID.randomUUID() + ".csv";
            vertx.fileSystem().open(filename, new OpenOptions(), ares -> {
                AsyncFile file = ares.result();
                Pump pump = Pump.pump(req, file);
                req.endHandler(v1 -> file.close(v2 -> {
                    System.out.println("Uploaded to " + filename);
                    req.response().end();
                }));
                pump.start();
                req.resume();
            });
        });
        httpServer.requestHandler(router::accept).listen(8080);

    }
}
