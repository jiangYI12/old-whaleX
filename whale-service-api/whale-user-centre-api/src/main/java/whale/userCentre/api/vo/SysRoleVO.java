package whale.userCentre.api.vo;

import lombok.Data;
import whale.userCentre.api.entity.SysMenu;
import whale.userCentre.api.entity.SysRole;

import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:36
 */
@Data
public class SysRoleVO extends SysRole {
    private List<SysMenu> sysMenus;
}
