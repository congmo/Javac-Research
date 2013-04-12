com.sun.tools.javac.jvm.Gen===>genClass(2) 
调用implementInterfaceMethods(c)的目的：
c是一个ClassSymbol，如果c是ABSTRACT的，且没有实现接口中的棊一方法，
则自定义一个MethodSymbol代表接口中的相应方法，加入c.members()，

如果c实现了接口中的棊一IPROXY方法，则修改c中相应方法的异常抛出类型

要满足以下条件为true
if (generateIproxies && //jdk1.1与jdk1.0才需要
		(c.flags() & (INTERFACE|ABSTRACT)) == ABSTRACT
		&& !allowGenerics // no Miranda methods available with generics
		)
		implementInterfaceMethods(c);

当加了-XDmiranda或者指定(-target 1.1 且-source 为 1.2 到1.4时）时generateIproxies=true

当(c.flags() & (INTERFACE|ABSTRACT)) == ABSTRACT时，c只能是一个abstract类，

下面的例子可以使流程执行implementInterfaceMethods(c);

在javac后加下面两个选项:
-target 1.1 -source 1.2

编译源文件：
public abstract class GenTest {｝
//public interface GenTest {｝这种方式不行



下面的例子加-target 1.1 -source 1.2时有错

src/my/test/GenTest.java:6: my.test.GenTest 中的 interfaceMethodC() 无法实现 my.test.GenTestInterfaceB 中的 interfaceMethodC()；正在尝试使用不兼容的返回类型
找到： java.lang.Integer
需要： java.lang.Number
    public abstract Integer interfaceMethodC();
                            ^
1 错误


package my.test;


public abstract class GenTest implements GenTestInterfaceB {
    public abstract Integer interfaceMethodC();
}

interface GenTestInterfaceA {
    void interfaceMethodA();
}

//接中不能使用implements，但可以使用extends，且extends后可接多个名称
//interface GenTestInterfaceB implements GenTestInterfaceA {
interface GenTestInterfaceB extends GenTestInterfaceA {
    void interfaceMethodB();
    Number interfaceMethodC();
    
    //static void interfaceMethodStatic();
}













