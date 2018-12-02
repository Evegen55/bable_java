package org.nbabel;

import org.junit.Ignore;
import org.junit.Test;

//-XX:+UnlockDiagnosticVMOptions -XX:+PrintIntrinsics
public class NBableTest {

    @Test
    @Ignore
    public void mainWithEmptyArgs() {
        String[] args = {};
        NBable.main(args);
    }

    @Test
    public void main16() {
        String filename = "src/test/resources/inputFilesSmall/input16";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main32() {
        String filename = "src/test/resources/inputFilesSmall/input32";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main64() {
        String filename = "src/test/resources/inputFilesSmall/input64";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main128() {
        String filename = "src/test/resources/inputFilesSmall/input128";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main256() {
        String filename = "src/test/resources/inputFilesSmall/input256";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main512() {
        String filename = "src/test/resources/inputFilesSmall/input512";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main1K() {
        String filename = "src/test/resources/inputFilesSmall/input1k";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main2K() {
        String filename = "src/test/resources/input2k";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main4K() {
        String filename = "src/test/resources/input4k";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main8K() {
        String filename = "src/test/resources/input8k";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main16K() {
        String filename = "src/test/resources/input16k";
        String[] args = {filename};
        NBable.main(args);
    }
}