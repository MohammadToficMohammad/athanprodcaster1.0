package com.athanprodcaster.TrafficServer.Netty;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.bouncycastle.util.Arrays;

import com.athanprodcaster.TrafficServer.TsCache;
import com.athanprodcaster.TrafficServer.TsMosque;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class UdpHandler extends SimpleChannelInboundHandler<DatagramPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {

		System.out.println("udp pakcet ----------------------------------");
		ByteBuf buf = msg.content();
		byte[] bufbytes = new byte[buf.readableBytes()];
		buf.readBytes(bufbytes);
		// releaseDirectBuffer(buf);
		String header = getMcpHeader(bufbytes);
		String cmd = header.split(" ")[0];
		String[] args = header.split(" ");
		switch (cmd) {
		case "mr":
			TsMosque tsMosque = new TsMosque();
			tsMosque.name = args[1];
			tsMosque.ip = msg.sender().getAddress().getHostAddress();
			tsMosque.port = Integer.toString(msg.sender().getPort());
			System.out.println("TsMosque added: " + tsMosque.toString());
			TsCache.mosques.add(tsMosque);
			TsCache.mosquesMap.put(tsMosque.name, tsMosque);
			break;
		case "rma":
			ByteBuf bufT = Unpooled.directBuffer();
			TsMosque tms=TsCache.mosquesMap.get(args[1]);
			bufT.writeBytes(("rmar "+tms.ip+" "+tms.port+"\n").getBytes(StandardCharsets.UTF_8));
			DatagramPacket pckT = new DatagramPacket(bufT, msg.sender());
			ctx.writeAndFlush(pckT).addListener(f-> releaseDirectBuffer(bufT)); //no need for this for the main msg.contain buffer  in simplechannel
			//ctx.writeAndFlush(pckT);
			

			break;

		default:
			// code block
		}

	}

	public String getMcpHeader(byte[] bufbytes) {
		byte[] bufHeaderBytes;
		if (bufbytes.length < 258) {
			bufHeaderBytes = bufbytes;
		} else {
			bufHeaderBytes = Arrays.copyOfRange(bufbytes, 0, 258);
		}

		String out;
		try {
			out = new String(bufHeaderBytes, "UTF-8");
			return out.split("\n")[0];
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	};

	public static void releaseDirectBuffer(ByteBuf buf) {
		while (buf.refCnt() > 0)
			buf.release();
	};

}
