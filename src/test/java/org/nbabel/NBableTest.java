package org.nbabel;

import org.junit.Ignore;
import org.junit.Test;

public class NBableTest {

    @Test
    @Ignore
    public void mainWithEmptyArgs() {
        String[] args = {};
        NBable.main(args);
    }

    @Test
    public void mainWithNoneEmptyArgs() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input16";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main32() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input32";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main64() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input64";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main128() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input128";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main256() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input256";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    public void main512() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input512";
        String[] args = {filename};
        NBable.main(args);
    }

    @Test
    @Ignore
    public void main1K() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input1K";
        String[] args = {filename};
        NBable.main(args);
    }
}