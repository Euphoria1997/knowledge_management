//package com.example.knowledge_managing.interceptor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponseWrapper;
//@Component
//@Slf4j
//public class PathRewriterInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpServletResponseWrapper httpResponse = new HttpServletResponseWrapper((HttpServletResponse) response);
//        String path=request.getRequestURI();
//        log.warn("拦截器就位");
////        if(path.contains("/IMG")){
////            path = path.replaceAll("/IMG","src/main/resources/static/img");
////            log.debug("请求路径已经修改为{}",path);
////            request.getRequestDispatcher(path).forward(request,response);
////        }
//
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.debug("拦截器发挥作用{}",request.getRequestURI());
//    }
//}
