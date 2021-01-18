package org.larry.design.template;

/**
 * 模板模式
 * 优点：
 * 1，相同的代码逻辑放到父类中
 * 2，遵循开闭原则
 */
public abstract class CommonOrderService {


    /**
     * 提交订单方法
     */
    protected final void submitOrder(){
        // step1 组装数据
        this.bulidBasicData();

        // step2 校验支付方式
        this.validatePayWay();

        // step3 物流时效
        this.shipTime();

        // step4 寻源
        this.findSource();

        // step5 order
        this.order();

        // 增加钩子方法
        if(special()){
            // step6 other
            this.other();
        }
    }

    public void bulidBasicData(){
    }

    public void validatePayWay(){

    }

    public void shipTime(){

    }

    public void findSource(){

    }

    public void order(){

    }

    public void other(){

    }

    // 钩子方法：实现流程的微调
    public boolean special(){
        return false;
    }
}
