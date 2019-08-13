package com.ln.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/8/12 11:10
 */
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);
//    filterType:返回过滤器的类型。有pre、route、post、error等几种取值
//    PRE:这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在集群
//    中选择请求的微服务、记录调试信息等。

//    ROUTING:这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的
//    请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。

//    POST:这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的
//    HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。

//    ERROR:在其他阶段发生错误时执行该过滤器。

    @Override
    public String filterType() {
        return "pre";
    }

    //filter0rder:返回-一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
    @Override
    public int filterOrder() {
        return 1;
    }

    //shouldFilter:返回-一个boolean值来判断该过滤器是否要执行，true 表示执行，false表示不执行。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //run:过滤器的具体逻辑。本例中让它打印了请求的HTTP方法以及请求的地址。
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
