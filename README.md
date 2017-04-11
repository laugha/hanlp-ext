# HanLP Ext

HanLP 扩展

- [es-plugin](es-plugin): HanLP Elasticsearch插件
- [hanlp-io](hanlp-io): HanLP IOAdapter，支持更多存储系统

## es-plugin相关配置说明

文件路径按着自己的安装路径设置

1. 将 **es-plugin_main** 打成 *jar* 包
1. 新建一个名称为 **elasticsearch** 的文件夹（必须叫elasticsearch)
1. 将 *jar* 包和 **resources** 文件夹中的文件一起放入 **elasticsearch** 目录中
1. 将 **elasticsearch** 文件夹压缩成*zip*文件（文件名随便）
1. 使用命令安装插件
    >./elasticsearch-plugin install file///path/to/plugin.zip 
1. (另：直接在es的plugins目录下新建一个叫elasticsearch-analysis-hanlp，然后将上述文件放入亦可）
1. 安装好插件后在插件的安装目录下，创建如下目录结构
    ``` 
     mkdir hanlp
     cd hanlp
     mkdir config
     mkdir data
     ```
1. config目录下放hanlp的配置文件hanlp.properties(修改root=*ES的目录*/plugins/elasticsearch-analysis-hanlp/hanlp/)
1. data目录下放hanlp的字典文件
1. 修改ES/config目录下的jvm.options文件添加一行
    >-Djava.security.policy=file:///你的ES目录/plugins/elasticsearch-analysis-hanlp/plugin-security.policy
1. 最后修改ES/bin/elasticsearch.in.sh文件将 ES_CLASSPATH修改为
    >ES_CLASSPATH="$ES_HOME/lib/elasticsearch-5.2.2.jar:$ES_HOME/lib/*:$ES_HOME/plugins/elasticsearch-analysis-hanlp/hanlp/config"