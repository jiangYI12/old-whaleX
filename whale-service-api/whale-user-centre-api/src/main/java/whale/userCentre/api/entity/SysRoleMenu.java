package whale.userCentre.api.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_role_menu
 * @author 
 */
@Data
public class SysRoleMenu implements Serializable {
    private Long id;

    private Long roleId;

    private Long menuId;

    private static final long serialVersionUID = 1L;
}