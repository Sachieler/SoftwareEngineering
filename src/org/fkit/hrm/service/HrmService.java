package org.fkit.hrm.service;

import java.util.List;

import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Document;
import org.fkit.hrm.domain.Employee;
import org.fkit.hrm.domain.Job;
import org.fkit.hrm.domain.Notice;
import org.fkit.hrm.domain.Advice;
import org.fkit.hrm.domain.Detect;
import org.fkit.hrm.domain.User;

import org.fkit.hrm.util.tag.PageModel;

/**   
 * @Description: 浜轰簨绠＄悊鏈嶅姟灞傛帴鍙�
 */
public interface HrmService {


	/**
	 * 鐢ㄦ埛鐧诲綍
	 * @param  loginname
	 * @param  password
	 * @return User瀵硅薄
	 * */
	User login(String loginname,String password);
	
	/**
	 * 鏍规嵁id鏌ヨ鐢ㄦ埛
	 * @param id
	 * @return 鐢ㄦ埛瀵硅薄
	 * */
	User findUserById(Integer id);
	
	/**
	 * 鑾峰緱鎵�鏈夌敤鎴�
	 * @return User瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<User> findUser(User user,PageModel pageModel);
	
	/**
	 * 鏍规嵁id鍒犻櫎鐢ㄦ埛
	 * @param id
	 * */
	void removeUserById(Integer id);
	
	/**
	 * 淇敼鐢ㄦ埛
	 * @param User 鐢ㄦ埛瀵硅薄
	 * */
	void modifyUser(User user);
	
	/**
	 * 娣诲姞鐢ㄦ埛
	 * @param User 鐢ㄦ埛瀵硅薄
	 * */
	void addUser(User user);
	
	/**
	 * 鑾峰緱鎵�鏈夊憳宸�
	 * @param employee 鏌ヨ鏉′欢
	 * @param pageModel 鍒嗛〉瀵硅薄
	 * @return Dept瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Employee> findEmployee(Employee employee,PageModel pageModel);
	
	/**
	 * 鏍规嵁id鍒犻櫎鍛樺伐
	 * @param id
	 * */
	void removeEmployeeById(Integer id);
	
	/**
	 * 鏍规嵁id鏌ヨ鍛樺伐
	 * @param id
	 * @return 鍛樺伐瀵硅薄
	 * */
	Employee findEmployeeById(Integer id);
	
	/**
	 * 娣诲姞鍛樺伐
	 * @param employee 鍛樺伐瀵硅薄
	 * */
	void addEmployee(Employee employee);
	
	/**
	 * 淇敼鍛樺伐
	 * @param employee 鍛樺伐瀵硅薄
	 * */
	void modifyEmployee(Employee employee);
	
	/**
	 * 鑾峰緱鎵�鏈夐儴闂紝鍒嗛〉鏌ヨ
	 * @return Dept瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Dept> findDept(Dept dept,PageModel pageModel);
	
	/**
	 * 鑾峰緱鎵�鏈夐儴闂�
	 * @return Dept瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Dept> findAllDept();
	
	/**
	 * 鏍规嵁id鍒犻櫎閮ㄩ棬
	 * @param id
	 * */
	public void removeDeptById(Integer id);
	
	/**
	 * 娣诲姞閮ㄩ棬
	 * @param dept 閮ㄩ棬瀵硅薄
	 * */
	void addDept(Dept dept);
	
	/**
	 * 鏍规嵁id鏌ヨ閮ㄩ棬
	 * @param id
	 * @return 閮ㄩ棬瀵硅薄
	 * */
	Dept findDeptById(String id);
	
	/**
	 * 淇敼閮ㄩ棬
	 * @param dept 閮ㄩ棬瀵硅薄
	 * */
	void modifyDept(Dept dept);
	
	/**
	 * 鑾峰緱鎵�鏈夎亴浣�
	 * @return Job瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Job> findAllJob();
	
	List<Job> findJob(Job job,PageModel pageModel);
	
	/**
	 * 鏍规嵁id鍒犻櫎鑱屼綅
	 * @param id
	 * */
	public void removeJobById(Integer id);
	
	/**
	 * 娣诲姞鑱屼綅
	 * @param Job 閮ㄩ棬瀵硅薄
	 * */
	void addJob(Job job);
	
	/**
	 * 鏍规嵁id鏌ヨ鑱屼綅
	 * @param id
	 * @return 鑱屼綅瀵硅薄
	 * */
	Job findJobById(Integer id);
	
	/**
	 * 淇敼鑱屼綅
	 * @param dept 閮ㄩ棬瀵硅薄
	 * */
	void modifyJob(Job job);
	
	
	/**
	 * 鑾峰緱鎵�鏈夊叕鍛�
	 * @return Notice瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Notice> findNotice(Notice notice,PageModel pageModel);
	
	/**
	 * 鏍规嵁id鏌ヨ鍏憡
	 * @param id
	 * @return 鍏憡瀵硅薄
	 * */
	Notice findNoticeById(Integer id);
	
	/**
	 * 鏍规嵁id鍒犻櫎鍏憡
	 * @param id
	 * */
	public void removeNoticeById(Integer id);
	
	/**
	 * 娣诲姞鍏憡
	 * @param Notice 鍏憡瀵硅薄
	 * */
	void addNotice(Notice notice);
	
	/**
	 * 淇敼鍏憡
	 * @param Notice 鍏憡瀵硅薄
	 * */
	void modifyNotice(Notice notice);
	
	/**
	 * 鑾峰緱鎵�鏈夋枃妗�
	 * @return Document瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Document> findDocument(Document document,PageModel pageModel);
	
	/**
	 * 娣诲姞鏂囨。
	 * @param Document 鏂囦欢瀵硅薄
	 * */
	void addDocument(Document document);
	
	/**
	 * 鏍规嵁id鏌ヨ鏂囨。
	 * @param id
	 * @return 鏂囨。瀵硅薄
	 * */
	Document findDocumentById(Integer id);
	
	/**
	 * 鏍规嵁id鍒犻櫎鏂囨。
	 * @param id
	 * */
	public void removeDocumentById(Integer id);
	
	/**
	 * 淇敼鏂囨。
	 * @param Document 鍏憡瀵硅薄
	 * */
	void modifyDocument(Document document);
	

/**
	 * 鑾峰緱鎵�鏈夊叕鍛�
	 * @return Detect瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Detect> findDetect(Detect detect,PageModel pageModel);
	
	/**
	 * 鏍规嵁id鏌ヨ鍏憡
	 * @param id
	 * @return 鍏憡瀵硅薄
	 * */
	Detect findDetectById(Integer id);
	
	/**
	 * 鏍规嵁id鍒犻櫎鍏憡
	 * @param id
	 * */
	public void removeDetectById(Integer id);
	
	/**
	 * 娣诲姞鍏憡
	 * @param Detect 鍏憡瀵硅薄
	 * */
	void addDetect(Detect detect);
	
	/**
	 * 淇敼鍏憡
	 * @param Detect 鍏憡瀵硅薄
	 * */
	void modifyDetect(Detect detect);




	/**
	 * 鑾峰緱鎵�鏈夊弽棣�
	 * @return Advice瀵硅薄鐨凩ist闆嗗悎
	 * */
	List<Advice> findAdvice(Advice advice,PageModel pageModel);
	
	/**
	 * 鏍规嵁id鏌ヨ鍙嶉
	 * @param id
	 * @return 鍙嶉瀵硅薄
	 * */
	Advice findAdviceById(Integer id);
	
	/**
	 * 鏍规嵁id鍒犻櫎鍙嶉
	 * @param id
	 * */
	public void removeAdviceById(Integer id);
	
	/**
	 * 娣诲姞鍙嶉
	 * @param Advice 鍙嶉瀵硅薄
	 * */
	void addAdvice(Advice advice);
	
	/**
	 * 淇敼鍏憡
	 * @param Advice 鍙嶉瀵硅薄
	 * */
	void modifyAdvice(Advice advice);
}