---

title: javascript 学习笔记
desc: 
keywords: javaScript
date: 2017-04-17 01:16:34
tags: js
categories:
	js
---
##	函数
###	函数的arguments和this

	arguments是函数对象中的一个隐藏属性，通过这个属性可以获取相应的参数值，这个属性其实就传递过来的参数，它是一个数组。

		function say(color){
			alert(color) ;   // 结果为1
			for(var cl in arguments){
				alert(color) ;
			} // 结果为1；2；3
		}
		say(1,2,3) ;
		/**
		 * arguments这个对象中有个方法callee,arguments.callee(参数)可以反向调用
		 * 比如在递归中可以使用此方法，从而不会导致因函数名改变而发生错误
		  */

	当需要创建一个类时，设置该类的属性和方法需要使用this关键字，次用法类似java的this关键字

###	函数的属性，call,apply

	函数有两个重要的属性length和prototype:

	length在函数中的作用是获取参数的个数：

		function fn1(){}
		function fn2(a){}
		function fn3(a,b){}

		fn1.length // 0   fn2.length // 1 fn3.length //2

	call 函数名.call(对象，参数列表) ；

	apply 函数名.apply(对象，参数数组)
	
###	对象的工厂方式创建和构造函数创建

>	通过工厂方式创建对象：

	在函数中先创建一个对象，然后为这个对象设置属性和方法，再返回这个对象：
	function createPerson(name,age){
		   var obj = new Object() ;
		   obj.name = name ;
		   obj.age = age ;
		   obj.say = function(){
			   alert(this.name+":"+this.age) ;
		   }
	}


	var p = createPerson("zhangsan",23) ;
	console.log(typeof p); //始终都是object 无法检测是Person类型（instanceof）
	
>	通过构造函数方式创建对象:

	使用构造函数创建对象跟工厂方式类似，它是的函数名就是对象的类名，属性和方法是用this关键字赋值，对象创建使用new关键字：


	  function Person(name,age){
		   this.name = name ;
		   this.age = age ;
		   this.say = function(){
			   alert(this.name+":"+this.age) ;
		   }
	  }

	  var p1 = new Person("23",23) ;
	  var p2 = new Person("24",24) ;
	  alert(p1.say == p2.say) ; // false 由此可见，使用这种方式创建的对象每一个对象里都会存在方法的拷
									 贝，如果对象行为较多的话，消耗的空间就会很大。
									如果把方法设置成全局的行为，则可以被window对象调用，破坏了对象的封装特性，如果全局行为较多的话就会充斥着大量的全局代码，显得开发比较混乱


>	js原型对象是一个非常特殊的对象，当一个函数创建后，就会随之产生一个原型对象，当这个函数创建了一个对象，这个对象会指向这个原型对象

*	检测对象是否有prop指向原型:Person.prototype.isPrototypeOf(p) ; // true or false

			// 使用基于原型的创建属性和方法，则为对象专属，window对象不能调用

			function Person(){

			}

			Person.prototype.name = “zhangsan” ;
			Person.prototype.age = 23 ;
			Person.prototype.say = function(){

			alert(this.name + this.age) ;
			}
			var Person p = new Person() ;
			p.say() ; // 正常输出
			say() ； //报错

*	p.hasOwnProperty(“属性名”)，检测对象有没有自己设置值：

			var p2 = new Person() ;

			p2.name = "lisi" ;

			p2.hasOwerProperty("name") // true
*	重写原型的方式:

			Person.prototype={
				constructor:Person, // 不指定时会指向objcet,因为原型被重写了
				name:'',
				age:'',
				say:function(){
				}
			}
			
###	js对象继承

*	基于原型链的方式继承：

			function Parent(){

			this.pv = "" ;
			this.name = "larry" ;
			}

			Parent.prototype.show = function(){

			alert("parents:"this.name) ;
			}

			function Child(){

			this.cv = "" ;
			}

			Child.prototype = new Parent() ;

			Child.prototype.name = “yp” ;

			var child = new Child() ;

			child.show() // yp

*	基于构造函数的方式继承：
 略