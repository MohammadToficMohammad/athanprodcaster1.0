package com.athanprodcaster.TrafficServer.Netty;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.timeout.IdleStateHandler;

@Configuration
public class NettyInitStarter {

	
	@Value("${TsAddressLocalIpProp}")
	public String TsAddressLocalIp;
	
	@Value("${TsAddressLocalPortProp}")
	public String TsAddressLocalPort;
	
	@Bean
	void initNetty() 
	{
		 final NioEventLoopGroup group = new NioEventLoopGroup(10);
	     try {
	         final Bootstrap b = new Bootstrap();
	         b.group(group).channel(NioDatagramChannel.class)
	               //  .option(ChannelOption.SO_BROADCAST, true)
	                 .handler(new ChannelInitializer<NioDatagramChannel>() {
	             @Override
	             public void initChannel(final NioDatagramChannel ch) throws Exception {

	                 ChannelPipeline p = ch.pipeline();
	                 p.addLast("idleStateHandler", new IdleStateHandler(0, 0, 30, TimeUnit.SECONDS));
	                 p.addLast(new UdpHandler());
	             }
	         });

	         // Bind and start to accept incoming connections.
	         Integer pPort = Integer.parseInt(TsAddressLocalPort);
	         InetAddress address  = InetAddress.getByName(TsAddressLocalIp);
	         System.out.printf("started at %s %s",String.format(pPort.toString()),String.format( address.toString()));
	         b.bind(address,pPort).sync().channel().closeFuture().await();

	     } catch (UnknownHostException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	     //System.out.print("In Server Finally");
	     }

		
	}
}
