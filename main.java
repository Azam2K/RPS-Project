public class main {
    public static void main(String[] args) {
        User u = new User("azam", "mypassword");
        User u2 = new User("bob", "testpass");
        Users u1 = new Users();
        u1.addPlayer(u);
        
        u1.addPlayer(u2);

       System.out.println(u.toString());
       System.out.println(u2.toString());

       System.out.println(u1.findUser("azamm"));
       
    
        
    }
}
