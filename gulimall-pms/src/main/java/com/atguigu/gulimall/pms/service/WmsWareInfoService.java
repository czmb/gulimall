package com.atguigu.gulimall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.pms.entity.WmsWareInfoEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 仓库信息
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:07:35
 */
public interface WmsWareInfoService extends IService<WmsWareInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

