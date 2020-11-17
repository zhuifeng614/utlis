## 一 首次提交代码到git仓库

- 第一步：git init 初始化项目文件夹
- 第二步：git add . 键所有文件添加到暂存区
- 第三步：git commit -m "first commit"  提交到本地仓库
- 第四步：git remote add origin XXX（XXX就是你github或者码云等远程仓库的地址，git branch这个命令可以看到你所在的分支，删除某个仓库地址使用git remote rm origin）
- 第五步：git pull 拉取远程分支信息，首次拉取合并信息
- 第六步：git push -u -f origin master 提交到远程仓库，这个命令中的 -f 是强制推送，因为远程仓库只有初始化的文件，所以强制推送上去就行了，不加-f 会报当前分支没有远程分支，强制推送可以覆盖master，这样就完成了第一次提交的步骤)

## 二 git仓库操作

- git remote remove origin # 删掉原来git源
- git remote add origin [YOUR NEW .GIT URL] # 将新源地址写入本地版本库配置文件
- git push -u origin master # 提交所有代码