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

import com.atguigu.gulimall.pms.entity.WmsWareOrderTaskDetailEntity;
import com.atguigu.gulimall.pms.service.WmsWareOrderTaskDetailService;




/**
 * 库存工作单
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:07:35
 */
@Api(tags = "库存工作单 管理")
@RestController
@RequestMapping("pms/wmswareordertaskdetail")
public class WmsWareOrderTaskDetailController {
    @Autowired
    private WmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:wmswareordertaskdetail:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = wmsWareOrderTaskDetailService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('pms:wmswareordertaskdetail:info')")
    public Resp<WmsWareOrderTaskDetailEntity> info(@PathVariable("id") Long id){
		WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail = wmsWareOrderTaskDetailService.getById(id);

        return Resp.ok(wmsWareOrderTaskDetail);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:wmswareordertaskdetail:save')")
    public Resp<Object> save(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail){
		wmsWareOrderTaskDetailService.save(wmsWareOrderTaskDetail);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:wmswareordertaskdetail:update')")
    public Resp<Object> update(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail){
		wmsWareOrderTaskDetailService.updateById(wmsWareOrderTaskDetail);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:wmswareordertaskdetail:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		wmsWareOrderTaskDetailService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
