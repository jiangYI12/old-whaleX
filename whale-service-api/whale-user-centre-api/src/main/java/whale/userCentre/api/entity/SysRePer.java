package whale.userCentre.api.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_re_per
 * @author 
 */
@Data
public class SysRePer implements Serializable {
    private Long id;

    private Long resourceId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;
}