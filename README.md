# Concurrency on jvm
The project contains notes and details of concurrency techniques, patterns and models on JVM.
All the examples are done using scala3, though it's just the matter of syntax and can be 
referred by java, scala, kotlin, etc. developers.

**Note:** 
* Make sure you have the jdk17 with loom installed from here https://jdk.java.net/loom/
* It's assumed you have some basic understanding of Thread and java concurrency.
* Most theory is ignored and here you will find simple notes and related examples from the resources referred (mentioned below).
* The intention is to enhance your current understanding of currency on JVM or just a revision.
* If any issue with the doc or examples please create an issue on github, and we will try to fix is ASAP.

Please refer to individual package readme for more details on how to follow the code, examples and notes.

As such there is no strict sequence, direct reference or connection within the packages here but 
if below sequence followed will make more sense ;)

1. [concurrency.basics](src/main/scala/concurrency/basics)
1. [concurrency.executor](src/main/scala/concurrency/executor)
1. [concurrency.futures](src/main/scala/concurrency/futures)
1. [concurrency.promises](src/main/scala/concurrency/promises)
1. [concurrency.datastructures](src/main/scala/concurrency/)
1. [concurrency.tooling](src/main/scala/concurrency/)
1. [concurrency.cats-effects](src/main/scala/concurrency/)
1. [concurrency.akka](src/main/scala/concurrency/)

### Table of contents (WIP):
1. Thread basics
    > 1. Thread Creation
    > 1. User vs Daemon Thread
    > 1. Synchronization
    > 1. States of a Thread
    > 1. Locks
    > 1. WIP...
2. Atomic Variables
3. Ecexutor & ExecutorService
    > 1. Introduction
    > 1. Creating Simple Executor
    > 1. Available Executor implementations
    > 1. ForkJoin framework
    > 1. Scala Global executor
4. Future & Promises
    > 1. Promises in Scala
    > 1. Creating your own Future
    > 1. Creating a Cancellable Future
    > 1. WIP ...
5. Concurrent Data Structures
6. Concurrent design patterns
    > 1. WIP
7. Project loom
8. Tools & Profilers
9. Cats Effects
    > 1. WIP

   
### References:
> 1. Java Concurrency in Practice
> 1. Mastering Concurrency Programming with Java 8
> 1. Learning Concurrent Programming in Scala
> 1. The Art of Multiprocessor Programming
> 1. Oracle JDK API doccumentation
> 1. Type level cats effect docs/blogs
> 1. WIP ...

