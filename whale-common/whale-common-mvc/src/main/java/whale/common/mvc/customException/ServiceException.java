package whale.common.mvc.customException;

import lombok.Data;

/**
 * Description: 自定义业务异常
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:44
 */
public class ServiceException extends Exception {
    public ServiceException() {
    }


    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(String message) {
        super(message);
    }
}
