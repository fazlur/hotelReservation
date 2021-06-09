package api;

public class AdminResource {
    private static AdminResource adminResource;

    public static AdminResource getInstance(){
        if(adminResource == null){
            adminResource = new AdminResource();
        }
        return adminResource;
    }
}
