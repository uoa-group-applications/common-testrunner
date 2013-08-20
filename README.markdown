common-testrunner
=================

This provides two test annotations to enable easy configuration for common use cases.

    @RunWith(GroupAppsUnitTestRunner.class)

Will load in the Java Util Logging -> SLF4j bridge (as the WAR does) and load any system properties.

    @RunWith(GroupAppsIntegrationTestRunner.class)

This extends the SpringJUnit4TestRunner and does the same things as the Unit Test Runner, but also loads in the ebean agent loader agent.

    @RunWith(GroupAppsSpringTestRunner.class)

As the GroupAppsIntegrationtestRunner but does not load the Ebean agent.

