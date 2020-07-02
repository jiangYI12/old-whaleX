package whale.userCentre.api.fegin;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import whale.common.core.constant.SysServiceConstant;
import whale.common.fegin.constant.FeginClientURL;
import whale.userCentre.api.vo.SysCustomerVO;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:27
 */
@FeignClient(value = SysServiceConstant.USER_CENTRE_SERVICE)
public interface ISysCustomerFegin {

    String PREFIX =  FeginClientURL.PREFIX + "/SysCustomerFegin";

    String GET_SYSCUSTOMER_BY_ACCOUNT = PREFIX + "/getSysCustomerByAccount";

    @GetMapping(value =  GET_SYSCUSTOMER_BY_ACCOUNT)
    R<SysCustomerVO> getSysCustomerByAccount(String account);

}
