package me.allen.playersimulator.bot;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.server.v1_8_R3.*;

import javax.crypto.SecretKey;
import java.net.SocketAddress;

public class DummyNetworkManager
        extends NetworkManager {
    private IChatBaseComponent ichatbasecomponent;

    public DummyNetworkManager() {
        super(EnumProtocolDirection.SERVERBOUND);
    }

    public void channelActive(ChannelHandlerContext channelhandlercontext)
            throws Exception {
    }

    public void a(EnumProtocol enumprotocol) {
    }

    public void channelInactive(ChannelHandlerContext channelhandlercontext) {
    }

    public void exceptionCaught(ChannelHandlerContext channelhandlercontext, Throwable throwable) {
    }

    protected void a(ChannelHandlerContext channelhandlercontext, Packet packet) {
    }

    public void a(PacketListener packetlistener) {
        super.a(packetlistener);
    }

    public void handle(Packet packet) {
    }

    //private void a(Packet packet, GenericFutureListener<? extends Future<? super Void>>[] agenericfuturelistener) {}

    public void a() {
    }

    public SocketAddress getSocketAddress() {
        return new SocketAddress() {
        };
    }

    public void a(IChatBaseComponent ichatbasecomponent) {
        this.ichatbasecomponent = ichatbasecomponent;
    }

    public boolean c() {
        return false;
    }

    public void a(SecretKey secretkey) {
    }

    public boolean g() // Note: Based on the NMS mapping I think it's supposed to override the check that the bot channel does exist, not sure
    {
        return true;
    }

    public PacketListener getPacketListener() {
        return super.getPacketListener();
    }

    public IChatBaseComponent f() {
        return this.ichatbasecomponent;
    }

    public void k() {
    }

    protected void channelRead0(ChannelHandlerContext channelhandlercontext, Packet object) {
    }
}
