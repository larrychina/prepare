###  装饰器模式

  装饰器模式，也称为包装模式，在不改变原来对象的基础上，增加附属功能到对象身上，提供了比继承更加弹性的扩展方案，装饰器模式用于动态和
  透明的扩展类。
  
#### 实现原理

 component: 抽象组件，充当了被装饰类的原始对象，规定了装饰类的行为
 
 ConCreateComponent: 被装饰对象
 
 Decorator : 装饰器对象，其内部必然有一个属性指向Component,其实一般是一个抽象类，主要为了让其子类按照其构造形式传入一个Component.
 
 ConCreateDecorator : 装饰器的具体实现类。
 
 
 #### 优缺点
 
优点：

1，装饰器是继承的有力补充，不改变原有对象的情况，动态的扩展功能  
2，通过不同的装饰器类，已经不同的组合，产生不同的效果  
3，符合开闭原则

缺点：

1，会增加较多的装饰类
2，动态装饰时，多层装饰，逻辑更加复杂
  
 
 


  
  
  
