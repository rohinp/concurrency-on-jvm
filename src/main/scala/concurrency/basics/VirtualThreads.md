# Virtual Thread (Fiber)

* Fibers are scheduled by the JVM and not by the OS.
* Fibers are tasks which scheduled default using forkjoinpool
* There can be millions or even billions of blocking Fibers created, without frying up your JVM or CPU.
* In the life cycle of a Fiber it can go in to below mentioned different states
    1. NEW
    1. STARTED
    1. RUNNABLE       // runnable-unmounted
    1. RUNNING        // runnable-mounted
    1. PARKING   
    1. PARKED         // unmounted
    1. PINNED         // mounted
    1. YIELDING       // Thread.yield
    1. TERMINATED   // final state
* More on states of fibers, later (WIP).
* The tasks are run on a ForkJoin pool, but are scheduled by a carrier thread.
* Carrier threads are platform threads and ont virtual, these are threads responsible for scheduling our tasks.
* Carrier threads will reschedule our tasks if it is blocked and pick it up later when it's unblocked to execute it again.
* A submitted task can be picked up by multiple carrier thread one after other, based on blocking operations till it completely executed.
* How a carrier threads picks the task and continues execution is managed by the Continuations introduced in loom
* Continuations generally use cooperatively multitasking for scheduling. (more on it later)
* More on Continuations (WIP)