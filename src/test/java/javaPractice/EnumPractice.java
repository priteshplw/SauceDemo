package javaPractice;

public class EnumPractice {

    public static void main(String[] args) throws NullPointerException {
        Test test = Test.valueOf("addPlaceAPI");
        System.out.println("test = " + test.getResource());
    }
    enum Test {
        addPlaceAPI("/add/place"),
        deletePlaceAPI("delete/place"),
        updatePlaceAPI("update/place"),
        getPlaceAPI("get/place");
        String res;

        Test(String s) {
            this.res = s;
        }

        String getResource() {
            return res;
        }
    }
}

