package com.weng.framework.sample.consumer.feign;

import com.weng.framework.core.model.ResponseData;
import com.weng.framework.sample.consumer.common.Contants;
import com.weng.framework.sample.consumer.model.UserReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author wengzhonghui
 * @date 2019/3/23 16:09
 */
@FeignClient(name = Contants.SAMPLE_API_SERVER_NAME, fallback = UserServiceFallback.class, configuration = UserServiceFallback.class)
public interface UserServiceFeign {

    /*
     * 注意：get请求时，需要在参数前增加@RequestParam("id")，且参数名也必须有,例如"id"
     * @param [id]
     * @return
     */
    @GetMapping(value = "/user/get")
    ResponseData get(@RequestParam("id") String id);

    /*
     * 注意：多个参数时，需要在参数前增加@RequestParam("pageNo"),要不然会报too many param的错
     * @param [pageReq]
     * @return
     */
//    @GetMapping(value = "/user/list")
    @RequestMapping(value = "user/list", method=RequestMethod.GET)
    public ResponseData list(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize")Integer pageSize);

    @PostMapping(value = "/user/add")
    public ResponseData add( UserReq userReq);

    @PostMapping(value = "/user/update")
    public ResponseData update(UserReq userReq);

    @PostMapping(value = "/user/delete")
    public ResponseData delete(@RequestParam("ids") String ids);

}
