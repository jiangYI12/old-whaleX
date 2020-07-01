package whale.userCentreApi.entity;
import lombok.Data;
import whale.common.mybatisPlus.baseEntity.TenantEntity;

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
    private String customerName;

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