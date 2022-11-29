package com.wz.cwolf.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.common.exception.BizException;
import com.wz.cwolf.common.result.ResultCode;
import com.wz.cwolf.dto.DictDto;
import com.wz.cwolf.dto.DictInsertInDto;
import com.wz.cwolf.entity.Dict;
import com.wz.cwolf.mapper.DictMapper;
import com.wz.cwolf.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.cwolf.vo.DictConditionVo;
import com.wz.cwolf.vo.DictDeleteVo;
import com.wz.cwolf.vo.DictInsertVo;
import com.wz.cwolf.vo.DictUpdateVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public Page<DictDto> queryDict(DictConditionVo dictConditionVo) {
        Page<DictDto> dictPage = new Page<>(dictConditionVo.getPageNum(),dictConditionVo.getPageSize());
        dictPage = dictMapper.queryDict(dictPage, dictConditionVo);
        return dictPage;
    }

    @Override
    public void insertDict(DictInsertInDto dictInsertInDto) {
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.lambda().eq(Dict::getDictCode,dictInsertInDto.getDictCode());
        long count = this.count(dictQueryWrapper);
        if(count > 0) {
            throw new BizException(ResultCode.DICT_EXIST);
        }
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictInsertInDto,dict);
        this.save(dict);
    }

    @Override
    public void updateDict(DictUpdateVo dictUpdateVo) {
        if(StringUtils.isNotBlank(dictUpdateVo.getDictCode())) {
            QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
            dictQueryWrapper.lambda().eq(Dict::getDictCode,dictUpdateVo.getDictCode());
            dictQueryWrapper.lambda().ne(Dict::getId,dictUpdateVo.getId());
            long count = this.count(dictQueryWrapper);
            if(count > 0) {
                throw new BizException(ResultCode.DICT_EXIST);
            }
        }
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictUpdateVo,dict);
        this.updateById(dict);
    }

    @Override
    public void deleteDict(DictDeleteVo dictDeleteVo) {
        List<Dict> dictList = dictDeleteVo.getIds().stream().map(id -> {
            Dict dict = new Dict();
            dict.setId(id);
            return dict;
        }).collect(Collectors.toList());
        this.removeBatchByIds(dictList);
    }
}
