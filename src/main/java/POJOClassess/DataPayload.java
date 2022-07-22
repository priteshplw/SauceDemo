package POJOClassess;

import javax.swing.plaf.PanelUI;

public class DataPayload {
    public String crudUserPayload(String uname,String job){
        if (uname==null){
            return "{\n" +
                    "    \"job\": \""+job+"\"\n" +
                    "}";
        }else if (job==null){
            return "{\n" +
                    "    \"name\": \""+uname+"\"\n" +
                    "}";
        }else{
            return "{\n" +
                    "    \"name\": \""+uname+"\",\n" +
                    "    \"job\": \""+job+"\"\n" +
                    "}";
        }

    }
    public String registerUserPayload(String email,String password){
        return "{\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";
    }
    public String loginUserPayload(String email,String password){
        return "{\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";
    }




}
