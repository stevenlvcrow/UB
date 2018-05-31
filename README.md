# UB
spring-could + vue + elementUi

# 准备工作:  
   1: cd {classPath}/WWW  
   2: npm install  
   3: npm install babel-plugin-component -D

# 启动：  
   ## 后台：  
       run ServerCenter
       run ServerDB
       run ServerService  
       run ServerZuul
       
       访问 ： http://localhost:8769/swagger-ui.html#/
   ## 前端:  
       cd {classPath}/WWW  
       运行: npm run dev  
       打包: npm run build
   