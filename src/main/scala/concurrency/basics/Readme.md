# Sequence of files to check in the package:

Most of the notes/examples in this package will cover both Java Thread and the Java virtual threads
as part of the project loom. Below sequence of if followed will give an introduction to
both virtual and non-virtual threads.

Refer to [VirtualThread](VirtualThreads.md) file more all the findings and notes 
regarding the implementation of VirtualThreads in java. 

1. Check the concurrency.Utilities for simple thread creation code, and related notes
1. concurrency.basics
    1. FirstThread.scala for sample thread 
    1. FirstVirtualThread.scala for sample virtual thread creation
    1. CrashTheVM.scala for comparison of virtual vs platform threads
    1. ThreadNondeterminism.scala
  
### Resources & references 
1. [Oracle blogs on project loom](https://blogs.oracle.com/javamagazine/going-inside-javas-project-loom-and-virtual-threads)
