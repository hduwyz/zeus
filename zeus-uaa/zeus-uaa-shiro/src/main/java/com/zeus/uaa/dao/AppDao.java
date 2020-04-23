package com.zeus.uaa.dao;

import com.zeus.uaa.dao.entity.App;

import java.util.List;

public interface AppDao {

    App createApp(App app);

    App updateApp(App app);

    void deleteApp(Long appId);

    App findOne(Long appId);

    List<App> findAll();

    Long findAppIdByAppKey(String appKey);
}
