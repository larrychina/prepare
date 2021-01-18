package org.larry.design.factory.simple;

/**
 * 开发者工厂
 */
public class DeveloperFactory {

    /**
     * 创建工厂类
     * @param name
     * @return
     */
    public IDevopment create(String name){
        if("java".equals(name)){
            return new JavaDevolper();
        } else if("app".equals(name)){
            return new AppDevolper();
        }
        return null ;
    }

    /**
     * 利用反射技术进行优化
     * @param className
     * @return
     */
    public IDevopment createBean(Class<? extends IDevopment> className){
        try {
            if(className !=null && !className.equals("")){
                return className.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static void main(String[] args) {
        DeveloperFactory factory = new DeveloperFactory() ;
        IDevopment devopment = factory.create("java");
        devopment.dev();
        IDevopment devopment1 = factory.createBean(AppDevolper.class);
        devopment1.dev();
    }
}
