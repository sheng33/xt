package interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class LoginInterptor implements HandlerInterceptor {
    private List<String> allowedPass;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        String url = request.getRequestURL().toString();

      //  url = url+".jsp";
        System.out.println("url:"+url);
        Object user = request.getSession().getAttribute("user");
        if(user!=null){
            return true;
        }
        for (String temp:allowedPass){

            if(url.endsWith(temp)){
                System.out.println("bbb");
                return true;
            }
            System.out.println("ccc:"+temp);

            System.out.println(url.endsWith(temp));
        }
        System.out.println("allow:"+allowedPass);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println ("<script language=javascript>alert('当前未登陆，请先登录');window.location='index.jsp'</script>");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView model) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handle, Exception e) throws Exception {

    }

    public void setAllowedPass(List<String> allowedPass) {
        this.allowedPass = allowedPass;
    }
}
