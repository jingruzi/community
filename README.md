## 问答社区

## 资料
[Spring 文档](https://spring.io/guides)
<br>[Spring Web](https://spring.io/guides/gs/serving-web-content/)
<br>[es](https://elasticsearch.cn/explore)
<br>[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
<br>[Bootstrap](https://v3.bootcss.com/components/#navbar-default)
<br>[Github OAuth 文档](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
<br>[okHttp](https://square.github.io/okhttp/)
<br>[h2](http://www.h2database.com/html/quickstart.html)
<br>[Spring DataBase Support](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)
<br>[MyBaties](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
<br>[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
<br>[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-config-interceptors)
<br>[MyBaties Generator](http://mybatis.org/generator/running/runningWithMaven.html)

## 工具
[Git](https://www.git-scm.com/download/)
<br>[Visual Paradigm](https://www.visual-paradigm.com)
<br>[Maven repository](https://mvnrepository.com/)
<br>[Flyway](https://flywaydb.org/getstarted/firststeps/maven)
<br>[Lombok](https://projectlombok.org/)
<br>[jQuery](https://code.jquery.com/jquery-3.4.1.min.js)
<br>[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)

## 脚本
```sql
CREATE TABLE USER(
    "ID" INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    "ACCOUNT_ID" VARCHAR(100),
    "NAME" VARCHAR(50),
    "TOKEN" CHAR(36),
    "GMT_CREATE" BIGINT,
    "GMT_MODIFIED" BIGINT
);
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
