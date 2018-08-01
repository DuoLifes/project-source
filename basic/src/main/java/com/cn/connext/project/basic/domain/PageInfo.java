package com.cn.connext.project.basic.domain;

import java.util.List;

public class PageInfo<T> {
private Integer size=2;
private Integer count;
private Integer total;
private Integer pageIndex;
private List<T>list;
public Integer getSize() {
	return size;
}
public void setSize(Integer size) {
	this.size = size;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public Integer getTotal() {
	return count%size==0?count/size:count/size+1;
}
public void setTotal(Integer total) {
	this.total = total;
}
public Integer getPageIndex() {
	return pageIndex;
}
public void setPageIndex(Integer pageIndex) {
	this.pageIndex = pageIndex;
}
public List<T> getList() {
	return list;
}
public void setList(List<T> list) {
	this.list = list;
}


}
