# elasticsearch-hanlp

文件路径按着自己的安装路径设置

1. 编译、打包插件
    
    `gradle -p es-plugin jar buildPluginZip`
    
2. 使用命令安装插件
    
    `ES_HOME/bin/elasticsearch-plugin install file:///home/hldev/hldata/data/hanlp-ext/es-plugin/build/distributions/elasticsearch-analysis-hanlp-5.2.2.zip` 
    
3. 修改 `ES_HOME/config` 目录下的 `jvm.options` 文件添加一行
    
    `-Djava.security.policy=file:///你的ES目录/plugins/elasticsearch-analysis-hanlp/plugin-security.policy`
    
4. 最后修改ES/bin/elasticsearch.in.sh文件将 ES_CLASSPATH修改为
    
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

*输出：*

```json
{
  "tokens": [
    {
      "token": "重庆",
      "start_offset": 0,
      "end_offset": 2,
      "type": "ns",
      "position": 0
    },
    {
      "token": "华龙网",
      "start_offset": 2,
      "end_offset": 5,
      "type": "nr",
      "position": 1
    },
    {
      "token": "海数",
      "start_offset": 5,
      "end_offset": 7,
      "type": "nr",
      "position": 2
    },
    {
      "token": "科技",
      "start_offset": 7,
      "end_offset": 9,
      "type": "n",
      "position": 3
    },
    {
      "token": "有限公司",
      "start_offset": 9,
      "end_offset": 13,
      "type": "nis",
      "position": 4
    }
  ]
}
```

```curl
    GET /_analyze?pretty
    {
      "text" : ["重庆华龙网海数科技有限公司"]
    }
```

*输出：*

```json
{
  "tokens": [
    {
      "token": "重",
      "start_offset": 0,
      "end_offset": 1,
      "type": "<IDEOGRAPHIC>",
      "position": 0
    },
    {
      "token": "庆",
      "start_offset": 1,
      "end_offset": 2,
      "type": "<IDEOGRAPHIC>",
      "position": 1
    },
    {
      "token": "华",
      "start_offset": 2,
      "end_offset": 3,
      "type": "<IDEOGRAPHIC>",
      "position": 2
    },
    {
      "token": "龙",
      "start_offset": 3,
      "end_offset": 4,
      "type": "<IDEOGRAPHIC>",
      "position": 3
    },
    {
      "token": "网",
      "start_offset": 4,
      "end_offset": 5,
      "type": "<IDEOGRAPHIC>",
      "position": 4
    },
    {
      "token": "海",
      "start_offset": 5,
      "end_offset": 6,
      "type": "<IDEOGRAPHIC>",
      "position": 5
    },
    {
      "token": "数",
      "start_offset": 6,
      "end_offset": 7,
      "type": "<IDEOGRAPHIC>",
      "position": 6
    },
    {
      "token": "科",
      "start_offset": 7,
      "end_offset": 8,
      "type": "<IDEOGRAPHIC>",
      "position": 7
    },
    {
      "token": "技",
      "start_offset": 8,
      "end_offset": 9,
      "type": "<IDEOGRAPHIC>",
      "position": 8
    },
    {
      "token": "有",
      "start_offset": 9,
      "end_offset": 10,
      "type": "<IDEOGRAPHIC>",
      "position": 9
    },
    {
      "token": "限",
      "start_offset": 10,
      "end_offset": 11,
      "type": "<IDEOGRAPHIC>",
      "position": 10
    },
    {
      "token": "公",
      "start_offset": 11,
      "end_offset": 12,
      "type": "<IDEOGRAPHIC>",
      "position": 11
    },
    {
      "token": "司",
      "start_offset": 12,
      "end_offset": 13,
      "type": "<IDEOGRAPHIC>",
      "position": 12
    }
  ]
}
```