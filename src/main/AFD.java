package main;

/**
 * Created by lyy on 2017/6/29.
 */
public class AFD {
    private String openFileName;
    private boolean[] openProtectCode;
    private int readAndWriteState;

    public String getOpenFileName() {
        return openFileName;
    }

    public void setOpenFileName(String openFileName) {
        this.openFileName = openFileName;
    }

    public boolean[] getOpenProtectCode() {
        return openProtectCode;
    }

    public void setOpenProtectCode(boolean[] openProtectCode) {
        this.openProtectCode = openProtectCode;
    }

    public int getReadAndWriteState() {
        return readAndWriteState;
    }

    public void setReadAndWriteState(int readAndWriteState) {
        this.readAndWriteState = readAndWriteState;
    }

    public AFD(String openFileName, boolean[] openProtectCode, int readAndWriteState) {
        this.openFileName = openFileName;
        this.openProtectCode = openProtectCode;
        this.readAndWriteState = readAndWriteState;
    }
}
