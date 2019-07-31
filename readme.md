
### 1.git clone
```bash
#最为常用的普通clone
$ git clone <版本库的网址>
    e.g.  $ git clone https://github.com/jquery/jquery.git

#指定不同的目录名
$ git clone <版本库的网址> <本地目录名>

#克隆时,默认使用origin主机, 可以加-o选项指定其它主机名
e.g.  $ git clone -o jQuery https://github.com/jquery/jquery.git
```

### 2.git remote
```bash
#列出所有远程主机
$ git remote

#使用-v选项,参看远程主机的网址
$ git remote -v

#查看该主机的详细信息
$ git remote show <主机名>

#添加远程主机
$ git remote add <主机名> <网址>

#删除远程主机
$ git remote rm <主机名>

#远程主机的改名
$ git remote rename <原主机名> <新主机名>
```

### 3.git fetch
```bash
#将远程主机版本更新取回本地(默认情况, 取回所有分支的更新)
$ git fetch <远程主机名>

#只想取回特定分支的更新，指定分支名
$ git fetch <远程主机名> <分支名>
    e.g. $ git fetch origin master
```

### 4.git pull
```bash
#取回远程主机某个分支的更新，再与本地的指定分支合并
$ git pull <远程主机名> <远程分支名>:<本地分支名>
    e.g.  $ git pull origin next:master     #取回origin主机的next分支，与本地的master分支合并
          $ git pull origin next            #如果远程分支是与当前分支合并,冒号后可以省略
          #git pull等同于先做git fetch，再做git merge
            即 $ git fetch origin
               $ git merge origin/next

#如果当前分支与远程分支存在追踪关系，git pull就可以省略远程分支名
$ git pull <远程主机名>

#如果当前分支只有一个追踪分支, 远程主机名可以省略
$ git pull

#注: 如果远程主机删除了某个分支，默认情况下，git pull 不会在拉取远程分支的时候，删除对应的本地分支。
#加上参数 -p 就会在本地删除远程已经删除的分支
$ git pull -p

```

### 5.git push
```bash
#将本地分支的更新，推送到远程主机 (跟pull相仿, 但'来源地'和'目的地相反')
$ git push <远程主机名> <本地分支名>:<远程分支名>

#省略远程分支名，则表示将本地分支推送与之存在"追踪关系"的远程分支
$ git push <远程主机名> <本地分支名>
    e.g  $ git push origin master   #将本地的master分支推送到origin主机的master分,如果后者不存在，则会被新建

#如果省略本地分支名，则表示删除指定的远程分支.
$ git push <远程主机名> :<远程分支名>
    e.g  $ git push origin :master
         # 等同于
         $ git push origin --delete master

#如果当前分支与远程分支之间存在追踪关系，则本地分支和远程分支都可以省略
$ git push <远程主机名>

#如果当前分支只有一个追踪分支，那么主机名都可以省略
$ git push

#如果当前分支与多个主机存在追踪关系，则可以使用-u选项指定一个默认主机，这样后面就可以不加任何参数使用git push
$ git push -u <远程主机名> <本地分支名>

#不管是否存在对应的远程分支，将本地的所有分支都推送到远程主机,使用--all选项
$ git push --all <远程主机名>

#如果远程主机的版本比本地版本更新,但一定要推送,可以使用--force选项
$ git push --force <远程主机名>     #结果导致远程主机上更新的版本被覆盖
```


### 6.git merge
git merge的基本用法为把一个分支或或某个commit的修改合并现在的分支上。
```bash
 # 将branch分支合并到当前分支
$ git merge <branch> 

```
在`PCOline`中开发, `release_search`是发行的版本, 也就是在打包时选择的版本, 我们不直接在这个分支上进行修改.  
现在我需要开发修改澳大利亚的代码,   
1.首先, 切换到dev分支上, merge release_search的代码, 这样dev的代码保持最新(通常这步不要操作, 因为已经最新, 除非有人在releas上进行修改)  
2.然后, 在dev的基础上新建分支`dev_dms`,这个分支就是我以后开发进行的分支,  
3.在`dev_dms`中进行开发,  
4.开发完后, 切换到`dev`分支, 将`dev_dms`merge过来,这样dev中就是开发完的分支  
5.切换到`release_search`分支, 将`dev`merge过来,这样release_search中就是最终的代码  



### 其它命令
```bash
$ git log                   #显示每一分支的提交历史
$ git log --decorate        #显示tag信息
$ git log --stat            #显示每次提交更改的东西
$ git status                #查看仓库的状态



$ git remote                    #列出所有主机名, 如果新clone一个project,Git会自动将原来的url添加进来,别名就叫做 origin.
$ git remote -v                 #查看主机名(别名)和对应的远程服务器地址
$ git remote show origin        #查看pull和push到远端具体的位置

#添加一个新的远程主机.
$ git remote add <远程主机名> <url>
    e.g.    $ git remote add origin git@github.com:guxinaiheqiao/react-starter

#删除一个存在的远程主机
$ git remote rm <远程主机名>

#给远程主机重命名
$ git remote rename <old-远程主机名> <new-远程主机名>

#更新url. 可以加上—push和fetch参数,为同一个别名set不同的存取地址.
$ git remote set-url <远程主机名> [url]



$ git commit -m "some message"    #提交已经被add进来的改动 添加comment
$ git commit -a                   #会先把所有已经track的文件的改动add进来,然后提交. 对于没有track的文件,还是需要git add一下.



$ git branch                  #查看本地所有分支,当前分支会被星号标示出.
$ git branch -r               #查看远程所有分支,但本地不一定有这些分支,可以在本地创建
$ git branch -a               #查看所有分支(本地+远程,以及关联关系)
$ git branch -v               #查看每一个分支的最后一次提交.
$ git branch (branchname)     #创建一个新的分支(当用这种方式创建分支的时候,分支是基于上一次提交建立的). 
$ git branch -d (branchname)  #删除一个本地分支.
$ git branch --set-upstream <本地分支名> <远程主机名>/<远程分支名>              #命令设置跟踪远程库和本地库
    e.g. $ git branch --set-upstream master origin/master
      #注: 新版本中, --set-upstream命令已过时, 使用 git branch --track dev origin/dev 

#删除已经跟踪的文件/文件夹
$ git rm --cached <fileName>
$ git rm --cached -r <folderName>




```
