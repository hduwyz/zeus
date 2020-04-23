package com.zeus.uaa.service;

import com.zeus.uaa.dao.entity.App;

import java.util.List;

public interface AppService {


    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    /**
     * 根据appKey查找AppId
     * @param appKey
     * @return
     */
    public Long findAppIdByAppKey(String appKey);
}
