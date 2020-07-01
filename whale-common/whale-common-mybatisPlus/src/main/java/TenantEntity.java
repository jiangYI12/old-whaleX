import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/6/30 22:32
 */
@Getter
@Setter
public class TenantEntity extends BaseEntity {
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 创建人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createUser;

    /**
     * 更新人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updateUser;
}
