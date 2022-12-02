package com.wz.cwolf.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.entity.DictItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.cwolf.vo.DictItemConditionVo;
import com.wz.cwolf.dto.DictItemOutDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典项表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@Mapper
public interface DictItemMapper extends BaseMapper<DictItem> {

    Page<DictItemOutDto> queryDictItems(@Param("page") Page<DictItemOutDto> dictItemPage, @Param("condition") DictItemConditionVo dictItemConditionVo);
}
