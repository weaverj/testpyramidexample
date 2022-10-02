#!/usr/bin/env bash

TOMURL="https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.37/bin/apache-tomcat-8.5.37.tar.gz"
sudo useradd -m -d /opt/tomcat -U -s /bin/false tomcat
sudo apt update

sudo apt install default-jdk -y
java -version

cd /tmp/
wget $TOMURL -O tomcatbin.tar.gz
sudo tar xzvf tomcatbin.tar.gz -C /opt/tomcat --strip-components=1

sudo chown -R tomcat:tomcat /opt/tomcat/
sudo chmod -R u+x /opt/tomcat/bin

if [ -t /etc/systemd/system/tomcat.service ]; then
  rm -rf /etc/systemd/system/tomcat.service
fi


cat << EOT >> /etc/systemd/system/tomcat.service
[Unit]
Description=Tomcat
After=network.target

[Service]
Type=forking

User=tomcat
Group=tomcat

Environment="JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64"
Environment="JAVA_OPTS=-Djava.security.egd=file:///dev/urandom"
Environment="CATALINA_BASE=/opt/tomcat"
Environment="CATALINA_HOME=/opt/tomcat"
Environment="CATALINA_PID=/opt/tomcat/temp/tomcat.pid"
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
EOT


systemctl daemon-reload
systemctl start tomcat
systemctl enable tomcat
