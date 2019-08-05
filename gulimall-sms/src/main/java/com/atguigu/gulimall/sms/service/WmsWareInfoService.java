package com.atguigu.gulimall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.sms.entity.WmsWareInfoEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 仓库信息
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:12:22
 */
public interface WmsWareInfoService extends IService<WmsWareInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

