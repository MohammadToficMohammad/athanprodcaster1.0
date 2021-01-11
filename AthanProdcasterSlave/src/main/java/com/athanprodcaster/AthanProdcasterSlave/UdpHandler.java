package com.athanprodcaster.AthanProdcasterSlave;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class UdpHandler extends  SimpleChannelInboundHandler<DatagramPacket> {

	
	public String TsAddressIp;

	public String TsAddressPort;

	public UdpHandler(String _TsAddressIp,String _TsAddressPort) {
		TsAddressIp=_TsAddressIp;
		TsAddressPort=_TsAddressPort;
	}
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
	
		System.out.println("udp pakcet "+msg.content().toString() );
		
	}
	
	
	
	
	
}
