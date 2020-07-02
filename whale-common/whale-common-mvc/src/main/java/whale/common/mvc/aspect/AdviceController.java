package whale.common.mvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import whale.common.mvc.customException.ServiceException;
import whale.common.mvc.returnResult.R;

/**
 * Description: 全局异常拦截器
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:41
 */
@Slf4j
@RestControllerAdvice
public class AdviceController {

    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R errorHandler(ServiceException ex) {
        log.error("全局异常信息 {}", ex.getMessage());
        return R.faile(ex.getMessage());
    }

}
