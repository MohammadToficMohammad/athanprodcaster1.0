package com.athanprodcaster.AthanProdcasterMaster;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Base64.Encoder;

import javax.sound.sampled.AudioFormat.Encoding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class UdpHandler extends SimpleChannelInboundHandler<DatagramPacket> {

	public static ChannelHandlerContext _ctx;
	
	public String TsAddressIp;

	public int TsAddressPort;

	public UdpHandler(String _TsAddressIp,String _TsAddressPort) {
		TsAddressIp=_TsAddressIp;
		TsAddressPort=Integer.parseInt(_TsAddressPort);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {

		System.out.println("udp pakcet " + msg.content().toString());
		

		

	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		ctx.fireChannelRegistered();
		
	}
	

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        
        _ctx = ctx;
		
        InetSocketAddress tsaddr = new InetSocketAddress(TsAddressIp, TsAddressPort);
        ByteBuf buf=Unpooled.directBuffer();
        buf.writeBytes(("mr "+StateContainer.mosqueName+"\n").getBytes(StandardCharsets.UTF_8));
		//ByteBuf buf=Unpooled.copiedBuffer("mosque1".getBytes(StandardCharsets.UTF_8));
		DatagramPacket  pck = new DatagramPacket(buf,tsaddr);
	    ctx.writeAndFlush(pck).addListener(f-> System.out.println("ok")).await();

	    releaseDirectBuffer(buf);
        
		//buf.writeBytes(StandardCharsets.UTF_8.encode("mosque1"));


		//releaseDirect(buf);

    }


	public static void releaseDirectBuffer(ByteBuf buf) 
	{
		while(buf.refCnt()>0)
		buf.release();
	};
	
}
