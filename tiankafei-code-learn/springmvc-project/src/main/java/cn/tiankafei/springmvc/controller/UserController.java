package cn.tiankafei.springmvc.controller;

import cn.tiankafei.springmvc.entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * SpringMVC也可以在参数上使用原生的Servlet API
     *
     *  HttpSession
     *  HttpServletRequest
     *  HttpServletResponse
     *
     *  java.security.Principal 安全协议相关
     *  Locale：国际化相关的区域信息对象
     *  InputStream:
     *      ServletInputStream inputStream = request.getInputStream();
     *  OutputStream:
     *      ServletOutputStream outputStream = response.getOutputStream();
     *  Reader:
     *      BufferedReader reader = request.getReader();
     *  Writer:
     *      PrintWriter writer = response.getWriter();
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("api")
    public String api(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("requestParam","request");
        session.setAttribute("sessionParam","session");
        return "success";
    }

    @RequestMapping("/converter")
    public String converter(User user, Model model){
        System.out.println(user);
        model.addAttribute("user","user");
        return "success";
    }

    @RequestMapping("dateConvertion")
    public String dateConvertion(@Valid User user, BindingResult bindingResult, Model model){
        System.out.println(user);
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors != null && !fieldErrors.isEmpty()){
            Map<String, Object> errorMap = new HashMap<>();
            for (int index = 0, length = fieldErrors.size(); index < length; index++) {
                FieldError fieldError = fieldErrors.get(index);
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                errorMap.put(field, defaultMessage);
            }
            model.addAttribute("errors", errorMap);
            return "forward:/index.jsp";
        }

        return "hello";
    }

}