## [nexus](https://www.sonatype.com/download-oss-sonatype)

### windows配置

1. 下载`nexus-**-win64.zip` ,并解压到对应到 `nexus`文件夹中.
2. 配置`NEXUS_PATH`到`nexus`文件夹
3. 配置`PATH`,添加 `%NEXUS_PATH%\bin` 到 `PATH` 上
4. 打开 `CMD` 可以进行以下操作:
    1. 添加服务 `nexus.exe /install <optional-service-name>`
    2. 启动服务 `nexus.exe /start <optional-service-name>`
    3. 停止服务 `nexus.exe /stop <optional-service-name>`
    4. 卸载服务 `nexus.exe /uninstall <optional-service-name>`
    5. [service-windows](https://books.sonatype.com/nexus-book/reference3/install.html#service-windows)

