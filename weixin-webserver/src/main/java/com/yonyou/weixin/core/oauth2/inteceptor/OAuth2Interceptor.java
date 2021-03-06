package com.yonyou.weixin.core.oauth2.inteceptor;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yonyou.weixin.core.oauth2.annotation.OAuthRequired;

/**
 * 认证拦截器
 * <p/>
 * <p>
 * @author 刘新宇
 *
 * <p>
 * @date 2014年11月28日 下午3:37:58
 * <p>
 * @version 0.0.1
 */
public class OAuth2Interceptor implements HandlerInterceptor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(OAuth2Interceptor.class);

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception)");
		}
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)");
		}
	}

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("preHandle(HttpServletRequest, HttpServletResponse, Object) - 拦截preHandle");
		}
		HttpSession session = request.getSession();
		// 先判断是否有注解
		// 路径拦截问题
		if (handler instanceof HandlerMethod) {

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			OAuthRequired annotation = method
					.getAnnotation(OAuthRequired.class);
			if (annotation != null) {
				if (logger.isInfoEnabled()) {
					logger.info("preHandle(HttpServletRequest, HttpServletResponse, Object) - OAuthRequired：你的访问需要获取登录信息！");
				}
				Object objUid = session
						.getAttribute(APPConstants.CURRENT_LOGIN_STAFF);
				if (objUid == null) {
					String resultUrl = request.getRequestURL().toString();
					String param = request.getQueryString();
					if (param != null) {
						resultUrl += "?" + param;
					}
					System.out.println("resultUrl=" + resultUrl);
					try {
						resultUrl = java.net.URLEncoder.encode(resultUrl,
								"utf-8");
					} catch (UnsupportedEncodingException e) {
						logger.error(
								"preHandle(HttpServletRequest, HttpServletResponse, Object)",
								e);
					}
					// 请求的路径
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath + "/oauth2.do?resultUrl="
							+ resultUrl);
					return false;
				}

			}
		}
		return true;
	}

}