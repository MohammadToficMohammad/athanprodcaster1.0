package com.athanprodcaster.AthanProdcasterSlave;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.DatagramPacket;

public class SendingThread extends Thread {

	public void run() {
		System.out.println(" SendingThread started");
	
while(true) {
	
		InetSocketAddress tsaddr = new InetSocketAddress(StateContainer.mosqueIp,Integer.parseInt(StateContainer.mosquePort));
		ByteBuf buf = Unpooled.directBuffer();
		buf.writeBytes(("ssm \n").getBytes(StandardCharsets.UTF_8));
		// ByteBuf
		// buf=Unpooled.copiedBuffer("mosque1".getBytes(StandardCharsets.UTF_8));
		DatagramPacket pck = new DatagramPacket(buf, tsaddr);
		
			StateContainer.ctx.writeAndFlush(pck).addListener(f->releaseDirectBuffer(buf));
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}


	}
	public static void releaseDirectBuffer(ByteBuf buf) 
	{
		while(buf.refCnt()>0)
		buf.release();
	};
}
