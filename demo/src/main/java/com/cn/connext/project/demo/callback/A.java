package com.cn.connext.project.demo.callback;

/*回调函数实例*/
public class A implements CallBack {
    B b = new B();
    @Override
    	/*
    	 * (non-Javadoc)
    	 * @see CallBack#slove()
    	 * 响应回调函数
    	 */
    public void slove() {
        System.out.println("the problem is solve!");
    }
    /*
     * 登记回调函数
     */
    public void askQuestion(){
        System.out.println("ask b solve the problem!");
    		/*
    		 * 自己去做其他事
    		 */
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("A want to do another thing!");
            }
        }).start();
    		/*
    		 * ask b to solve this problem
    		 */
        this.b.call(this);
    }
    /*
     * callback
     */
    public static void main(String[] args)  {
        A a = new A();
        a.askQuestion();
    }
}
