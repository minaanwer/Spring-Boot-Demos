package test.zlogger.com.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import test.zlogger.com.demo.Log.myLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {


   private myLogger mylogger;


    MyInterceptor(myLogger par){
     this.mylogger = par;
    }


    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        mylogger.Log("I'm in Interceptor :  afterCompletion");
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
        mylogger.Log("I'm  in Interceptor : postHandle");
    }
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        mylogger.Log("I'm in  Interceptor : preHandle");
        return true;
    }
}