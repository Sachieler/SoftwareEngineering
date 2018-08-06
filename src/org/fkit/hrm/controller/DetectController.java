package org.fkit.hrm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.fkit.hrm.domain.Detect;
import org.fkit.hrm.domain.User;
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
public class DetectController {

	/**
	 * 自动注入UserService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/detect/selectDetect")
	 public String selectDetect(Model model,Integer pageIndex,
			 @ModelAttribute Detect detect){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		
		/** 查询用户信息     */
		
		List<Detect> detects = hrmService.findDetect(detect, pageModel);
		model.addAttribute("detects", detects);
		model.addAttribute("pageModel", pageModel);
		return "detect/detect";
		
	}

	
	/**
	 * 处理删除公告请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/detect/removeDetect")
	 public ModelAndView removeDetect(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除公告
			hrmService.removeDetectById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/detect/selectDetect");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Detect detect  要添加的公告对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/detect/addDetect")
	 public ModelAndView addDetect(
			 String flag,
			 @ModelAttribute Detect detect,
			 ModelAndView mv,
			 HttpSession session){
		System.out.println(flag);
		System.out.println(detect);
		if(flag.equals("1")){
			mv.setViewName("detect/showAddDetect");
			System.out.println("1------------");
		}else{
		//	User user = (User) session.getAttribute(HrmConstants.USER_SESSION);
		//	detect.setUser(user);
		//	hrmService.addDetect(detect);
			//System.out.println("2------------");
			//System.out.println(detect);
			hrmService.addDetect(detect);
			mv.setViewName("redirect:/detect/selectDetect");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Detect detect  要添加的公告对象
	 * @param ModelAndView mv
	 * */
	
	
	@RequestMapping(value="/detect/updateDetect")
	 public ModelAndView updateDetect(
			 String flag,
			 @ModelAttribute Detect detect,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Detect target = hrmService.findDetectById(detect.getId());
			mv.addObject("detect",target);
			mv.setViewName("detect/showUpdateDetect");
		}else{
			hrmService.modifyDetect(detect);
			mv.setViewName("redirect:/detect/selectDetect");
		}
		// 返回
		return mv;
	}
	
	
}
