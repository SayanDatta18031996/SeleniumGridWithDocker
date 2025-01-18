docker network create gridnetwork
docker run -d -p 4445:4444 -p 4442:4442 -p 4443:4443 --net gridnetwork --name seleniumHub selenium/hub:latest
docker run -d -p 5900:5900 --net gridnetwork -e SE_EVENT_BUS_HOST=seleniumHub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 --name chromeNode selenium/node-chrome:latest
docker run -d -p 5901:5900 --net gridnetwork -e SE_EVENT_BUS_HOST=seleniumHub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 --name firefoxNode selenium/node-firefox:latest
docker run -d -p 5902:5900 --net gridnetwork -e SE_EVENT_BUS_HOST=seleniumHub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 --name edgeNode selenium/node-edge:latest
docker run -d -P --net gridnetwork -e SE_EVENT_BUS_HOST=seleniumHub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 --name chromeNode2 selenium/node-chrome:latest
