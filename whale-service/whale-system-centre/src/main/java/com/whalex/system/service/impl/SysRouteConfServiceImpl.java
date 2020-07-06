package com.whalex.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whalex.system.api.entity.SysRouteConf;
import com.whalex.system.mpper.SysRouteConfMapper;
import com.whalex.system.service.ISysRouteConfService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description: 系统路由查询service
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/6 21:00
 */
@Service
@AllArgsConstructor
public class SysRouteConfServiceImpl extends ServiceImpl<SysRouteConfMapper, SysRouteConf> implements ISysRouteConfService {

}
