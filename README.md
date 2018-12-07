# MVP ARCHITECTURE WITH DEPENDENCY INJECTION
[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.11-green.svg?style=flat-square)](http://kotlinlang.org)
[![HitCount](http://hits.dwyl.io/jamesdeperio/MVP_Architecture_With_Dependency_Injection.svg)](http://hits.dwyl.io/jamesdeperio/MVP_Architecture_With_Dependency_Injection)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/jamesdeperio/MVP_Architecture_With_Dependency_Injection/graphs/commit-activity)
[![GitHub forks](https://img.shields.io/github/forks/jamesdeperio/MVP_Architecture_With_Dependency_Injection.svg?style=social&label=Fork&maxAge=2592000)](https://GitHub.com/jamesdeperio/MVP_Architecture_With_Dependency_Injection/network/)
[![GitHub stars](https://img.shields.io/github/stars/jamesdeperio/MVP_Architecture_With_Dependency_Injection.svg?style=social&label=Star&maxAge=2592000)](https://GitHub.com/jamesdeperio/MVP_Architecture_With_Dependency_Injection/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/jamesdeperio/MVP_Architecture_With_Dependency_Injection.svg?style=social&label=Watch&maxAge=2592000)](https://GitHub.com/jamesdeperio/MVP_Architecture_With_Dependency_Injection/watchers/)
[![GitHub followers](https://img.shields.io/github/followers/jamesdeperio.svg?style=social&label=Follow&maxAge=2592000)](https://github.com/jamesdeperio?tab=followers)

![alt text](https://github.com/jamesdeperio/MVP_Architecture_With_Dependency_Injection/blob/master/mvp_.png "mvp")
* ***BLACK ARROW*** - run on Dispatcher.Main
* ***GREY ARROW*** - subscribe on Dispatcher.IO
* ***BLUE ARROW*** - observe on Dispatcher.NewThread

TASKS TYPE
* ***VIEW METHOD*** - View Implementation
* ***PRESENTER*** - Logic Implementation

## PROCESS
1. User gives an action to ***CONTROLLER*** class that implements ***EVENT***. Then the ***CONTROLLER*** evaluate the ***STATE*** to identify which *task* to be called either it needs to *process data* or just *update the view* immediately.

2. ***VIEW IMPLEMENTATION*** which implements ***VIEW METHOD***, is the middleware or bridge to manipulate the ***COMPONENT***.

3. ***COMPONENT*** class is a collection of widgets that is bind to specific layout.

4. ***EVALUATION*** class is the interpreter to identify the current ***STATE***.

5. ***LOGIC IMPLEMENTATION*** class which implements ***PRESENTER***, is in charge in *processing of data* came from network request or dao, then it notify the changes in COMPONENT’s properties using the ***VIEW METHOD*** as the middleware.

## CLASSES PER APP MODULE
* ***CONTRACT*** interface (Event, ViewMethod, Presenter, State)
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - abstraction pattern (holds the middleware methods and callbacks.) 
* ***CONTROLLER*** implements ***EVENT***
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - templated pattern (just like writing a suedo code)
* ***IMPLEMENTATION*** implements ***PRESENTER***
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - observer & chain pattern (much easier to understand logic because it reduces boilerplates)
* ***EVALUATION*** implements ***STATE***
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - interpreter pattern (condition should be named property)
* ***COMPONENT***
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - builder pattern (create/identify the widget and set its default properties)
* ***VIEW IMPLEMENTATION*** implements ***VIEW METHOD***
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - component manipulation
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - all method are executed on UI thread
* ***MODULE***
<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - dependency injection pattern (provide all class that needs to be coupled)
