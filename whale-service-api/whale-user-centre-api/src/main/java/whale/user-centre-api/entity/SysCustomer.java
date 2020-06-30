package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_customer
 * @author 
 */
@Data
public class SysCustomer   {

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