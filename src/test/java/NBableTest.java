import org.junit.Test;

public class NBableTest {

    @Test
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
    public void mainWithBigFiles() {
        String filename = "src\\test\\resources\\inputFilesSmall\\input512";
        String[] args = {filename};
        NBable.main(args);
    }
}