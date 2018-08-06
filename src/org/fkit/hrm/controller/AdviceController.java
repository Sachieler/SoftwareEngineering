package org.fkit.hrm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.fkit.hrm.domain.Advice;
//import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.common.HrmConstants;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @Description: 处理公告请求控制器
 */

@Controller
public class AdviceController {

	/**
	 * 自动注入UserService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/advice/selectAdvice")
	 public String selectNotice(Model model,Integer pageIndex,
			 @ModelAttribute Advice advice){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		
		/** 查询用户信息     */
		
		List<Advice> advices = hrmService.findAdvice(advice, pageModel);
		model.addAttribute("advices", advices);
		model.addAttribute("pageModel", pageModel);
		//System.out.println("click search-----");
		return "advice/advice";
		
	}
	
	/**
	 * 处理添加请求
	 * @param Integer id  要显示的反馈的id
	 * @param Model model
	 * */
	@RequestMapping(value="/advice/previewAdvice")
	 public String previewAdvice(
			 int id,Model model){
		//System.out.println(date);
		
		Advice advice = hrmService.findAdviceById(id);
		
		model.addAttribute("advice", advice);
		
		// 返回
		return "advice/previewAdvice";
	}
	
	/**
	 * 处理删除反馈请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/advice/removeAdvice")
	 public ModelAndView removeAdvice(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删反馈
			hrmService.removeAdviceById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/advice/selectAdvice");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Advice advice  要添加的公告对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/advice/addAdvice")
	 public ModelAndView addAdvice(
			 String flag,
			 @ModelAttribute Advice advice,
			 ModelAndView mv,
			 HttpSession session){
		System.out.println(flag);
		System.out.println(advice);
		if(flag.equals("1")){
			mv.setViewName("advice/showAddAdvice");
			System.out.println("1------------");
		}else{
		//	User user = (User) session.getAttribute(HrmConstants.USER_SESSION);
		//	notice.setUser(user);
		//	hrmService.addNotice(notice);
			//System.out.println("2------------");
			//System.out.println(notice);
			hrmService.addAdvice(advice);
			mv.setViewName("redirect:/advice/selectAdvice");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Notice advice  要添加的公告对象
	 * @param ModelAndView mv
	 * */
	
	
	@RequestMapping(value="/advice/updateAdvice")
	 public ModelAndView updateAdvice(
			 String flag,
			 @ModelAttribute Advice advice,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Advice target = hrmService.findAdviceById(advice.getId());
			mv.addObject("advice",target);
			mv.setViewName("advice/showUpdateAdvice");
		}else{
			hrmService.modifyAdvice(advice);
			mv.setViewName("redirect:/advice/selectAdvice");
		}
		// 返回
		return mv;
	}
	
	
}
