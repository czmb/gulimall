package com.atguigu.gulimall.sms.controller;

import java.util.Arrays;
import java.util.Map;


import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;
import com.atguigu.gulimall.commons.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.sms.entity.WmsWareOrderTaskEntity;
import com.atguigu.gulimall.sms.service.WmsWareOrderTaskService;




/**
 * 库存工作单
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:12:22
 */
@Api(tags = "库存工作单 管理")
@RestController
@RequestMapping("sms/wmswareordertask")
public class WmsWareOrderTaskController {
    @Autowired
    private WmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sms:wmswareordertask:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = wmsWareOrderTaskService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('sms:wmswareordertask:info')")
    public Resp<WmsWareOrderTaskEntity> info(@PathVariable("id") Long id){
		WmsWareOrderTaskEntity wmsWareOrderTask = wmsWareOrderTaskService.getById(id);

        return Resp.ok(wmsWareOrderTask);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:wmswareordertask:save')")
    public Resp<Object> save(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.save(wmsWareOrderTask);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sms:wmswareordertask:update')")
    public Resp<Object> update(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.updateById(wmsWareOrderTask);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sms:wmswareordertask:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		wmsWareOrderTaskService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
