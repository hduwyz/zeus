package com.zeus.uaa.service;

import com.zeus.core.model.PageResult;
import com.zeus.core.model.Result;
import com.zeus.core.service.ISuperService;
import com.zeus.uaa.model.Client;

import java.util.Map;

public interface IClientService extends ISuperService<Client> {
    Result saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);
}
