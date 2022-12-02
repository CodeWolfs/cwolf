package com.wz.cwolf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.dto.ChinaHolidayQueryOutDto;
import com.wz.cwolf.entity.ChinaHoliday;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wz.cwolf.vo.ChinaHolidayConditionInVo;
import com.wz.cwolf.vo.ChinaHolidayDeleteInVo;
import com.wz.cwolf.vo.ChinaHolidayInsertInVo;
import com.wz.cwolf.vo.ChinaHolidayUpdateInVo;

/**
 * <p>
 * 中国法定节假日表 服务类
 * </p>
 *
 * @author wz
 * @since 2022-18-29
 */
public interface ChinaHolidayService extends IService<ChinaHoliday> {

    Page<ChinaHolidayQueryOutDto> queryChinaHolidays(ChinaHolidayConditionInVo chinaHolidayConditionInVo);

    void insertChinaHoliday(ChinaHolidayInsertInVo chinaHolidayInsertInVo);

    void updateChinaHoliday(ChinaHolidayUpdateInVo chinaHolidayUpdateInVo);

    void deleteChinaHolidays(ChinaHolidayDeleteInVo chinaHolidayDeleteInVo);
}
