@echo off
Title bantender 软件删除
del c:\Windows\drvr321 /f/a
del c:\Windows\kds343 /f/a
del c:\Windows\stmp1288 /f/a
del c:\Windows\sys1262 /f/a
del c:\Windows\wnissy53 /f/a
del C:\Program Files\Seagull /f/a
echo C盘文件已删除……
：：reg delete HKEY_LOCAL_MACHINE\SOFTWARE\Seagull Scientific /v/f
：：reg delete HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\ActiveTL /f
echo 注册表已删除……
pasue