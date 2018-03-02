package com.zhangyk;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunkai on 7/12/17.
 */
public class SimpleWebSocketClient {

    public static void main(String[] args)
    {
        String destUri = "ws://localhost:8080/websocket";
        if (args.length > 0)
        {
            destUri = args[0];
        }

        WebSocketClient client = new WebSocketClient();
        SimpleWebSocket socket = new SimpleWebSocket();
        try
        {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket,echoUri,request);
            System.out.printf("Connecting to : %s%n",echoUri);

            // wait for closed socket connection.
            socket.awaitClose(5, TimeUnit.SECONDS);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        finally
        {
            try
            {
                client.stop();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
