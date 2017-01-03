package ru.reeson2003.model;

import java.io.*;
import java.net.Socket;
import java.util.List;
import ru.reeson2003.model.service.client_content.ClientPacketMessage;
import ru.reeson2003.model.service.client_content.CreatureSurrogate;
import ru.reeson2003.model.service.client_content.PlayerCharacterSurrogate;
import ru.reeson2003.model.service.messages.Msg;
import ru.reeson2003.model.service.messages.remote_messages.HitMsgRemote;
import ru.reeson2003.view.MainWindow;

/**
 * Created by reeson on 02.01.17.
 */
public class ClientTest {
    public static void main(String[] args) {
        Socket socket = null;
        MainWindow mainWindow = new MainWindow();
        try {
            socket = new Socket("localhost", 4242);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can not open client socket");
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can not get client i/o stream");
        }
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientPacketMessage clientPacketMessage = null;
        while (true) {
            try {
                Object message = objectInputStream.readObject();
                clientPacketMessage = (ClientPacketMessage) message;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PlayerCharacterSurrogate player = clientPacketMessage.getPlayerSurrogate();
            List<CreatureSurrogate> creatureSurrogates = clientPacketMessage.getCreatures();
            StringBuilder sb = new StringBuilder();
            sb.append(player);
            for (CreatureSurrogate c: creatureSurrogates) {
                sb.append("\n");
                sb.append(c);
            }
            mainWindow.showText(sb.toString());
            Msg toServer = new HitMsgRemote(player.getAddress(), creatureSurrogates.get(0).getAddress());
            try {
                objectOutputStream.writeObject(toServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
