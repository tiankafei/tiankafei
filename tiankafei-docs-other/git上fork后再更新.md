# 码云、GitHub如何更新fork后的代码

## 命令行方法

1. clone 自己的fork分支到本地

   ```shell
   git clone git@gitee.com:tiankafei/RuoYi.git
   ```

2. 增加源分支地址到你项目远程分支列表中(此处是关键)，先得将原来的仓库指定为upstream，命令为

   ```shell
   git remote add upstream https://gitee.com/y_project/RuoYi.git
   git remote add upstream https://gitee.com/geekidea/spring-boot-plus.git
   ```

   此处可使用git remote -v查看远程分支列表

   ```shell
   git remote -v
   ```

3. fetch源分支的新版本到本地

   ```shell
   git fetch upstream
   ```

4. 合并两个版本的代码

   ```shell
   git merge upstream/master
   ```

5. 将合并后的代码push到码云或github上去

   ```shell
   git push origin master
   ```

   