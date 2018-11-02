人见人爱的Spring已然不仅仅只是一个框架了。如今，Spring已然成为了一个生态。但深入了解Spring的却寥寥无几。这里，我带大家一起来看看，我是如何手写Spring的。我将结合对Spring十多年的研究经验，用不到400行代码来描述SpringIOC、DI、MVC的精华设计思想，并保证基本功能完整。

首先，我们先来介绍一下Spring的三个阶段，配置阶段、初始化阶段和运行阶段（如图）：

![img](img\1.png)

配置阶段：主要是完成application.xml配置和Annotation配置。

初始化阶段：主要是加载并解析配置信息，然后，初始化IOC容器，完成容器的DI操作，已经完成HandlerMapping的初始化。

运行阶段：主要是完成Spring容器启动以后，完成用户请求的内部调度，并返回响应结果。

先来看看我们的项目结构(如下图)

![img](img\2.png)

一、配置阶段

我采用的是maven管理项目。先来看pom.xml文件中的配置，我只引用了servlet-api的依赖。

![img](img\3.png)

然后，创建GPDispatcherServlet类并继承HttpServlet，重写init()、doGet()和doPost()方法。

![img](img\4.png)

在web.xml文件中配置以下信息：

![img](img\5.png)

在<init-param>中，我们配置了一个初始化加载的Spring主配置文件路径，在原生框架中，我们应该配置的是classpath:application.xml。在这里，我们为了简化操作，用properties文件代替xml文件。以下是properties文件中的内容：

![img](img\6.png)

接下来，我们要配置注解。现在，我们不使用Spring的一针一线，所有注解全部自己手写。

创建GPController注解：

![img](img\7.png)

创建GPRequestMapping注解：

![img](img\8.png)

创建GPService注解：

![img](img\9.png)

创建GPAutowired注解：

![img](img\10.png)

创建GPRequestParam注释：

![img](img\11.png)

使用自定义注解进行配置：

![img](img\12.png)

到此，我们把配置阶段的代码全部手写完成。

二、初始化阶段

先在GPDispatcherServlet中声明几个成员变量：

![img](img\13.png)

当Servlet容器启动时，会调用GPDispatcherServlet的init()方法，从init方法的参数中，我们可以拿到主配置文件的路径，从而能够读取到配置文件中的信息。前面我们已经介绍了Spring的三个阶段，现在来完成初始化阶段的代码。在init()方法中，定义好执行步骤，如下：

![img](img\14.png)

doLoadConfig()方法的实现，将文件读取到Properties对象中：

![img](img\15.png)

doScanner()方法，递归扫描出所有的Class文件

![img](img\16.png)

doInstance()方法，初始化所有相关的类，并放入到IOC容器之中。IOC容器的key默认是类名首字母小写，如果是自己设置类名，则优先使用自定义的。因此，要先写一个针对类名首字母处理的工具方法。

![img](img\17.png)

然后，再处理相关的类。

![img](img\18.png)

doAutowired()方法，将初始化到IOC容器中的类，需要赋值的字段进行赋值

![img](img\19.png)

initHandlerMapping()方法，将GPRequestMapping中配置的信息和Method进行关联，并保存这些关系。

![img](img\20.png)

到此，初始化阶段的所有代码全部写完。

三、运行阶段

来到运行阶段，当用户发送请求被Servlet接受时，都会统一调用doPost方法，我先在doPost方法中再调用doDispach()方法，代码如下：

![img](img\21.png)

doDispatch()方法是这样写的：

![img](img\22.png)

到此，我们完成了一个mini版本的Spring，麻雀虽小，五脏俱全。我们把服务发布到web容器中，然后，在浏览器输入：http://localhost:8080/demo/query.json?name=Tom，就会得到下面的结果：

![img](img\23.png)

当然，真正的Spring要复杂很多，但核心设计思路基本如此。例如：Spring中真正的HandlerMapping是这样的：

![img](img\24.png)

