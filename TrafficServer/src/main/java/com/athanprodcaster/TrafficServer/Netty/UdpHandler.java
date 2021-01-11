package com.athanprodcaster.TrafficServer.Netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class UdpHandler extends  SimpleChannelInboundHandler<DatagramPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
	
		System.out.println("udp pakcet "+msg.content().toString() );
		
	}
	
	
	
	
	
}
