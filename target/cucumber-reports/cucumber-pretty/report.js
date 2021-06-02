$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/get_in.feature");
formatter.feature({
  "name": "Get into Workplace",
  "description": "    As a workplace user, I would like to access my News Feed\n    * signs into the application\n    * negative scenarios are yet to be written",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.background({
  "name": "Availing the user specific Logon web-link",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on SignOn page using \"https://ypgdtsmjgh.workplace.com/work/landing/input/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "org.facebook.products.steps.GetIn.i_am_on_signon_page_using(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Title should be \"Log in to Workplace\"",
  "keyword": "Then "
});
formatter.match({
  "location": "org.facebook.products.steps.GetIn.title_should_be(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Successful login",
  "description": "    \"\"\"\n    Signing in with a valid username\n    and password\n    \"\"\"",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Successfullogin"
    }
  ]
});
formatter.step({
  "name": "I submit my username \"qualitymanageribm@gmail.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "org.facebook.products.steps.GetIn.i_submit_my_username(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit password \"QAmanager@05\"",
  "keyword": "And "
});
formatter.match({
  "location": "org.facebook.products.steps.GetIn.submit_my_password(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to view my News Feed",
  "keyword": "Then "
});
formatter.match({
  "location": "org.facebook.products.steps.GetIn.i_should_be_able_to_view_my_news_feed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "not the error page",
  "keyword": "But "
});
formatter.match({
  "location": "org.facebook.products.steps.GetIn.not_the_error_page()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat org.facebook.products.steps.GetIn.not_the_error_page(GetIn.java:116)\r\n\tat ✽.not the error page(file:///C:/Users/Madhavan/IdeaProjects/workplace/src/test/resources/features/get_in.feature:23)\r\n",
  "status": "pending"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/post_status.feature");
formatter.feature({
  "name": "Post a status message",
  "description": "    As workplace user, I post message to a group",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PostStatus"
    }
  ]
});
formatter.background({
  "name": "Sign-in to the application",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.scenario({
  "name": "Status post to General group",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PostStatus"
    },
    {
      "name": "@ToGeneralGroup"
    }
  ]
});
formatter.step({
  "name": "I post message to a group",
  "keyword": "When "
});
formatter.match({
  "location": "org.facebook.products.steps.PostStatus.i_post_message_to_a_group()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"*[name\u003d\u0027xhpc_message_text\u0027]\"}\n  (Session info: chrome\u003d90.0.4430.212)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-OASLPNF\u0027, ip: \u0027192.168.1.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002716.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 90.0.4430.212, chrome: {chromedriverVersion: 90.0.4430.24 (4c6d850f087da..., userDataDir: C:\\Users\\Madhavan\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:60878}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 26dfdfc166db097f411ee58fbf26cc61\n*** Element info: {Using\u003dname, value\u003dxhpc_message_text}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:78)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByName(RemoteWebDriver.java:404)\r\n\tat org.openqa.selenium.By$ByName.findElement(By.java:284)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat jdk.proxy2/jdk.proxy2.$Proxy22.click(Unknown Source)\r\n\tat org.facebook.products.pages.Home.postStatus(Home.java:58)\r\n\tat org.facebook.products.steps.PostStatus.i_post_message_to_a_group(PostStatus.java:14)\r\n\tat ✽.I post message to a group(file:///C:/Users/Madhavan/IdeaProjects/workplace/src/test/resources/features/post_status.feature:11)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "It should appear in the News Feed",
  "keyword": "Then "
});
formatter.match({
  "location": "org.facebook.products.steps.PostStatus.it_should_appear_in_the_News_Feed()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});