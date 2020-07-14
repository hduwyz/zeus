package com.zeus.uaa.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeus.uaa.model.Client;
import com.zues.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zlt
 */
@Mapper
public interface ClientMapper extends SuperMapper<Client> {
    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params);
}
