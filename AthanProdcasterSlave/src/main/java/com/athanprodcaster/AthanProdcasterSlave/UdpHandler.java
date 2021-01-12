package com.athanprodcaster.AthanProdcasterSlave;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class UdpHandler extends  SimpleChannelInboundHandler<DatagramPacket> {

	
	public String TsAddressIp;

	public int TsAddressPort;

	public UdpHandler(String _TsAddressIp,String _TsAddressPort) {
		TsAddressIp=_TsAddressIp;
		TsAddressPort=Integer.parseInt(_TsAddressPort);
	}
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
	
		System.out.println("udp pakcet ----------------------------------");
		ByteBuf buf= msg.content();
		byte[] bufbytes=new byte[buf.readableBytes()];
		buf.readBytes(bufbytes);
		//releaseDirectBuffer(buf);
		String header =getMcpHeader(bufbytes);
		String cmd=header.split(" ")[0];
		String[] args=header.split(" ");
		switch(cmd) {
		  case "rmar":
			StateContainer.mosqueIp=args[1];
			StateContainer.mosquePort=args[2];
			StateContainer.flow=2;
			SendingThread st=new SendingThread();
			st.start();
		    System.out.println("mosque address is received "+StateContainer.mosqueIp+" port:"+StateContainer.mosquePort);

		    break;
		  
		  default:
		    // code block
		}
		
	}
	
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		StateContainer.ctx=ctx;
		ctx.fireChannelRegistered();
		
	}
	

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        
        StateContainer.flow=0;
		
        InetSocketAddress tsaddr = new InetSocketAddress(TsAddressIp, TsAddressPort);
        ByteBuf buf=Unpooled.directBuffer();
        buf.writeBytes(("rma "+StateContainer.mosqueName+"\n").getBytes(StandardCharsets.UTF_8));
		//ByteBuf buf=Unpooled.copiedBuffer("mosque1".getBytes(StandardCharsets.UTF_8));
		DatagramPacket  pck = new DatagramPacket(buf,tsaddr);
	    ctx.writeAndFlush(pck).addListener(f-> StateContainer.flow=1).await();

	    releaseDirectBuffer(buf);
        
		//buf.writeBytes(StandardCharsets.UTF_8.encode("mosque1"));


		//releaseDirect(buf);

    }


    public String getMcpHeader(byte[]  bufbytes) 
	{
		byte[] bufHeaderBytes;
		if(bufbytes.length<258) 
		{
			bufHeaderBytes=bufbytes;
		}else 
		{
			bufHeaderBytes=Arrays.copyOfRange(bufbytes, 0, 258);
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
	
	public static void releaseDirectBuffer(ByteBuf buf) 
	{
		while(buf.refCnt()>0)
		buf.release();
	};
	
	
	
	
}
