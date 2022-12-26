package cn.qing.server.spi.balance;

import cn.qing.common.constants.LoadBalanceConstants;
import cn.qing.common.dto.ServiceInstance;
import cn.qing.server.annotation.LoadBalanceType;
import cn.qing.server.spi.LoadBalance;

import java.util.List;

/**
 * 轮询算法
 *
 * @author conghuhu
 */
@LoadBalanceType(LoadBalanceConstants.LOAD_BALANCE_ROUND_ROBIN)
public class RoundRobinBalance implements LoadBalance {

    private volatile int index;

    @Override
    public synchronized ServiceInstance chooseOne(List<ServiceInstance> instances) {
        if (index == instances.size()) {
            index = 0;
        }
        return instances.get(index++);
    }
}
