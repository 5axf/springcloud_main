package com.meiheng.springcloud_zuul_10000.zuulfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * zuul的请求过滤器
 * @author axf
 * @version 1.0
 * @date 2019/7/11 17:04
 */
public class MyZuulFilter extends ZuulFilter {

    /**
     * 什么类型的过滤
     *
     * pre 路由前
     *
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //假如请求头中必须带有token这个参数
        //获得请求
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if("".equals(token) || token == null){
            //表示自己使用response响应，zuul不要占用
            context.setSendZuulResponse(false);
            HttpServletResponse response = context.getResponse();
            //设置编码格式
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().println("没有携带token令牌，不能通过");
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return null 表示通过
        return null;
    }
}
