package com.netty.test;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class ServerTest {

	public static void main(String[] args) {
		ServerBootstrap bootsrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), 
						Executors.newCachedThreadPool()));
		bootsrap.setPipelineFactory(new ChannelPipelineFactory(){

			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipeline=Channels.pipeline();
				pipeline.addLast("1", new UpStreamHandlera());
				pipeline.addLast("2", new UpStreamHandlerb());
				pipeline.addLast("3", new DownStreamHandlera());
				pipeline.addLast("4", new DownStreamHandlerb());
				pipeline.addLast("5", new UpStreamHandlerX());
				return pipeline;
			}
			
		});
		bootsrap.bind(new InetSocketAddress(8888));
		
	}
}
