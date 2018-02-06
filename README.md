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

old processor:

    N	CPU time    	dE/E
    32	2.778 s 		7.34E-7
    64	9.882 s 		3.60E-6
    128	38.906 s		1.72E-6

[CPU Intel® Core™ i5-6300U](https://ark.intel.com/ru/products/88190/Intel-Core-i5-6300U-Processor-3M-Cache-up-to-3_00-GHz):

    N       CPU time        dE/E
    32      0.069 s         doityourself
    64      0.259 s         doityourself
    128     1.586 s         doityourself
    256     4.153 s         doityourself
    512     14.589          doityourself
    1K      1 m 4.887 s     doityourself

**This code is submitted free of license

How to compile:
>javac NBable.java

How to run:
>java NBable <full path to input file>