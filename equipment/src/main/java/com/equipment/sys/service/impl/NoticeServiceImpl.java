package com.equipment.sys.service.impl;

import com.equipment.sys.entity.Notice;
import com.equipment.sys.mapper.NoticeMapper;
import com.equipment.sys.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author test
 * @since 2022-03-25
 */
@Service
@Transactional
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
