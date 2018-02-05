http://www.nbabel.org
NBabel.java
Date: April 2010
Author:  Philip Breen (University of Edinburgh)

Integration scheme: Predictor-corrector leapfrog
Compiler: javac
Operating system:  Scientific Linux
Hardware: Intel(R) Pentium(R) 4 CPU 3.20GHz

Initial conditions: 32,64 and 128 particles Plummer distribution of equal mass

Time step (dt): constant and shared 0.001 N-body unit
Total time (tEnd): 1.0

Performance:

N	CPU time	dE/E
32	2.778		7.34E-7
64	9.882		3.60E-6
128	38.906		1.72E-6

**This code is submitted free of license

How to compile:
>javac NBable.java

How to run:
>java NBable < inputfile