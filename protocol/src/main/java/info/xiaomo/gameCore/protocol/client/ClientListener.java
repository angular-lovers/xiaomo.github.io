package info.xiaomo.gameCore.protocol.client;

import io.netty.channel.Channel;

/**
 * Created by 张力 on 2017/6/30.
 */
public interface ClientListener {

    /**
     * 连接成功
     */
    void connected(Channel channel);

}
