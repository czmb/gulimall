package com.atguigu.gulimall.ums.controller;

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

import com.atguigu.gulimall.ums.entity.WmsFeightTemplateEntity;
import com.atguigu.gulimall.ums.service.WmsFeightTemplateService;




/**
 * 运费模板
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:17:16
 */
@Api(tags = "运费模板 管理")
@RestController
@RequestMapping("ums/wmsfeighttemplate")
public class WmsFeightTemplateController {
    @Autowired
    private WmsFeightTemplateService wmsFeightTemplateService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ums:wmsfeighttemplate:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = wmsFeightTemplateService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('ums:wmsfeighttemplate:info')")
    public Resp<WmsFeightTemplateEntity> info(@PathVariable("id") Long id){
		WmsFeightTemplateEntity wmsFeightTemplate = wmsFeightTemplateService.getById(id);

        return Resp.ok(wmsFeightTemplate);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ums:wmsfeighttemplate:save')")
    public Resp<Object> save(@RequestBody WmsFeightTemplateEntity wmsFeightTemplate){
		wmsFeightTemplateService.save(wmsFeightTemplate);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ums:wmsfeighttemplate:update')")
    public Resp<Object> update(@RequestBody WmsFeightTemplateEntity wmsFeightTemplate){
		wmsFeightTemplateService.updateById(wmsFeightTemplate);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ums:wmsfeighttemplate:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		wmsFeightTemplateService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
