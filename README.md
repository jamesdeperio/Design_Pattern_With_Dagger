# MVP ARCHITECTURE WITH DEPENDENCY INJECTION
![alt text](https://github.com/jamesdeperio/Design_Pattern_With_Dagger/mvp.png "mvp")
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
* ***CONTRACT*** interface (Event, ViewMethod, Presenter, State
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
