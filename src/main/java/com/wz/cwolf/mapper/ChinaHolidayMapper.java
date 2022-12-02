package com.wz.cwolf.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.dto.ChinaHolidayQueryOutDto;
import com.wz.cwolf.entity.ChinaHoliday;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.cwolf.vo.ChinaHolidayConditionInVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 中国法定节假日表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-18-29
 */
@Mapper
public interface ChinaHolidayMapper extends BaseMapper<ChinaHoliday> {

    Page<ChinaHolidayQueryOutDto> queryChinaHolidays(@Param("page") Page<ChinaHolidayQueryOutDto> chinaHolidayQueryOutDtoPage, @Param("condition") ChinaHolidayConditionInVo chinaHolidayConditionInVo);
}
