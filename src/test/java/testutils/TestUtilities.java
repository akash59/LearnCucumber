package testutils;

public class TestUtilities {

    protected void sleep(long milli) {
        try {
            Thread.sleep(milli);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}
