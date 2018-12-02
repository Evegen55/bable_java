# [NBabel](http://www.nbabel.org)

Date (first version): April 2010

Date (refactored): December 2018

Author:  Philip Breen (University of Edinburgh)

Author:  Evgenii Lartcev

Initial conditions: 32,64 and 128 particles Plummer distribution of equal mass

Time step (dt): constant and shared 0.001 N-body unit

Total time (tEnd): 1.0

## Performance measurement:

### [Intel® Pentium® 4 CPU 3.20GHz](https://ark.intel.com/ru/products/27500/Intel-Pentium-4-Processor-supporting-HT-Technology-3_20-GHz-1M-Cache-800-MHz-FSB)

    Integration scheme: Predictor-corrector leapfrog

    Compiler: javac

    Operating system:  Scientific Linux


    N	CPU time    	dE/E
    32	2.778 s 		7.34E-7
    64	9.882 s 		3.60E-6
    128	38.906 s		1.72E-6


### [CPU Intel® Core™ i5-6300U](https://ark.intel.com/ru/products/88190/Intel-Core-i5-6300U-Processor-3M-Cache-up-to-3_00-GHz):

    N       CPU time        dE/E
    32      0.069 s         doityourself
    64      0.259 s         doityourself
    128     1.586 s         doityourself
    256     4.153 s         doityourself
    512     14.589          doityourself
    1K      1 m 4.887 s     doityourself

### [CPU Intel® Core™ i5-7300HQ](https://ark.intel.com/ru/products/97456/Intel-Core-i5-7300HQ-Processor-6M-Cache-up-to-3-50-GHz-):

    Compiler: javac

    Operating system:  Linux Ubuntu 16.04

    N       CPU time        dE/E
    32      0.135 s         doityourself
    64       s              doityourself
    128      s              doityourself
    256      s              doityourself
    512     6.294 s         -5.005905457563923E-4
    1K      26.541 s        0.0011828322950373496
    2K      1 m 27.723 s    -3.2808998334836616E-4

## License

This code is submitted free of license

### How to compile:

    tools:

    apache maven 3

    jdk 1.10 (minimum)

     `mvn clean install -Dmaven.test.skip=true`

### How to run:

     cd target
     java bable_java-1.0.jar <full path to input file>