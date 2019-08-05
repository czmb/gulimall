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

import com.atguigu.gulimall.sms.entity.WmsWareSkuEntity;
import com.atguigu.gulimall.sms.service.WmsWareSkuService;




/**
 * 商品库存
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:12:22
 */
@Api(tags = "商品库存 管理")
@RestController
@RequestMapping("sms/wmswaresku")
public class WmsWareSkuController {
    @Autowired
    private WmsWareSkuService wmsWareSkuService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sms:wmswaresku:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = wmsWareSkuService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('sms:wmswaresku:info')")
    public Resp<WmsWareSkuEntity> info(@PathVariable("id") Long id){
		WmsWareSkuEntity wmsWareSku = wmsWareSkuService.getById(id);

        return Resp.ok(wmsWareSku);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:wmswaresku:save')")
    public Resp<Object> save(@RequestBody WmsWareSkuEntity wmsWareSku){
		wmsWareSkuService.save(wmsWareSku);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sms:wmswaresku:update')")
    public Resp<Object> update(@RequestBody WmsWareSkuEntity wmsWareSku){
		wmsWareSkuService.updateById(wmsWareSku);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sms:wmswaresku:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		wmsWareSkuService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
