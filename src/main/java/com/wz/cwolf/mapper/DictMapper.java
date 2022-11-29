package com.wz.cwolf.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.dto.DictDto;
import com.wz.cwolf.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.cwolf.vo.DictConditionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

    Page<DictDto> queryDict(@Param("page") Page<DictDto> page, @Param("condition") DictConditionVo dictConditionVo);
}
