# **Resource Handling in ZIO**

ZIO's resource management features work across 
synchronous, asynchronous, concurrent, 
and other effect types, 
and provide strong guarantees even in the presence
of failure, interruption, or defects in the application.

This repository demonstrates the resource handling
in zio 2.x version; using _`acquireReleaseWith`_

**Pre-requisite:** <BR>
<UL>
    <LI> Scala 2.13 </LI>
    <LI> SBT 1.4.3 </LI>
</UL>

**ZIO dependency:** <BR>
`libraryDependencies += "dev.zio" %% "zio" % "2.0.0-M4"`

**Command to execute application:** <BR>
`sbt run`
