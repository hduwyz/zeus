package com.zeus.uaa.controller;

import com.google.common.collect.Maps;
import com.zeus.core.model.PageResult;
import com.zeus.core.model.Result;
import com.zeus.uaa.dto.ClientDto;
import com.zeus.uaa.model.Client;
import com.zeus.uaa.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 应用相关接口
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping("/list")
    public PageResult<Client> list(@RequestParam Map<String, Object> params) {
        return clientService.listClient(params, true);
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @GetMapping("/all")
    public Result<List<Client>> allClient() {
        PageResult<Client> page = clientService.listClient(Maps.newHashMap(), false);
        return Result.succeed(page.getData());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delClient(id);
    }

    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ClientDto clientDto) throws Exception {
        return clientService.saveClient(clientDto);
    }
}
