## Spring Boot Docker

An isolated development and production environments for spring boot.

This template has MongoDB, Postgresql, for dev and production environments and an in-memory H2 database for testing.

The main image is base on ubuntu 14:04 and pre-installed with oracle jdk 8 and gradle 2.10

**Requirements:**
* Docker 1.10.x or higher
* Docker Compose 1.6.x or higher

Alternatively you can install Docker Toolbox on Windows and Mac OS machines which contains all the necessary tools.

On Windows and Mac OS machines you have to set some environments variable in order to connect to docker:
```bash
export DOCKER_MACHINE_NAME="default"
export DOCKER_HOST="tcp://192.168.xxx.xxx:2376"
export DOCKER_TLS_VERIFY="1"
export DOCKER_CERT_PATH="C:\Users\XXXXXXX\.docker\machine\machines\default"
```

On Mac OS:
```bash
export DOCKER_CERT_PATH="~/.docker/machine/machines/default"
```

**Note for Windows users:**
Docker Machine mounts just the `C:\Users` for the VM, So you should store and run the project under that directory.
If you want to store the project in different location you should share that directory with the VirtualBox VM.

### Run the application

For running the application in Development Environment:
```
$ docker-compose up
```

For running the application in Production Environment:
```bash
$ docker-compose -f docker-compose-prod.yml up
```

If you have already an image from the last script you should build the image first to have an up to date version of your production application.
```bash
$ docker-compose -f docker-compose-prod.yml build --no-cache
$ docker-compose -f docker-compose-prod.yml up
```

#### Start developing
Just run the application in dev mode and start modifying some code and the app restart and reflects the changes automatically in the running docker container.

_**Note for intellij users:**_  Changes will not reflect without a `Ctrl + F9` or _Build -> Make Project_

#### Debugging
You can connect to application with remote debugging feature and debug your application.

In your IDE add a Remote configuration and fill the Host and Port:
* Host: The server or docker vm address
- Port: 5005

#### Tips for Windows and Mac OS users:

Docker running in VM with limited resources is slow, and you may frustrated to develop a heavy app in a VM, 
For better performance consider increasing the amount of RAM and CPU for you docker machine in the VirtualBox settings.

Also you can develop and see the change in your local machine while the docker container in VM tries hard to stay up to date with you.

A better option is to use products like JRebel which is not free.

