package whale.common.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/1 21:28
 */
@Getter
@Setter
public class WhaleUsers extends User {

    private Long id;

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

    
    public WhaleUsers(String account,String avatar,Long id,String phone,String username,String password, Collection<? extends GrantedAuthority> authorities) {
        super(account, password, authorities);
        this.id = id;
        this.avatar = avatar;
        this.phone = phone;
        this.username = username;
    }

}
