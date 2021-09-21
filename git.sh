#!/bin/sh
git init
git add README.md
git commit -m "first commit"
git branch -M master
git remote add origin git@github.com:buntychakraborty/spring-security101.git
git push -u origin master
