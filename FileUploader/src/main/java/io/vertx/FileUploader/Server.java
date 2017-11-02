package io.vertx.FileUploader;

import io.vertx.core.AbstractVerticle;

/**
 * Created by ankit07 on 5/3/16.
 */
public class Server extends AbstractVerticle {

    static String contentType = "Content-Type";
    static String contentValue = "application/json";

    public void start(){

        for (Integer p = 0; p < 5; p++) {

            System.out.println("ADDING THIS LINE");
            System.out.println("/dev/sd" + (char) (p + 102));

        }

    }
}
