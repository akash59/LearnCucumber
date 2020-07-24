#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

#echo "Checking if hub is ready -" $HUB_HOST
#echo "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )"
#while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
#do
#	sleep 1
#done

# start the java command
java -cp cucumber-selenium-docker.jar:cucumber-selenium-docker-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DBROWSER=$BROWSER \
    -Dcucumber.features="$FEATURES" \
    -Dcucumber.filter.tags="$FILTER_TAGS" \
    org.testng.TestNG -testclass testrunners.TestRunner