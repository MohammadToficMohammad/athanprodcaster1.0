package com.athanprodcaster.AthanProdcasterSlave;

import io.netty.channel.ChannelHandlerContext;

public class StateContainer {
	
	public static ChannelHandlerContext ctx;
	public static String mosqueName="Holmia";
	public static String mosqueIp;
	public static String mosquePort;
	public static int flow=0 ; // 0 start to requesting mosque address , 1 waiting for mosque address, 2 we got mosque address
	
}
