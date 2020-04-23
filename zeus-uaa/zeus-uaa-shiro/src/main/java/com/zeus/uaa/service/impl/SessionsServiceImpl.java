package com.zeus.uaa.service.impl;

import com.zeus.uaa.model.Sessions;
import com.zeus.uaa.mapper.SessionsMapper;
import com.zeus.uaa.service.ISessionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2020-04-23
 */
@Service
public class SessionsServiceImpl extends ServiceImpl<SessionsMapper, Sessions> implements ISessionsService {

}
