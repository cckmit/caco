package io.uoko.caco.gateway.config.oauth2;

import com.alibaba.fastjson.JSONObject;
import io.uoko.caco.common.core.domain.enums.ResultCode;
import io.uoko.caco.common.core.result.PlatformResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.apache.http.entity.ContentType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 无权限访问处理器
 * </p>
 *
 * @author uokoer
 * Email uokoer@gmail.com
 * Website https://uoko.io
 * created by 2019/5/24
 */
@Slf4j
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.resetBuffer();
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setContentType(ContentType.APPLICATION_JSON.getMimeType());
        httpServletResponse.setCharacterEncoding(CharEncoding.UTF_8);
        httpServletResponse.getWriter().write(String.valueOf(
                JSONObject.toJSON(
                        JSONObject.toJSON(PlatformResult.failure(
                                ResultCode.PERMISSION_NO_ACCESS))
                )
        ));
        httpServletResponse.flushBuffer();
    }
}
