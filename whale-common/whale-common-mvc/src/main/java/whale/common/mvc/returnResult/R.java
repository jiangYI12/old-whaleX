package whale.common.mvc.returnResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import whale.common.mvc.constant.ResultStatus;

/**
 * Description: 控制层统一返回结果
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:48
 */
@Builder
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;


    public static <T> R<T> ok(){
        return restResult(ResultStatus.SUCCESS,"请求成功",null);
    }

    public static <T> R<T> success(T data){
        return restResult(ResultStatus.SUCCESS,"请求成功",data);
    }

    public static <T> R<T> success(String msg,T data){
        return restResult(ResultStatus.SUCCESS,msg,data);
    }

    public static <T> R<T> faile(T data){
        return restResult(ResultStatus.FAILE,"请求失败",data);
    }

    public static <T> R<T> faile(String msg){
        return restResult(ResultStatus.FAILE,msg,null);
    }

    public static <T> R<T> faile(T data,String msg){
        return restResult(ResultStatus.FAILE,msg,data);
    }

    public static  <T> R<T> restResult(Integer code, String msg, T data) {
       R<T> r = new R();
       r.setCode(code);
       r.setData(data);
       r.setMsg(msg);
       return r;
    }
}
