### git + http.proxy

    git config --global http.proxy socks://127.0.0.1:1080
    git config --global https.proxy socks://127.0.0.1:1080

使用上面的命令配置完之后，会在 ~/.gitconfig 文件中多出几行：


    [http]
        proxy = socks://127.0.0.1:1080
    [https]
        proxy = socks://127.0.0.1:1080

你也可以使用下面的命令检查配置是否生效：


    git config --global --get http.proxy
    git config --global --get https.proxy

另外，如果你想取消该设置，可以：

    git config --global --unset http.proxy
    git config --global --unset https.proxy
