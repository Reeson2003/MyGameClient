package ru.reeson2003.model.service.messages.remote_messages;

import ru.reeson2003.model.service.messages.Msg;
import ru.reeson2003.model.service.Address;

/**
 * Created by reeson on 02.01.17.
 */
public class HitMsgRemote extends Msg {
    public HitMsgRemote(Address from, Address to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void exec() {
    }
}
