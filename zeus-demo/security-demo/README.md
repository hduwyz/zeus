## spring security

### Oath2

#### 默认的oath2接口

***
```$xslt
{[/oauth/authorize]}
{[/oauth/authorize],methods=[POST]
{[/oauth/token],methods=[POST]} 获取token
{[/oauth/check_token]}
{[/oauth/error]}
```


###请求方式：
####password模式：
```$xslt
http://localhost:8080/oauth/token?username=user_1&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456
```

#####响应如下：
```$xslt
{
    "access_token": "EczXkjy-GMSOwnMvZ0_o1apJvag",
    "token_type": "bearer",
    "refresh_token": "FsJ-CR1_l1l1276qxw0ggEvznog",
    "expires_in": 43199,
    "scope": "select"
}
``` 

####client模式： 
```$xslt
http://localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=123456
```


#####响应如下： 
```$xslt
{
    "access_token": "NvbtZqUy29_zmRW7DbCDGJwR2VI",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "select"
}
```
###携带accessToken参数访问受保护的资源：
######使用password模式获得的token:
```$xslt
http://localhost:8080/order/1?access_token=950a7cc9-5a8a-42c9-a693-40e817b1a4b0
```
得到了之前匿名访问无法获取的资源：order id : 1

#####使用client模式获得的token:
```$xslt
http://localhost:8080/order/1?access_token=56465b41-429d-436c-ad8d-613d476ff322
```
同上的响应order id : 1
