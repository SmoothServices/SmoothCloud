package eu.smoothservices.smoothcloud.node.network.protocol;

import eu.smoothservices.smoothcloud.node.network.network.NetworkUtils;
import eu.smoothservices.smoothcloud.node.network.protocol.file.FileProtocol;
import eu.smoothservices.smoothcloud.node.network.protocol.packet.PacketProtocol;
import io.netty.buffer.ByteBuf;

import java.util.Collection;
import java.util.Map;

public class ProtocolProvider {
    private static final Map<Integer, IProtocol> protocols;

    static {
        protocols = NetworkUtils.newConcurrentHashMap();
        registerProtocol(new PacketProtocol());
        registerProtocol(new FileProtocol());
    }

    private ProtocolProvider() {
    }

    public static ProtocolBuffer protocolBuffer(ByteBuf byteBuf) {
        return new ProtocolBuffer(byteBuf);
    }

    public static void registerProtocol(IProtocol iProtocol) {
        protocols.put(iProtocol.getId(), iProtocol);
    }

    public static IProtocol getProtocol(int id) {
        return protocols.get(id);
    }

    public static Collection<IProtocol> protocols() {
        return protocols.values();
    }
}
