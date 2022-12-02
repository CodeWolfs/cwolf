package com.wz.cwolf.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.common.exception.BizException;
import com.wz.cwolf.common.result.ResultCode;
import com.wz.cwolf.dto.ChinaHolidayQueryOutDto;
import com.wz.cwolf.entity.ChinaHoliday;
import com.wz.cwolf.mapper.ChinaHolidayMapper;
import com.wz.cwolf.service.ChinaHolidayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.cwolf.vo.ChinaHolidayConditionInVo;
import com.wz.cwolf.vo.ChinaHolidayDeleteInVo;
import com.wz.cwolf.vo.ChinaHolidayInsertInVo;
import com.wz.cwolf.vo.ChinaHolidayUpdateInVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 中国法定节假日表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-18-29
 */
@Service
public class ChinaHolidayServiceImpl extends ServiceImpl<ChinaHolidayMapper, ChinaHoliday> implements ChinaHolidayService {

    @Resource
    private ChinaHolidayMapper chinaHolidayMapper;

    @Override
    public Page<ChinaHolidayQueryOutDto> queryChinaHolidays(ChinaHolidayConditionInVo chinaHolidayConditionInVo) {
        Page<ChinaHolidayQueryOutDto> chinaHolidayQueryOutDtoPage = new Page<>(chinaHolidayConditionInVo.getPageNum(), chinaHolidayConditionInVo.getPageSize());
        chinaHolidayQueryOutDtoPage = chinaHolidayMapper.queryChinaHolidays(chinaHolidayQueryOutDtoPage,chinaHolidayConditionInVo);
        return chinaHolidayQueryOutDtoPage;
    }

    @Override
    public void insertChinaHoliday(ChinaHolidayInsertInVo chinaHolidayInsertInVo) {
        //判断是否存在日期
        QueryWrapper<ChinaHoliday> chinaHolidayQueryWrapper = new QueryWrapper<>();
        chinaHolidayQueryWrapper.lambda().eq(ChinaHoliday::getHolidayDate,chinaHolidayInsertInVo.getHolidayDate());
        long count = this.count(chinaHolidayQueryWrapper);
        if(count > 0) {
            throw new BizException(ResultCode.CHINA_HOLIDAY_DATE_EXIST);
        }
        ChinaHoliday chinaHoliday = new ChinaHoliday();
        BeanUtils.copyProperties(chinaHolidayInsertInVo, chinaHoliday);
        this.save(chinaHoliday);
    }

    @Override
    public void updateChinaHoliday(ChinaHolidayUpdateInVo chinaHolidayUpdateInVo) {
        //判断是否存在日期
        QueryWrapper<ChinaHoliday> chinaHolidayQueryWrapper = new QueryWrapper<>();
        chinaHolidayQueryWrapper.lambda().eq(ChinaHoliday::getHolidayDate,chinaHolidayUpdateInVo.getHolidayDate());
        chinaHolidayQueryWrapper.lambda().ne(ChinaHoliday::getId, chinaHolidayUpdateInVo.getId());
        long count = this.count(chinaHolidayQueryWrapper);
        if(count > 0) {
            throw new BizException(ResultCode.CHINA_HOLIDAY_DATE_EXIST);
        }
        ChinaHoliday chinaHoliday = new ChinaHoliday();
        BeanUtils.copyProperties(chinaHolidayUpdateInVo, chinaHoliday);
        this.updateById(chinaHoliday);
    }

    @Override
    public void deleteChinaHolidays(ChinaHolidayDeleteInVo chinaHolidayDeleteInVo) {
        chinaHolidayMapper.deleteBatchIds(chinaHolidayDeleteInVo.getIds());
    }
}
