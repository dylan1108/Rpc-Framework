package com.netty.test;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.SimpleChannelDownstreamHandler;

public class DownStreamHandlerb  extends SimpleChannelDownstreamHandler {
	/**
	 * //TODO 添加override说明
	 * @see org.jboss.netty.channel.SimpleChannelDownstreamHandler#handleDownstream(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelEvent)
	 **/
	@Override
	public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e)
			throws Exception {
		System.out.println("downstreamhandlerb.handledownstream");
		super.handleDownstream(ctx, e);
	}
}
