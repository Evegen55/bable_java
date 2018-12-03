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
    32      0.069 s
    64      0.259 s
    128     1.586 s
    256     4.153 s
    512     14.589
    1K      1 m 4.887 s

### [CPU Intel® Core™ i5-7300HQ](https://ark.intel.com/ru/products/97456/Intel-Core-i5-7300HQ-Processor-6M-Cache-up-to-3-50-GHz-):

    Compiler: javac

    Operating system:  Linux Ubuntu 16.04

    N       CPU time              dE/E
    32      0.028 s               1.5021219460682893E-8
    64      0.378 s               5.093187159127767E-7
    128     0.744 s               2.367144712673576E-6
    256     1.941 s               -7.318832591061808E-8
    512     6.294 s               -1.2621540252947774E-6
    1K      25.004 s              0.0014047188169089397
    2K      1 m 27.723 s          -3.2808998334836616E-4
    4K      387.945               7.583283119082292E-5
    8K      1870.024              -1.5033522120889067E-4
    16K     2 h 14 m 19.047s      -2.3991065527427605E-5

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