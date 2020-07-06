package test.zlogger.com.demo.Model;

public class ChildOne {

    String propOne;
    String propTwo;
    ChildTwo innerObject;

    public ChildOne() {
    }


    public ChildOne(String propOne, String propTwo, ChildTwo innerObject) {
        this.propOne = propOne;
        this.propTwo = propTwo;
        this.innerObject = innerObject;
    }

    public String getPropOne() {
        return propOne;
    }

    public void setPropOne(String propOne) {
        this.propOne = propOne;
    }

    public String getPropTwo() {
        return propTwo;
    }

    public void setPropTwo(String propTwo) {
        this.propTwo = propTwo;
    }

    public ChildTwo getInnerObject() {
        return innerObject;
    }

    public void setInnerObject(ChildTwo innerObject) {
        this.innerObject = innerObject;
    }
}

