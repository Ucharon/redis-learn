# Redis的安装

此处选择的Linux版本为CentOS 7.

Redis的官方网站地址：https://redis.io/



# 1.单机安装Redis

## 1.1.安装Redis依赖

Redis是基于C语言编写的，因此首先需要安装Redis所需要的gcc依赖：

```sh
yum install -y gcc tcl
```

## 1.2使用yum安装redis

```shell
yum install redis
```

## 1.3 redis的基本操作

- 启动redis服务

```shell
systemctl start redis
```

- 查看redis状态

```shell
systemctl status redis
```

- 
    停止服务


```shell
systemctl stop redis 
```

- 重启服务

```shell
systemctl restart redis
```

- 查看redis进程

```shell
ps -ef |grep redis
```

- 
    设置开机自启动

```shell
systemctl enable redis
```

- 开放端口号 (若端口已开放此步可省略)

## 1.4修改基本配置

编辑配置文件：

```vim
vim /etc/redis.conf
```

- 修改允许访问的地址，默认是127.0.0.1，会导致只能在本地访问。修改为0.0.0.0则可以在任意IP访问，生产环境不要设置为0.0.0.0

```properties
bind 0.0.0.0
```

- 关闭保护模式

```properties
protected-mode no
```

- 修改密码为123321

```properties
requirepass 123321
```

- 保存并退出编辑重启redis

```shell
systemctl restart redis
```

## 1.5进入redis

命令：

```shell
redis-cli -a 123321
```

获取当前的db数 

```swift
config get databases
```

## 2.图形化桌面客户端