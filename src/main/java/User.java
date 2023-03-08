public class User {
    private int id;
    private String name;
    private String surName;

    public User(int id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
