package org.fkit.hrm.controller;


import java.util.List;
import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Employee;
import org.fkit.hrm.domain.Job;
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
 * @Description: 澶勭悊鍛樺伐璇锋眰鎺у埗鍣�
 */
@Controller
public class EmployeeController {
	/**
	 * 鑷姩娉ㄥ叆hrmService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
			
	/**
	 * 澶勭悊鏌ヨ璇锋眰
	 * @param pageIndex 璇锋眰鐨勬槸绗嚑椤�
	 * @param String job_id 鑱屼綅缂栧彿
	 * @param String dept_id 閮ㄩ棬缂栧彿
	 * @param employee 妯＄硦鏌ヨ鍙傛暟
	 * @param Model model
	 * */
	@RequestMapping(value="/employee/selectEmployee")
	 public String selectEmployee(Integer pageIndex,
			 Integer job_id,Integer dept_id,
			 @ModelAttribute Employee employee,
			 Model model){
		// 妯＄硦鏌ヨ鏃跺垽鏂槸鍚︽湁鍏宠仈瀵硅薄浼犻�掞紝濡傛灉鏈夛紝鍒涘缓骞跺皝瑁呭叧鑱斿璞�
		//this.genericAssociation(job_id, dept_id, employee);
		// 鍒涘缓鍒嗛〉瀵硅薄
		PageModel pageModel = new PageModel();
		// 濡傛灉鍙傛暟pageIndex涓嶄负null锛岃缃畃ageIndex锛屽嵆鏄剧ず绗嚑椤�
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		// 鏌ヨ鑱屼綅淇℃伅锛岀敤浜庢ā绯婃煡璇�
	//	List<Job> jobs = hrmService.findAllJob();
		// 鏌ヨ閮ㄩ棬淇℃伅 锛岀敤浜庢ā绯婃煡璇�
	//	List<Dept> depts = hrmService.findAllDept();
		// 鏌ヨ鍛樺伐淇℃伅    
		List<Employee> employees = hrmService.findEmployee(employee,pageModel);
		// 璁剧疆Model鏁版嵁
		model.addAttribute("employees", employees);
//		model.addAttribute("jobs", jobs);
//		model.addAttribute("depts", depts);
		System.out.println("==========================");
		model.addAttribute("pageModel", pageModel);
		// 杩斿洖鍛樺伐椤甸潰
		return "employee/employee";
		
	}
	
	/**
	 * 澶勭悊娣诲姞鍛樺伐璇锋眰
	 * @param String flag 鏍囪锛� 1琛ㄧず璺宠浆鍒版坊鍔犻〉闈紝2琛ㄧず鎵ц娣诲姞鎿嶄綔
	 * @param String job_id 鑱屼綅缂栧彿
	 * @param String dept_id 閮ㄩ棬缂栧彿
	 * @param Employee employee 鎺ユ敹娣诲姞鍙傛暟
	 * @param ModelAndView mv 
	 * */
	@RequestMapping(value="/employee/addEmployee")
	 public ModelAndView addEmployee(
			 String flag,
			 Integer job_id,Integer dept_id,
			 @ModelAttribute Employee employee,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 鏌ヨ鑱屼綅淇℃伅
			List<Job> jobs = hrmService.findAllJob();
			// 鏌ヨ閮ㄩ棬淇℃伅 
			List<Dept> depts = hrmService.findAllDept();
			// 璁剧疆Model鏁版嵁
			mv.addObject("jobs", jobs);
			mv.addObject("depts", depts);
			// 杩斿洖娣诲姞鍛樺伐椤甸潰
			mv.setViewName("employee/showAddEmployee");
		}else{
			// 鍒ゆ柇鏄惁鏈夊叧鑱斿璞′紶閫掞紝濡傛灉鏈夛紝鍒涘缓鍏宠仈瀵硅薄
			//this.genericAssociation(job_id, dept_id, employee);
			// 娣诲姞鎿嶄綔
			System.out.println(employee);
			hrmService.addEmployee(employee);
			// 璁剧疆瀹㈡埛绔烦杞埌鏌ヨ璇锋眰
			mv.setViewName("redirect:/employee/selectEmployee");
			//mv.setViewName("redirect:/main");
		}
		// 杩斿洖
		return mv;
		
	}
	
	/**
	 * 澶勭悊鍒犻櫎鍛樺伐璇锋眰
	 * @param String ids 闇�瑕佸垹闄ょ殑id瀛楃涓�
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/employee/removeEmployee")
	 public ModelAndView removeEmployee(String ids,ModelAndView mv){

		String[] idArray = ids.split(",");
		for(String id : idArray){

			hrmService.removeEmployeeById(Integer.parseInt(id));
		}

		mv.setViewName("redirect:/employee/selectEmployee");

		return mv;
	}
	
	/**
	 * 澶勭悊淇敼鍛樺伐璇锋眰
	 * @param String flag 鏍囪锛�1琛ㄧず璺宠浆鍒颁慨鏀归〉闈紝2琛ㄧず鎵ц淇敼鎿嶄綔
	 * @param String job_id 鑱屼綅缂栧彿
	 * @param String dept_id 閮ㄩ棬缂栧彿
	 * @param Employee employee  瑕佷慨鏀瑰憳宸ョ殑瀵硅薄
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/employee/updateEmployee")
	 public ModelAndView updateEmployee(
			 String flag,
			 Integer job_id,Integer dept_id,
			 @ModelAttribute Employee employee,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 鏍规嵁id鏌ヨ鍛樺伐
			//Employee target = hrmService.findEmployeeById(employee.getId());
			// 闇�瑕佹煡璇㈣亴浣嶄俊鎭� 
			List<Job> jobs = hrmService.findAllJob();
			// 闇�瑕佹煡璇㈤儴闂ㄤ俊鎭� 
			List<Dept> depts = hrmService.findAllDept();
			// 璁剧疆Model鏁版嵁
			mv.addObject("jobs", jobs);
			mv.addObject("depts", depts);
			//mv.addObject("employee", target);
			// 杩斿洖淇敼鍛樺伐椤甸潰
			mv.setViewName("employee/showUpdateEmployee");
		}else{
			// 鍒涘缓骞跺皝瑁呭叧鑱斿璞�
			//this.genericAssociation(job_id, dept_id, employee);
			System.out.println("updateEmployee -->> " + employee);
			// 鎵ц淇敼鎿嶄綔
			hrmService.modifyEmployee(employee);
			// 璁剧疆瀹㈡埛绔烦杞埌鏌ヨ璇锋眰
			mv.setViewName("redirect:/employee/selectEmployee");
		}
		// 杩斿洖
		return mv;
	}
	
	/**
	 * 鐢变簬閮ㄩ棬鍜岃亴浣嶅湪Employee涓槸瀵硅薄鍏宠仈鏄犲皠锛�
	 * 鎵�浠ヤ笉鑳界洿鎺ユ帴鏀跺弬鏁帮紝闇�瑕佸垱寤篔ob瀵硅薄鍜孌ept瀵硅薄
	 * *//*
	private void genericAssociation(Integer job_id,
			Integer dept_id,Employee employee){
		if(job_id != null){
			Job job = new Job();
			job.setId(job_id);
			employee.setJob(job);
		}
		if(dept_id != null){
			Dept dept = new Dept();
			dept.setId(dept_id);
			employee.setDept(dept);
		}
	}*/
	
}
