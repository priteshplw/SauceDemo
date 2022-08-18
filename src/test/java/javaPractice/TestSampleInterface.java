package javaPractice;

public class TestSampleInterface implements SampleInterface {

    public static void main(String[] args) {
        TestSampleInterface tsi=new TestSampleInterface();
        tsi.myNumber();
        tsi.returnNumber();
        tsi.testChild();
        System.out.println("temp = " + tsi.num);

        //this upcasting of object reference
        SampleInterface si=new TestSampleInterface();
        si.myNumber();
        si.returnNumber();
        //you can't access child class methods from parent object reference.
//        si.testChild();
        // To make it work we have to downcast the object reference
        ((TestSampleInterface) si).testChild();
    }
    @Override
    public void returnNumber() {
        System.out.println("test sample return number");
    }
    @Override
    public void myNumber() {
        System.out.println("test sample number");
    }

    public void testChild(){
        System.out.println("this is child method");
    }

}
