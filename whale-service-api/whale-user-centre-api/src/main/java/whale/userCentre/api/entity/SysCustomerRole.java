package whale.userCentre.api.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_customer_role
 * @author 
 */
@Data
public class SysCustomerRole implements Serializable {
    private Long id;

    private Long customerId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}