package com.atguigu.gulimall.pms.controller;

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

import com.atguigu.gulimall.pms.entity.WmsWareOrderTaskEntity;
import com.atguigu.gulimall.pms.service.WmsWareOrderTaskService;




/**
 * 库存工作单
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:07:35
 */
@Api(tags = "库存工作单 管理")
@RestController
@RequestMapping("pms/wmswareordertask")
public class WmsWareOrderTaskController {
    @Autowired
    private WmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:wmswareordertask:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = wmsWareOrderTaskService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('pms:wmswareordertask:info')")
    public Resp<WmsWareOrderTaskEntity> info(@PathVariable("id") Long id){
		WmsWareOrderTaskEntity wmsWareOrderTask = wmsWareOrderTaskService.getById(id);

        return Resp.ok(wmsWareOrderTask);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:wmswareordertask:save')")
    public Resp<Object> save(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.save(wmsWareOrderTask);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:wmswareordertask:update')")
    public Resp<Object> update(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.updateById(wmsWareOrderTask);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:wmswareordertask:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		wmsWareOrderTaskService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
