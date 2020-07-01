package whale.userCentre.api.entity;
import lombok.Data;
import whale.common.mybatisPlus.baseEntity.TenantEntity;

import java.util.List;

/**
 * sys_customer
 * @author 
 */
@Data
public class SysCustomer extends TenantEntity {

    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    private static final long serialVersionUID = 1L;
}