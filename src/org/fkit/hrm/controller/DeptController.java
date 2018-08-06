package org.fkit.hrm.controller;

import java.util.List;

import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @Description: 处理部门请求控制器
 */

@Controller
public class DeptController {

	/**
	 * 自动注入UserService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/dept/selectDept")
	 public String selectDept(Model model,Integer pageIndex,
			 @ModelAttribute Dept dept){
		System.out.println("selectDept -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("dept = " + dept);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		
		List<Dept> depts = hrmService.findDept(dept, pageModel);
		model.addAttribute("depts", depts);
		model.addAttribute("pageModel", pageModel);
		return "dept/dept";
		
	}
	
	/**
	 * 处理删除部门请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/dept/removeDept")
	 public ModelAndView removeDept(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除部门
			System.out.println("======测试删除================");
			System.out.println(id);
			hrmService.removeDeptById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/dept/selectDept");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Dept  dept  要添加的部门对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/dept/addDept")
	 public ModelAndView addDept(
			 String flag,
			 @ModelAttribute Dept dept,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("dept/showAddDept");
		}else{
			// 执行添加操作
			System.out.println(dept);
			hrmService.addDept(dept);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理修改部门请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Dept dept 要修改部门的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/dept/updateDept")
	 public ModelAndView updateDpet(
			 String flag,
			 @ModelAttribute Dept dept,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询部门
			System.out.println(dept);
			Dept target = hrmService.findDeptById(dept.getP_id());
			// 设置Model数据
			System.out.println(target);
			System.out.println("=============================");
			mv.addObject("dept", target);
			// 设置跳转到修改页面
			mv.setViewName("dept/showUpdateDept");
		}else{
			System.out.println("执行这条语句吗");
			// 执行修改操作
			hrmService.modifyDept(dept);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}
	
}
