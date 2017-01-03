package ru.reeson2003.model.service.client_content;

import java.io.Serializable;
import java.util.List;

/**
 * Created by reeson on 02.01.17.
 */
public class ClientPacketMessage implements Serializable {
    private static final long serialVersionUID = 12L;
    private PlayerCharacterSurrogate playerSurrogate;
    private List<CreatureSurrogate> creaturesSurrogate;

    public ClientPacketMessage() {
    }

    public PlayerCharacterSurrogate getPlayerSurrogate() {
        return playerSurrogate;
    }

    public List<CreatureSurrogate> getCreatures() {
        return creaturesSurrogate;
    }

    public void setPlayerSurrogate(PlayerCharacterSurrogate playerSurrogate) {
        this.playerSurrogate = playerSurrogate;
    }

    public void setMonsters(List<CreatureSurrogate> creaturesSurrogate) {
        this.creaturesSurrogate = creaturesSurrogate;
    }
}
