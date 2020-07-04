
package whale.common.security.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import whale.common.security.config.WhaleXIgnorPermissionsUrls;

import javax.servlet.http.HttpServletRequest;

/**
 * 改造 {@link BearerTokenExtractor} 对公开权限的请求不进行校验,对inner注解的路径不需要在验证token
 */
@Component
@RequiredArgsConstructor
public class WhaleXBearerTokenExtractor extends BearerTokenExtractor {

	private final PathMatcher pathMatcher = new AntPathMatcher();

	private final WhaleXIgnorPermissionsUrls urlProperties;

	@Override
	public Authentication extract(HttpServletRequest request) {
		boolean match = urlProperties.getIgnoreUrls().stream()
				.anyMatch(url -> pathMatcher.match(url, request.getRequestURI()));

		return match ? null : super.extract(request);
	}

}
