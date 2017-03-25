1. city_code_cn 表 DDL：
CREATE TABLE `city_code_cn` (
  `ID` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CITY_CODE` char(4) NOT NULL COMMENT '城市代码》四位阿拉伯数字',
  `CITY_JB` tinyint(3) unsigned NOT NULL COMMENT '城市级别》非空。1：省级；2：地级；3：县级',
  `PROVINCE_CODE` char(4) NOT NULL COMMENT '所在省份代码》非空',
  `STATE` char(1) NOT NULL DEFAULT '1' COMMENT '城市状态》非空。0：无效城市；1：有效城市',
  `CITY_NAME` varchar(50) NOT NULL COMMENT '城市名称',
  `CITY` varchar(50) NOT NULL COMMENT '所在地级市名称',
  `PROVINCE` varchar(50) NOT NULL COMMENT '所在省份名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2324 DEFAULT CHARSET=utf8 COMMENT='全国城市表';
2. 项目测试可以根据 CityController 相关定义接口进行请求。如会用 JMeter 可以使用 jmeter 目录中的脚本。