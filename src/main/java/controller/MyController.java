package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.HelloWorld;

@Controller
public class MyController {
	@RequestMapping("/")
	public String index(Model M)
	{
		M.addAttribute("msg", "Welcome!");
		return "ioc";
	}
	
	@RequestMapping("/helloworld")
	public String helloWorld(Model M)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld obj = context.getBean("helloworld", HelloWorld.class);
		
		M.addAttribute("msg", obj.getMessage());
		
		return "ioc";
	}
}
