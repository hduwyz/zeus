package com.zeus.uaa.dao;

import com.zeus.uaa.dao.entity.Resource;

import java.util.List;

public interface ResourceDao {

    Resource createResource(Resource resource);

    Resource updateResource(Resource resource);

    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);

    List<Resource> findAll();

}
