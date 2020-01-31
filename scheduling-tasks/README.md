# Scheduling Tasks

### Description

You will build an application that prints out the current time every five seconds by using Spring’s @Scheduled annotation.

This example uses **fixedRate**, which specifies the interval between method invocations, measured from the start time of each invocation. There are [other options](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html#scheduling-annotation-support-scheduled), such as **fixedDelay**, which specifies the interval between invocations measured from the completion of the task. You can also use **@Scheduled(cron=". . .")** expressions for more sophisticated task scheduling.

The **@EnableScheduling** annotation ensures that a background task executor is created. Without it, nothing gets scheduled.

[Guide Link](https://spring.io/guides/gs/scheduling-tasks/)

