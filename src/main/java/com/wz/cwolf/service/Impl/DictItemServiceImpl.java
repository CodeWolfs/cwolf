package com.wz.cwolf.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wz.cwolf.common.exception.BizException;
import com.wz.cwolf.common.result.ResultCode;
import com.wz.cwolf.dto.DictItemInsertInDto;
import com.wz.cwolf.entity.DictItem;
import com.wz.cwolf.mapper.DictItemMapper;
import com.wz.cwolf.service.DictItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.cwolf.vo.DictItemConditionVo;
import com.wz.cwolf.vo.DictItemDeleteInVo;
import com.wz.cwolf.dto.DictItemOutDto;
import com.wz.cwolf.vo.DictItemUpdateInVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典项表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-09-29
 */
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public Page<DictItemOutDto> queryDictItems(DictItemConditionVo dictItemConditionVo) {
        Page<DictItemOutDto> dictItemPage = new Page<>(dictItemConditionVo.getPageNum(), dictItemConditionVo.getPageSize());
        dictItemPage = dictItemMapper.queryDictItems(dictItemPage,dictItemConditionVo);
        return dictItemPage;
    }

    @Override
    public void insertDictItem(DictItemInsertInDto dictItemInsertInDto) {
        QueryWrapper<DictItem> dictItemQueryWrapper = new QueryWrapper<>();
        dictItemQueryWrapper.lambda().eq(DictItem::getDictId,dictItemInsertInDto.getDictId());
        dictItemQueryWrapper.lambda().eq(DictItem::getItemValue,dictItemInsertInDto.getItemValue());
        long count = this.count(dictItemQueryWrapper);
        if(count>0) {
            throw new BizException(ResultCode.DICT_ITEM_VALUE_EXIST);
        }
        DictItem dictItem = new DictItem();
        BeanUtils.copyProperties(dictItemInsertInDto,dictItem);
        this.save(dictItem);
    }

    @Override
    public void updateDictItem(DictItemUpdateInVo dictItemUpdateInVo) {
        QueryWrapper<DictItem> dictItemQueryWrapper = new QueryWrapper<>();
        dictItemQueryWrapper.lambda().eq(DictItem::getDictId,dictItemUpdateInVo.getDictId());
        dictItemQueryWrapper.lambda().eq(DictItem::getItemValue,dictItemUpdateInVo.getItemValue());
        dictItemQueryWrapper.lambda().ne(DictItem::getId, dictItemUpdateInVo.getId());
        long count = this.count(dictItemQueryWrapper);
        if(count>0) {
            throw new BizException(ResultCode.DICT_ITEM_VALUE_EXIST);
        }
        DictItem dictItem = new DictItem();
        BeanUtils.copyProperties(dictItemUpdateInVo,dictItem);
        this.updateById(dictItem);
    }

    @Override
    public void deleteDictItem(DictItemDeleteInVo dictItemDeleteInVo) {
        List<DictItem> dictItemList = dictItemDeleteInVo.getIds().stream().map(id -> {
            DictItem dictItem = new DictItem();
            dictItem.setId(id);
            return dictItem;
        }).collect(Collectors.toList());

        this.removeBatchByIds(dictItemList);
    }
}
