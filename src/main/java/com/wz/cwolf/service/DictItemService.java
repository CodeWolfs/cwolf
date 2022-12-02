package com.wz.cwolf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.dto.DictItemInsertInDto;
import com.wz.cwolf.entity.DictItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wz.cwolf.vo.DictItemConditionVo;
import com.wz.cwolf.vo.DictItemDeleteInVo;
import com.wz.cwolf.dto.DictItemOutDto;
import com.wz.cwolf.vo.DictItemUpdateInVo;

/**
 * <p>
 * 字典项表 服务类
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
public interface DictItemService extends IService<DictItem> {

    Page<DictItemOutDto> queryDictItems(DictItemConditionVo dictItemConditionVo);

    void insertDictItem(DictItemInsertInDto dictItemInsertInDto);

    void updateDictItem(DictItemUpdateInVo dictItemUpdateInVo);

    void deleteDictItem(DictItemDeleteInVo dictItemDeleteInVo);
}
