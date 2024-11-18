package com.example.feigndemo.annotation.version;

@Version(major = 1, minor = 0)
public class VersionTest {

    @Version(major = 1, minor = 1)
    private int xyz = 100;

    @Version(major = 1, minor = 0)
    public VersionTest() {

    }

    @Version(major = 1, minor = 1)
    public VersionTest(int xyz) {
        this.xyz = xyz;
    }

    @Version(major = 1, minor = 1)
    public void setXyz(int xyz) {
        this.xyz = xyz;
    }
    public void print() {

    }

}
