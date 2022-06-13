# spring-scheduled-transaction-bug-demo
This repo is a small example to reproduce a quirk in Spring transactions when combined with scheduled tasks.

## What does this app do?
The App starts a scheduled job every 20 seconds, that runs a small database update.
The same database update method can be triggered via `GET localhost:<your port>/updateAll`.
The current list of entities in the database is listed via `GET localhost:<your port>/listAll`.

Funnily enough, the scheduled job never commits anything to the database, 
while the one triggered via the RestController does commit everything.

See the [comments in the update method](src/main/kotlin/com/example/springscheduledtransactionbugdemo/DbTestService.kt) for more details.

## How to run
- Start a local MySQL8 server. 
You may want to use the provided Docker Compose project in `docker-local-db`.
Copy and rename [`docker-compose.override.template.yml`](docker-local-db/docker-compose.override.template.yml) to `docker-compose.override.yml` to override the port binding if necessary.
- Copy [`application-default.template.properties`](src/main/resources/application-default.template.properties) to `application-default.properties` and adjust your local config.
This is only needed if you want to adjust port bindings or use a different database server.
- Start the main function in [`SpringScheduledTransactionBugDemoApplication.kt`](src/main/kotlin/com/example/springscheduledtransactionbugdemo/SpringScheduledTransactionBugDemoApplication.kt).
