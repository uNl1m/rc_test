#!/bin/bash
set -x
echo 'Run tests'
gradle test
firstexit=$?
gradle allureReport
secondexit=$?
if [[ $firstexit -eq 1 || $secondexit -eq 1 ]];
then
    exit 1;
else
    exit 0;
fi
