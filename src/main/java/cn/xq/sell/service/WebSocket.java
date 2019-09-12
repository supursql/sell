package cn.xq.sell.service;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: 紫苏
 * @date: 19-9-12 下午1:19
 * @description:
 */
@Component
@ServerEndpoint("/webSocket")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
    }

    @OnMessage
    public void onMessage(String message) {

    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSockets) {
            try {
                webSocket.session.getBasicRemote().sendText(message);

            } catch (Exception e) {

            }
        }
    }

}
