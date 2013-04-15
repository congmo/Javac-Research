Javac-Research
==============

Java语言编译器(javac)源代码学习研究(包括代码注释、文档、用于代码分析的测试用例)

##Run it

####获取代码

    git clone git://github.com/codefollower/Javac-Research.git Javac-Research
    
####构建eclipse项目

1.依次选择[File]->[New]->[Java Project]输入工程名称（这里是Javac-Research），选择`Create project from existing source`，选择`Javac-Research`工程中的`trunk`文件夹。点击[Finish]

2.右键点击项目，选择[Build Path]将`tool.jar`jar包引入到工程中，不然会报错，在`com.sun.tools.javac.Main.java`中有说明。
  另外，还需要在`Source`选项卡中的`Default output folder`改为`Javac-Research/classes`稍后会解释为何要做修改

3.工程中有些重复的类，需要手工剔除下。比如：`com.sun.tools.javac.code`包下就存在多个`Symbol`，我的处理是直接在文件名后增加.bak。切记，先将所有的重复的类都剔除掉，我在这上面吃了个大亏，以为是我引入的包太多，所以就傻了吧唧的一点点在jar包中删，浪费了大把大把时间，最后发现时这样。sign...

4.运行一下`com.sun.tools.javac.Main.java`，验证是否已经搭建成功。默认情况下会输出：

    用法：javac <选项> <源文件>
    其中，可能的选项包括：
    -g                         生成所有调试信息
    -g:none                    不生成任何调试信息
    -g:{lines,vars,source}     只生成某些调试信息
    -nowarn                    不生成任何警告
    -verbose                   输出有关编译器正在执行的操作的消息
    -deprecation               输出使用已过时的 API 的源位置
    -classpath <路径>            指定查找用户类文件和注释处理程序的位置
    -cp <路径>                   指定查找用户类文件和注释处理程序的位置
    -sourcepath <路径>           指定查找输入源文件的位置
    -bootclasspath <路径>        覆盖引导类文件的位置
    -extdirs <目录>              覆盖安装的扩展目录的位置
    -endorseddirs <目录>         覆盖签名的标准路径的位置
    -proc:{none,only}          控制是否执行注释处理和/或编译。
    -processor <class1>[,<class2>,<class3>...]要运行的注释处理程序的名称；绕过默认的搜索进程
    -processorpath <路径>        指定查找注释处理程序的位置
    -d <目录>                    指定存放生成的类文件的位置
    -s <目录>                    指定存放生成的源文件的位置
    -implicit:{none,class}     指定是否为隐式引用文件生成类文件 
    -encoding <编码>             指定源文件使用的字符编码
    -source <版本>               提供与指定版本的源兼容性
    -target <版本>               生成特定 VM 版本的类文件
    -version                   版本信息
    -help                      输出标准选项的提要
    -Akey[=value]              传递给注释处理程序的选项
    -X                         输出非标准选项的提要
    -J<标志>                     直接将 <标志> 传递给运行时系统
    
####说明

1. 这个搭建的过程是一个开源阅读者写的，算是一点心得，可能有不对的地方，如果有请勿喷codefollower。
2. 之所以要将`Default output folder`改为`Javac-Research/classes`是因为项目中有些bat文件，貌似是用于编译的，还没来的及仔细研究。bat文件中配置的class文件的路径就是这个。


最后，希望大家顺利。
