# git命令

## git同时连接多个远程仓库的配置

1. 查看远程仓库

   ```shell
   git remote -v
   ```

2. 添加远程仓库

   ```shell
   # git remote add 别名 远程仓库地址
   git remote add origin git@gitee.com:tiankafei/tiankafei.git
   ```

3. 如果此时一直pull不下去，也push不上去，可以使用以下命令使远程仓库和本地同步，消除差异

   ```shell
   # git pull 别名 分支名 --allow-unrelated-histories
   git pull origin master --allow-unrelated-histories
   ```

4. 消除远程仓库与本地仓库的差异之后，执行推送

   ```shell
   #git push 别名 分支名
   git push origin master
   ```

5. 多个远程分值的提交记录，必须一致才能够一起push远程仓库，如果有一个不一致的就不能同步进行。如果发现有不一致的，重复上述操作。一直到所有远程仓库的提交记录一致为止。

6. 删除所有远程仓库的配置

   ```shell
   #git remote remove 别名
   git remote remove origin
   ```

7. 选择一个主仓库，用来拉取

   ```shell
   #git remote add 别名 分支名
   git remote add origin git@gitee.com:tiankafei/tiankafei.git
   ```

8. 把其他仓库加进来

   ```shell
   # git remote set-url --add 别名 远程仓库地址
   git remote set-url --add origin git@github.com:tiankafei/tiankafei.git
   ```

9. 使用以上加入远程仓库命令的好处是：当执行 git push origin master时，会直接把代码一起push到多个远程仓库。