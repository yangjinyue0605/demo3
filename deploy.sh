#!/usr/bin/env bash
#编译加部署demo站点

#需要配置如下参数
#项目路径，在Execute_shell 中配置项目路径
#export PROJ_PATH=这个jenkins任务在部署机器上的路径

#输入你的环境上tomcat的全路径
#export TOMCAT_APP_PATH=tomcat在部署机器上的路径

### base函数
killTomcat()
{
  pid = `ps -ef |grep tomcat|grep java|awk '{print $2}'`
  echo "tomcat ID list :$pid"
  if [ "$pid" = ""]
  then
    echo "no tomcat pid alive"
  else
    kill -9 $pid
  fi
}
cd $PROJ_PATH/demo3
#先clean target,再重新install打包
mvn clean install

#停tomcat
killTomcat

#删除原有工程
rm -rf $TOMCAT_APP_PATH/webapps/ROOT
rm -f $TOMCAT_APP_PATH/webapps/ROOT.war
rm -f $TOMCAT_APP_PATH/webapps/demo3-0.0.1-SNAPSHOT.war

#复制新的工程，复制war包到tomcat的webapps下
cp $PROJ_PATH/demo3/target/demo3-0.0.1-SNAPSHOT.war $TOMCAT_APP_PATH/webapps/

cd $TOMCAT_APP_PATH/webapps/
#重命名war包为ROOT.war
mv demo3-0.0.1-SNAPSHOT.war ROOT.war

#启动tomcat
cd $TOMCAT_APP_PATH
sh bin/startup.sh



