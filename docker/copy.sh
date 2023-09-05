#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/quartz.sql ./mysql/db
cp ../sql/vrmlstudio_1.sql ./mysql/db
cp ../sql/vrmlstudio_2.sql ./mysql/db
cp ../sql/xy_config.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../vrmlstudio-ui/main/dist/** ./nginx/html/main
cp -r ../vrmlstudio-ui/administrator/dist/** ./nginx/html/administrator


# copy jar
echo "begin copy vrmlstudio-gateway "
cp ../vrmlstudio-gateway/target/vrmlstudio-gateway.jar ./vrmlstudio/gateway/jar

echo "begin copy vrmlstudio-auth "
cp ../vrmlstudio-auth/target/vrmlstudio-auth.jar ./vrmlstudio/auth/jar

echo "begin copy vrmlstudio-visual "
cp ../vrmlstudio-visual/vrmlstudio-monitor/target/vrmlstudio-visual-monitor.jar  ./vrmlstudio/visual/monitor/jar

echo "begin copy vrmlstudio-modules-system "
cp ../vrmlstudio-modules/vrmlstudio-system/target/vrmlstudio-modules-system.jar ./vrmlstudio/modules/system/jar

echo "begin copy vrmlstudio-modules-tenant "
cp ../vrmlstudio-modules/vrmlstudio-tenant/target/vrmlstudio-modules-tenant.jar ./vrmlstudio/modules/tenant/jar

echo "begin copy vrmlstudio-modules-file "
cp ../vrmlstudio-modules/vrmlstudio-file/target/vrmlstudio-modules-file.jar ./vrmlstudio/modules/file/jar

echo "begin copy vrmlstudio-modules-job "
cp ../vrmlstudio-modules/vrmlstudio-job/target/vrmlstudio-modules-job.jar ./vrmlstudio/modules/job/jar

echo "begin copy vrmlstudio-modules-gen "
cp ../vrmlstudio-modules/vrmlstudio-gen/target/vrmlstudio-modules-gen.jar ./vrmlstudio/modules/gen/jar