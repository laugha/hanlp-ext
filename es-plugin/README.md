# es-plugin相关配置说明

文件路径按着自己的安装路径设置

1. 编译、打包插件
    
    `gradle -p es-plugin jar buildPluginZip`
    
2. 使用命令安装插件
    
    `./elasticsearch-plugin install file:///home/hldev/hldata/data/hanlp-ext/es-plugin/build/distributions/elasticsearch-analysis-hanlp-5.2.2.zip` 
    
3. (另：直接在es的plugins目录下新建一个叫elasticsearch-analysis-hanlp，然后将上述文件放入亦可）

4. 修改 `ES_HOME/config` 目录下的 `jvm.options` 文件添加一行
    
    `-Djava.security.policy=file:///你的ES目录/plugins/elasticsearch-analysis-hanlp/plugin-security.policy`
    
5. 最后修改ES/bin/elasticsearch.in.sh文件将 ES_CLASSPATH修改为
    
    `ES_CLASSPATH="$ES_HOME/lib/elasticsearch-5.2.2.jar:$ES_HOME/lib/*:$ES_HOME/plugins/elasticsearch-analysis-hanlp/"`
   
最后运行elasticsearch即可

测试方法：

分别使用以下两种方式测试分词效果：

```curl
    GET /_analyze?pretty
    {
      "analyzer" : "hanlp",
      "text" : ["重庆华龙网海数科技有限公司"]
    }
```

```curl
    GET /_analyze?pretty
    {
      "text" : ["重庆华龙网海数科技有限公司"]
    }
```