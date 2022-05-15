package com.equipment.sys.service.impl;

import com.equipment.sys.entity.Loginfo;
import com.equipment.sys.mapper.LoginfoMapper;
import com.equipment.sys.service.ILoginfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author test
 * @since 2022-03-23
 */
@Service
@Transactional
public class LoginfoServiceImpl extends ServiceImpl<LoginfoMapper, Loginfo> implements ILoginfoService {

}
