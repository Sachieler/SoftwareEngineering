package org.fkit.hrm.controller;

import java.util.List;

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
 * @Description: 澶勭悊鑱屼綅璇锋眰鎺у埗鍣�
 */

@Controller
public class JobController {

	/**
	 * 鑷姩娉ㄥ叆UserService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	/**
	 * 澶勭悊/login璇锋眰
	 * */
	@RequestMapping(value="/job/selectJob")
	 public String selectJob(Model model,Integer pageIndex,
			 @ModelAttribute Job job){
		System.out.println("selectJob -->> " + job);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 鏌ヨ鐢ㄦ埛淇℃伅     */
		List<Job> jobs = hrmService.findJob(job, pageModel);
		model.addAttribute("jobs", jobs);
		model.addAttribute("pageModel", pageModel);
		return "job/job";
		
	}
	
	/**
	 * 澶勭悊鍒犻櫎鑱屼綅璇锋眰
	 * @param String ids 闇�瑕佸垹闄ょ殑id瀛楃涓�
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/job/removeJob")
	 public ModelAndView removeJob(String ids,ModelAndView mv){
		// 鍒嗚Вid瀛楃涓�
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 鏍规嵁id鍒犻櫎鑱屼綅
			hrmService.removeJobById(Integer.parseInt(id));
		}
		// 璁剧疆瀹㈡埛绔烦杞埌鏌ヨ璇锋眰
		mv.setViewName("redirect:/job/selectJob");
		// 杩斿洖ModelAndView
		return mv;
	}
	
	/**
	 * 澶勭悊娣诲姞璇锋眰
	 * @param String flag 鏍囪锛� 1琛ㄧず璺宠浆鍒版坊鍔犻〉闈紝2琛ㄧず鎵ц娣诲姞鎿嶄綔
	 * @param Job  job  瑕佹坊鍔犵殑鑱屼綅瀵硅薄
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/job/addJob")
	 public ModelAndView addJob(
			 String flag,
			 @ModelAttribute Job job,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 璁剧疆璺宠浆鍒版坊鍔犻〉闈�
			mv.setViewName("job/showAddJob");
		}else{
			// 鎵ц娣诲姞鎿嶄綔
			System.out.println("======================");
			System.out.println(job);
			hrmService.addJob(job);
			System.out.println("=========poksj=============");
			// 璁剧疆瀹㈡埛绔烦杞埌鏌ヨ璇锋眰
			mv.setViewName("redirect:/job/selectJob");
		}
		// 杩斿洖
		return mv;
	}
	
	
	/**
	 * 澶勭悊淇敼鑱屼綅璇锋眰
	 * @param String flag 鏍囪锛� 1琛ㄧず璺宠浆鍒颁慨鏀归〉闈紝2琛ㄧず鎵ц淇敼鎿嶄綔
	 * @param Job job 瑕佷慨鏀归儴闂ㄧ殑瀵硅薄
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/job/updateJob")
	 public ModelAndView updateJob(
			 String flag,
			 @ModelAttribute Job job,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 鏍规嵁id鏌ヨ閮ㄩ棬
			Job target = hrmService.findJobById(job.getId());
			// 璁剧疆Model鏁版嵁
			mv.addObject("job", target);
			// 璁剧疆璺宠浆鍒颁慨鏀归〉闈�
			mv.setViewName("job/showUpdateJob");
		}else{
			// 鎵ц淇敼鎿嶄綔
			hrmService.modifyJob(job);
			// 璁剧疆瀹㈡埛绔烦杞埌鏌ヨ璇锋眰
			mv.setViewName("redirect:/job/selectJob");
		}
		// 杩斿洖
		return mv;
	}
}
