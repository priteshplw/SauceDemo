package javaPractice;

public class GetSystemData {
    public static void main(String[] args) {
        // Get System start time
        long startTime=System.currentTimeMillis();
        System.out.println("\nEnvironment variable PATH: ");
        String[] split=System.getenv("PATH").split(";");
        for (String s :
                split) {
            System.out.println("=>" + s);
        }

        // gets the value of the specified environment variable "TEMP"
        System.out.println("\nEnvironment variable TEMP: ");
        System.out.println(System.getenv("TEMP"));

        // gets the value of the specified environment variable "USERNAME"
        System.out.println("\nEnvironment variable USERNAME: ");
        System.out.println(System.getenv("USERNAME"));

        // Get System end time
        long endTime=System.currentTimeMillis();

        //Calculate how much time is taken to complete the run
        System.out.println("Time taken to execute program =>"+(endTime-startTime));
    }
}
