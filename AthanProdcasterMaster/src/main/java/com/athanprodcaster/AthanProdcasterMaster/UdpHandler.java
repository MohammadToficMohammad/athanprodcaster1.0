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

	public String TsAddressPort;

	public UdpHandler(String _TsAddressIp,String _TsAddressPort) {
		TsAddressIp=_TsAddressIp;
		TsAddressPort=_TsAddressPort;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {

		System.out.println("udp pakcet " + msg.content().toString());
		
InetSocketAddress tsaddr = new InetSocketAddress("172.30.0.1", Integer.parseInt("8888"));
		
		ByteBuf buf=Unpooled.copiedBuffer("mosque1asdasdadasdasdadasasdad\r\n".getBytes(StandardCharsets.UTF_8));
		buf.retain();
		DatagramPacket  pck = new DatagramPacket(buf,tsaddr);
		//ctx.write(pck);
			ctx.writeAndFlush(pck).addListener(f-> System.out.println("ok")).awaitUninterruptibly();
	 //pck = new DatagramPacket(buf,msg.sender());
//		ctx.channel().writeAndFlush(pck).await();
	
		System.out.println(tsaddr.getAddress()+" "+tsaddr.getPort());
		System.out.println(buf.readableBytes());
		

	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		ctx.fireChannelRegistered();
		
	}
	

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        
        _ctx = ctx;
		
		
		//buf.writeBytes(StandardCharsets.UTF_8.encode("mosque1"));


		//releaseDirect(buf);

    }


	public static void releaseDirect(ByteBuf buf) 
	{
		while(buf.refCnt()>0)
		buf.release();
	};
	
}
