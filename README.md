# Spring Boot Practise

Practise Programs

-- Pratik Ambani


----------
Module 01:
----------
Microservices:
Loosely coupled SOA with bound context

Faster Changes
Higher availability
DevOps: CDCI
Loosely coupled
Failure Toleration
Independent teams

Spring Cloud:
March'15
Build common distributed systems patterns
Open Source
Run Anywhere
Optimized for spring apps

Reputed Spring Clould Projects:
Spring Cloud Sleuth
Spring Cloud Config
Spring Cloud Netflix
Spring Cloud Security
Spring Cloud Stream
Spring Cloud Zookeeper
Spring Cloud AWS
Spring Cloud Spinnaker
Spring Cloud Contract

In this course:
Spring Cloud Config
Spring Cloud Security
Spring Cloud Sleuth
Spring Cloud Task

SB Actuators:
health, beans, env, metrics, mappings, trace

Goals:
Understanding modern Microservices patterns
Exploring capability of Spring Cloud
Configuring and Extending Spring Cloud



----------
Module 02:
----------

* Role of configurations in microservices
    removing settings from compiled code
    change runtime behaviour
    enforce consistency
    cache data to reduce load on db

* Creating a config server
    Choose a config source
    Adding config files
    Build Spring Project
    Secure the configurations

Add spring-cloud-config-server dependency
@EnableConfigServer
Create app.props file

Create app1.properties, app2.properties, app3.properties
and set greeting=hi, hey, hello

Start server
http://localhost:8888/app1/default
http://localhost:8888/app2/default
http://localhost:8888/app3/default


Config Server:
uri : git location - points to git location
searchPaths:'stat*' - pattern to search sub directories
repos: points to alternate repo
pattern:'*/prod' : pattern to go to alternate repo
uri:'repo uri'

https://github.com/repo/rates/{application}/{profile}[/{label}]
label is optional
<branch: master>
|
|---applicaion.properties
|
|---station1
|------|--s1rates-dev.properties
|------|--s1rates-prod.properties
|------|--s1rates.properties
|------|
|---station2
|------|--s2rates-dev.properties
|------|--s2rates-prod.properties

* Creating config server for git files
    - Create github repo with files
    - create spring starter project
    - annotate main class
    - set git URL in YAML file(application.yml)
    - Run as Spring Boot app
    - Experiments with search paths and queries

Note: Use git URL and not cloning URL

Try with below URLs,
http://localhost:8888/s1rates/default
http://localhost:8888/s1rates/master