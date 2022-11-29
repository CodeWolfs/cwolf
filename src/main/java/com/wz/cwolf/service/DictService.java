package com.wz.cwolf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.dto.DictDto;
import com.wz.cwolf.dto.DictInsertInDto;
import com.wz.cwolf.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wz.cwolf.vo.DictConditionVo;
import com.wz.cwolf.vo.DictDeleteVo;
import com.wz.cwolf.vo.DictInsertVo;
import com.wz.cwolf.vo.DictUpdateVo;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
public interface DictService extends IService<Dict> {

    Page<DictDto> queryDict(DictConditionVo dictConditionVo);

    void insertDict(DictInsertInDto dictInsertVo);

    void updateDict(DictUpdateVo dictUpdateVo);

    void deleteDict(DictDeleteVo dictDeleteVo);
}
