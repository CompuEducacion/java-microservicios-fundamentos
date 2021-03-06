package com.example.zuulapigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLogginFilter extends ZuulFilter {

    private static final Logger logger =
            LoggerFactory.getLogger(ZuulLogginFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        System.out.println("@#@# From Zuul!!!");
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("@#@# From Zuul Gateway: request -> {}  request uri -> {}",
                request,
                request.getRequestURI());
        return null;
    }
}
