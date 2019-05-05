package com.weng.framework.sample.consumer.feign;

import com.weng.framework.core.model.ResponseData;
import com.weng.framework.sample.consumer.model.UserReq;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @author wengzhonghui
 * @date 2019/3/23 16:12
 */
@Component
public class UserServiceFallback implements UserServiceFeign{

    @Override
    public ResponseData get(String id) {
        return ResponseData.failed("获取用户信息失败，Id：" + id);
    }

    @Override
    public ResponseData list(Integer pageNo,Integer pageSize) {
        return null;
    }

    @Override
    public ResponseData add(@Valid UserReq userReq) {
        return null;
    }

    @Override
    public ResponseData update(@Valid UserReq userReq) {
        return null;
    }

    @Override
    public ResponseData delete(String ids) {
        return null;
    }


}
