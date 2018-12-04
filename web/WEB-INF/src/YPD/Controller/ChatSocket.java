/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YPD.Controller;

import java.io.IOException;
import java.util.HashMap;
import javax.websocket.*;
import javax.websocket.Session;
import javax.websocket.server.*;


/**
 *
 * @author RuiFeng, MengMeng
 */
@ServerEndpoint("/websocket")
public class ChatSocket {
    
    class ChatRoom {
        ChatSocket doc;
        ChatSocket user;
        String username;
        public ChatRoom(ChatSocket doc, ChatSocket user, String username) {
            this.doc = doc;
            this.user= user;
            this.username = username;
        }
    }
    
    /**
     *
     */
    public static HashMap<String, ChatRoom> chatRooms = new HashMap();
    private Session session;

    /**
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
    }

    /**
     * 
     * 
     * @throws IOException
     */
    @OnClose
    public void onClose() throws IOException{
        for(String key: chatRooms.keySet()) {
            ChatRoom cr = chatRooms.get(key);
            if(this==cr.doc) {
                chatRooms.remove(key);
                cr.doc.sendMessage("message:doctor close the chat..");
                break;
            } else if(this==cr.user) {
                cr.user = null;
                cr.doc.sendMessage("message:"+cr.username+",close the chat");
                cr.username = "";
            }
        }
    }

    /**
     * 
     * 
     * @param message 
     * @param session 
     * @throws java.io.IOException 
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        
        if(message.startsWith("open:")) {
            String roomNum  = message.replace("open:", "");
            if(chatRooms.containsKey(roomNum)) {
                sendMessage("error:This doctor has linked!");
            } else {
                chatRooms.put(roomNum, new ChatRoom(this, null, ""));
            }
        } else if(message.startsWith("connect:")) {
            
            String[] userInfo  = message.replace("connect:", "").split(",");
            if(userInfo.length!=2) return;
            String roomNum = userInfo[0];
            String username = userInfo[1];
            if(!chatRooms.containsKey(roomNum)) {
                sendMessage("error:This doctor isn't online now!");
            } else {
                if(chatRooms.get(roomNum).user!=null) {
                    sendMessage("error:This doctor is busy now!");
                } else {
                    chatRooms.get(roomNum).user = this;
                    chatRooms.get(roomNum).username = username;
                
                    chatRooms.get(roomNum).doc.sendMessage("message:"+chatRooms.get(roomNum).username+",has connected to your chat.");
                    chatRooms.get(roomNum).user.sendMessage("message:You have connected to the doctor.");
                
                }
            }
            
        } else if(message.startsWith("message:")) {
            String[] messageInfo  = message.replace("message:", "").split(",");
            if(messageInfo.length!=3) return;
            String roomNum = messageInfo[0];
            String user = messageInfo[1];
            String msg = messageInfo[2];
            if(chatRooms.containsKey(roomNum)) {
                if(user.equals("user")) {
                    chatRooms.get(roomNum).doc.sendMessage("message:"+chatRooms.get(roomNum).username+","+msg);
                } else {
                    chatRooms.get(roomNum).user.sendMessage("message:"+msg);
                }
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
     
    }

    /**
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

  
}