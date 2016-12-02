package com.le.web.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * ClassName: InterfaceUrlIntiServlet
 * @Description: 项目启动初始化 servlet
 * @author dapengniao
 * @date 
 */
public class InterfaceUrlIntiServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        InterfaceUrlInti.init();
    }
}
