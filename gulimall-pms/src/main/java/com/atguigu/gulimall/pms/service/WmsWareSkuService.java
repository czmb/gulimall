package com.atguigu.gulimall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.pms.entity.WmsWareSkuEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 商品库存
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:07:35
 */
public interface WmsWareSkuService extends IService<WmsWareSkuEntity> {

    PageVo queryPage(QueryCondition params);
}

