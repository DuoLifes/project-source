package com.cn.connext.project.demo.callback;

/*回调函数实例*/
public class B {
    /*
	 * 回调函数
	 */
    public void call(CallBack a){
		/*
		 * b help a solve the priblem
		 */
        System.out.println("b help a solve the problem!");
		/*
		 * call back
		 */
        a.slove();

    }
}
