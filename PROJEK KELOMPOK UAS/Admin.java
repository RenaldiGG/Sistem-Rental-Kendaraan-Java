class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public boolean login(String user, String pass) {
        return username.equals(user) &&
               password.equals(pass);
    }
}
