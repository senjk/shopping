/**
 * @author 程森
 *2017年12月17日下午8:30:38
 */
package shopping.entity;

import java.util.List;

/**
 * @author 程森
 *2017年12月17日下午8:30:38
 */
public class Page {
	private int pageNo;   // 当前页页码(1,2,3....)
	private int pageSize;   // 每页显示条数
	private int totalCount;   // 总记录(条数)
	
	@SuppressWarnings("rawtypes")
	private List data;   // 当前页数据集合
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}
	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	private int totalPage;   // 总页数
	public Page(int pageSize,int totalCount ){
		this.pageSize=pageSize;
		this.totalCount=totalCount;
		if(this.totalCount%this.pageSize==0){
			totalPage=this.totalCount/this.pageSize;
		}else{
			totalPage=this.totalCount/this.pageSize+1;
		}
	}
}
