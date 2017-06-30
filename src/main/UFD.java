package main;

/**
 * Created by lyy on 2017/6/29.
 */
public class UFD {
    private String fileName;
    private boolean[] protectCode;
    private int fileLength;

    public UFD(String fileName, boolean[] protectCode, int fileLength) {
        this.fileName = fileName;
        this.protectCode = protectCode;
        this.fileLength = fileLength;
    }

    public UFD(String fileName) {
        this.fileName = fileName;
        fileLength=0;
        protectCode = new boolean[]{true,true,true};
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean[] getProtectCode() {
        return protectCode;
    }

    public void setProtectCode(boolean[] protectCode) {
        this.protectCode = protectCode;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }
}
